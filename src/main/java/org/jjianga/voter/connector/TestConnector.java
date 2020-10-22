package org.jjianga.voter.connector;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.netty.SocketGroup;
import org.jjianga.voter.service.VoteInfoService;
import org.jjianga.voter.service.send.SendMessage;
import org.jjianga.voter.service.send.SendStartVote;
import org.jjianga.voter.service.send.SendStopVote;
import org.jjianga.voter.util.BaseResultModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "")
@RestController
@RequestMapping("TestConnector")
public class TestConnector {

    @PostMapping(value = "sendTestMessage")
    @ApiOperation(value="发送测试消息", notes="发送测试消息")

    public BaseResultModel<Integer> sendTestMessage(String message){
        if(message.equals("0")){
            SendStartVote sendMessage = new SendStartVote();
            sendMessage.setPlayerNo("100");
            SocketGroup.sendMessage(sendMessage);
        }else if(message.equals("1")){
            SendStopVote sendMessage = new SendStopVote();
            sendMessage.setPlayerNo("100");
            SocketGroup.sendMessage(sendMessage);
        }
        return new BaseResultModel<>(200, "发送成功", 1);
    }
}
