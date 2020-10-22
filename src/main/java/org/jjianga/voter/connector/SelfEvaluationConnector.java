package org.jjianga.voter.connector;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jjianga.voter.enums.PLAYER_STATE;
import org.jjianga.voter.util.BaseResultModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "选手自评消息")
@RestController
@RequestMapping("SelfEvaluationConnector")
public class SelfEvaluationConnector {
    private static int playerState;  //自评状态 1，自评中 2.自评结束 3.
    private static int score = -1;   //自评分数
    private static String playerName;   //选手名称

    @PostMapping(value = "startSelfEvaluation")
    @ApiOperation(value="工作人员 发起自评", notes="工作人员 发起自评")
    public BaseResultModel<String> startSelfEvaluation(String playerName){
        BaseResultModel<String> baseResultModel = new BaseResultModel<>();
        if(null == playerName){
            return baseResultModel.setRet(500).setMsg("发起失败，选手名为空！");
        }
        if(playerState == PLAYER_STATE.DEFAULT_STAGE.state || playerState == 4){
            this.playerName = playerName;
            this.playerState = 1;
            baseResultModel.setRet(200).setMsg("发起成功！");
        }else{
            baseResultModel.setRet(200).setMsg("发起成功，上一个自评没有被关闭:" + this.playerName);
        }
        return baseResultModel;
    }

    @PostMapping(value = "getScoreSelfEvaluation")
    @ApiOperation(value=" 工作人员端拉取自评消息", notes="工作人员端拉取自评消息")
    public BaseResultModel<Integer> getScoreSelfEvaluation(String playerName){
        BaseResultModel<Integer> baseResultModel = new BaseResultModel<>();
        if(playerName.equals(this.playerName)){
            baseResultModel.setRet(200).setMsg("拉取自评成功！").setData(this.score);
            //玩家自评分数字后
            if( this.playerState == 2){
                this.playerState = 3;
            }
        }else {
            baseResultModel.setRet(500).setMsg("拉取自评失败,自评选手信息异常：" + this.playerName).setData(this.score);
        }
        return baseResultModel;
    }

    @PostMapping(value = "stopSelfEvaluation")
    @ApiOperation(value="工作人员 结束自评", notes="工作人员 结束自评")
    public BaseResultModel<String>  stopSelfEvaluation(String playerName){
        BaseResultModel<String> baseResultModel = new BaseResultModel<>();
        if(null == playerName){
            return baseResultModel.setRet(500).setMsg("结束自评失败，选手名参数为空！");
        }
        if(this.playerState == 1 || this.playerState == 2 || this.playerState == 3 ){
            if(playerName.equals(this.playerName)){
                this.score = -1;
                this.playerState = 0;
                return baseResultModel.setRet(200).setMsg("结束自评成功！");
            }
        }
        return baseResultModel.setRet(201).setMsg("结束自评失败,选手自评信息异常：" + this.playerName);
    }

    @PostMapping(value = "submitSelfEvaluation")
    @ApiOperation(value=" 提交自评", notes=" 提交自评")
    public BaseResultModel<String> submitSelfEvaluation(int score, String playerName){
        BaseResultModel<String> baseResultModel = new BaseResultModel<>();
        if(null == playerName){
            return baseResultModel.setRet(500).setMsg("提交自评失败，选手名参数为空！");
        }
        if(this.playerState != 1){
            return baseResultModel.setRet(500).setMsg("当前状态不允许提交，当前状态：" + this.playerState);
        }
        if(!playerName.equals(this.playerName)){
            return baseResultModel.setRet(500).setMsg("自评失败,自评选手信息异常：" + this.playerName);
        }
        this.score = score;
        this.playerState = 2;
        return baseResultModel.setRet(200).setMsg("自评成功!");
    }

    @PostMapping(value = "getSelfEvaluationName")
    @ApiOperation(value="获取当前自评选手", notes="获取当前自评选手")
    public BaseResultModel<Integer> getSelfEvaluationName(){
        BaseResultModel<Integer> baseResultModel = new BaseResultModel<>();
        return baseResultModel.setRet(200).setMsg(this.playerName).setData(this.playerState);
    }

}
