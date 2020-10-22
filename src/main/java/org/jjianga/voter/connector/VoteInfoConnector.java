package org.jjianga.voter.connector;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jjianga.voter.entity.AthleteInfo;
import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.netty.SocketGroup;
import org.jjianga.voter.netty.VoteCenters;
import org.jjianga.voter.service.AthleteInfoService;
import org.jjianga.voter.service.VoteInfoService;
import org.jjianga.voter.service.send.SendStartVote;
import org.jjianga.voter.service.send.SendStopVote;
import org.jjianga.voter.util.BaseResultModel;
import org.jjianga.voter.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "投票详细数据接口")
@RestController
@RequestMapping("VoteInfoConnector")
public class VoteInfoConnector {
    final
    VoteInfoService voteInfoService;
    final
    AthleteInfoService athleteInfoService;

    public VoteInfoConnector(VoteInfoService voteInfoService, AthleteInfoService athleteInfoService) {
        this.voteInfoService = voteInfoService;
        this.athleteInfoService = athleteInfoService;
    }

    @PostMapping(value = "uploadingVoteInfo")
    @ApiOperation(value="上传投票信息数据", notes="上传投票信息数据")
    public BaseResultModel<Integer> uploadingVoteInfo(VoteInfo voteInfo){
        return new BaseResultModel<>(200, "上传成功", voteInfoService.uploadingVoteInfo(voteInfo));
    }

    @PostMapping(value = "startVote")
    @ApiOperation(value="开始投票", notes="开始投票")
    public BaseResultModel<Integer> startVote(String playerName){
        if(playerName == null)
            return new BaseResultModel<>().setRet(500).setMsg("开始投票失败,没有选手名称参数");
        // 解析选手信息
        VoteCenters.athleteInfo = this.athleteInfoService.getAthleteInfoByName(playerName);
        if(VoteCenters.athleteInfo == null)new BaseResultModel<>().setRet(201).setMsg("开始投票失败没有该选手");
        // 通知设备开始投票
        VoteCenters.startVote();
        return new BaseResultModel<>().setRet(200).setMsg("投票开始");
    }

    @PostMapping(value = "stopVote")
    @ApiOperation(value="结束投票", notes="结束投票")
    public BaseResultModel<Integer> stopVote(String playerName){
        if(playerName == null)
            return new BaseResultModel<>().setRet(500).setMsg("结束投票失败,没有选手名称参数");
        // 解析选手信息
        if(VoteCenters.athleteInfo!=null && playerName.equals(VoteCenters.athleteInfo.getName()))
            VoteCenters.athleteInfo = this.athleteInfoService.getAthleteInfoByName(playerName);
        if(VoteCenters.athleteInfo == null)return new BaseResultModel<>().setRet(201).setMsg("结束投票失败没有该选手");
        // 通知设备结束投票
        VoteCenters.endVote();
        return new BaseResultModel<>().setRet(200).setMsg("投票结束");
    }

    @PostMapping(value = "synchronizationVote")
    @ApiOperation(value="同步投票状态", notes="同步投票状态")
    public BaseResultModel<Integer> synchronizationVote(String playerName){
        if(playerName == null)
            return new BaseResultModel<>().setRet(500).setMsg("同步失败,没有选手名称参数");
        // 解析选手信息
        if(VoteCenters.athleteInfo ==null || playerName.equals(VoteCenters.athleteInfo.getName()))
            VoteCenters.athleteInfo = this.athleteInfoService.getAthleteInfoByName(playerName);
        if(VoteCenters.athleteInfo == null)return new BaseResultModel<>().setRet(201).setMsg("同步失败没有该选手");
        //  同步需要的信息  1.机器是否在投票状态了
        return new BaseResultModel<>(200, "同步成功", VoteCenters.state);
    }

    //票数重置
    @PostMapping(value = "resetVote")
    @ApiOperation(value="重置投票", notes="重置投票")
    public BaseResultModel<Integer> resetVote(String playerName){
        if(playerName == null)
            return new BaseResultModel<>().setRet(500).setMsg("重置失败,没有选手名称参数");
        // 解析选手信息
        if(VoteCenters.athleteInfo == null || playerName.equals(VoteCenters.athleteInfo.getName()))
            VoteCenters.athleteInfo = this.athleteInfoService.getAthleteInfoByName(playerName);
        if(VoteCenters.athleteInfo == null)return new BaseResultModel<>().setRet(201).setMsg("重置失败没有该选手");
        // 清除已经投票的票数
        return new BaseResultModel<>(200, "投票重置成功", voteInfoService.deleteVoteInfo());
    }

    @PostMapping(value = "getScore")
    @ApiOperation(value="查询投票数", notes="查询投票数")
    public BaseResultModel<Integer> getScore(String playerName){
        if(playerName == null)
            return new BaseResultModel<>().setRet(500).setMsg("查询投票数失败,没有选手名称参数");
        // 解析选手信息
        if(VoteCenters.athleteInfo == null || playerName.equals(VoteCenters.athleteInfo.getName()))
            VoteCenters.athleteInfo = this.athleteInfoService.getAthleteInfoByName(playerName);
        if(VoteCenters.athleteInfo == null)return new BaseResultModel<>().setRet(201).setMsg("查询投票数失败没有该选手");
        // 查询已经投票的票数
        return new BaseResultModel<>(200, "查询票数成功", voteInfoService.getScore(VoteCenters.athleteInfo.getId()));
    }

    @PostMapping(value = "getVoteDevice")
    @ApiOperation(value="查询连接设备信息", notes="查询连接设备信息")
    public BaseResultModel<Integer> getVoteDevice(){
        if(SocketGroup.channelGroup.size() == 0){ //设备socket没有连接到
            return new BaseResultModel<>().setRet(201).setMsg("投票设备断开连接！");
        }
        if(VoteCenters.errState > 0){ // 发送错误，投票器响应错误
            return new BaseResultModel<>().setRet(202).setMsg(VoteCenters.stateMessage).setData(VoteCenters.errState);
        }
        if(VoteCenters.errState == -1){ //不是默认状态，发起了投票， 不是是投票状态发起了停止投票
            return new BaseResultModel<>(200, VoteCenters.stateMessage, SocketGroup.channelGroup.size());
        }
        return new BaseResultModel<>(200, "当前连接投票设备：", SocketGroup.channelGroup.size());
    }
}
