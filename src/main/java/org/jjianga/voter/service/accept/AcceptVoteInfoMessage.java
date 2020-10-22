package org.jjianga.voter.service.accept;

import org.jjianga.voter.entity.BestObject;
import org.jjianga.voter.entity.VoteInfo;
import org.jjianga.voter.service.VoteInfoService;
import org.jjianga.voter.util.CRC16Util;
import org.jjianga.voter.util.RandomStringGenerator;
import org.jjianga.voter.util.StringToHex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * 收到投票信息
 */
@Service
public class AcceptVoteInfoMessage extends AcceptMessage{

    private static final Logger logger = LoggerFactory.getLogger(AcceptVoteInfoMessage.class);

    @Autowired
    VoteInfoService voteInfoService;

    final static String type = "A003";

    int reportKey = 32, deviceNo = 4, playerNo=4, result= 2, voteTime = 10, createTime =10;

    @Override
    public boolean isType(String type) {
        if(this.type.equals(type)){
            return true;
        }
        return false;
    }

    @Override
    public BestObject getAcceptMessage(String type, String message) {
        int off = 4;
        VoteInfo voteInfo = new VoteInfo();
        voteInfo.setReportKey(message.substring(off, off += reportKey));
        voteInfo.setDeviceNo(message.substring(off, off += deviceNo));
        voteInfo.setPlayerNo(Integer.parseInt(message.substring(off, off += playerNo)));
        voteInfo.setResult(Integer.parseInt(message.substring(off, off += result)));
        voteInfo.setVoteTime(new Date(Long.parseLong(message.substring(off, off += voteTime) + "000")));
        voteInfo.setCreateTime(new Date(Long.parseLong(message.substring(off, off += createTime) + "000")));

        // 消息验证
        String crc = message.substring(off, off + 4);
        String crcVString = message.substring(0, off);
        logger.info(crcVString);
        String crcV = RandomStringGenerator.stringFormat0(4, CRC16Util.crc(crcVString));
        if(crcV.equals(crc)){
            logger.info("校验正确！");
            //TODO 压入数据库 是否验证一下是否是当前选手
            try{
                voteInfoService.addVoteInfo(voteInfo);
            }catch (DuplicateKeyException duplicateKeyException){
                logger.warn("数据唯一索引冲突！", duplicateKeyException);
            }
        }else{
            logger.error("接收的CRC：{},计算得出的crc：{}", crc, crcV);
        }
        return voteInfo;
    }

    @Override
    public byte[] responseAcceptMessage(BestObject bestObject) {
        VoteInfo voteInfo = (VoteInfo)bestObject;
        StringBuffer str = new StringBuffer("B003")
                .append(voteInfo.getReportKey())
                .append(RandomStringGenerator.stringFormat0(2,"1"));
        str.append(RandomStringGenerator.stringFormat0(4, CRC16Util.crc(str.toString())));
        String sendString = str.toString();
        logger.info("响应报文：{}", sendString);
        byte[] bt = StringToHex.hexStringToByteArray(sendString);
        logger.info("响应Bit：{}", Arrays.toString(bt));
        return bt;
    }

}
