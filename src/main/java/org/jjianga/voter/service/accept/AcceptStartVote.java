package org.jjianga.voter.service.accept;

import org.jjianga.voter.entity.BestObject;
import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.netty.VoteCenters;
import org.jjianga.voter.util.CRC16Util;
import org.jjianga.voter.util.RandomStringGenerator;
import org.jjianga.voter.util.StringToHex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AcceptStartVote extends AcceptMessage{

    private static final Logger logger = LoggerFactory.getLogger(AcceptStartVote.class);

    final static String type = "B001";

    int reportKey = 32, result= 2;

    @Override
    public boolean isType(String type) {
        return AcceptStartVote.type.equals(type);
    }

    @Override
    public BestObject getAcceptMessage(String type, String message) {
        // 收到开始投票信息响应
        int off = this.initOff;
        String rk = message.substring(off, off += reportKey);
        int resultState = Integer.parseInt(message.substring(off, off += result));
        // 消息验证
        String crc = message.substring(off, off + 4);
        String crcVString = message.substring(0, off);
        logger.info(crcVString);
        String crcV = RandomStringGenerator.stringFormat0(4, CRC16Util.crc(crcVString));
        if(crcV.equals(crc)){
            logger.info("校验正确！");
            // 投票已经开始
            if(VoteCenters.state == VoteCenters.VOTE_READY_START){
                VoteCenters.state = VoteCenters.VOTE_START;
                logger.info("响应结果：{}",resultState);
                if(resultState != 0){
                    VoteCenters.state = 0; //发起投票失败了, 重置投票状态
                    VoteCenters.errState = 1;
                    VoteCenters.stateMessage = "[开始投票操作]，投票器错误代码：" + resultState + ",如果故障已处理请忽略！";
                } else {
                    VoteCenters.errState = 0;
                }
            } else {
                //TODO 是否需要响应错误原因，  包括设备反馈的
                logger.error("状态不是预备状态：{}！",VoteCenters.state);
            }

        }else{
            logger.error("接收的CRC：{},计算得出的crc：{}", crc, crcV);
        }
        return null;
    }

    @Override
    public byte[] responseAcceptMessage(BestObject bestObject) {
        //收到响应消息 不需要回馈
        return null;
    }

}
