package org.jjianga.voter.service.send;

import org.jjianga.voter.util.CRC16Util;
import org.jjianga.voter.util.RandomStringGenerator;
import org.jjianga.voter.util.StringToHex;

public class SendStopVote extends SendMessage{
    final static String type = "A002";
    final String reportKey = RandomStringGenerator.uuid();   //主键编号
    final long time = System.currentTimeMillis();  // 发送时间
    String playerNo;    //选手编号
    String crc;

    public static String getType() {
        return type;
    }

    public String getReportKey() {
        return reportKey;
    }

    public String getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(String playerNo) {
        this.playerNo = playerNo;
    }

    public long getTime() {
        return time;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    @Override
    public byte[] toMessageByte() {
        StringBuilder stringBuilder = new StringBuilder(RandomStringGenerator.stringFormat0(4, this.type))
                .append( this.reportKey)
                .append(RandomStringGenerator.stringFormat0(4, this.playerNo))
                .append(time/1000);
        stringBuilder.append(this.crc = CRC16Util.crc(stringBuilder.toString()));
        return StringToHex.hexStringToByteArray(stringBuilder.toString());
    }
}
