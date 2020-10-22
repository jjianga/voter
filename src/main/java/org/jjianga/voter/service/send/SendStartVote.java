package org.jjianga.voter.service.send;

import org.jjianga.voter.util.CRC16Util;
import org.jjianga.voter.util.RandomStringGenerator;
import org.jjianga.voter.util.StringToHex;

public class SendStartVote extends SendMessage{
    final static String type = "A001";
    final String reportKey = RandomStringGenerator.uuid();
    final long time = System.currentTimeMillis();
    String playerNo;
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
        this.crc = CRC16Util.crc(stringBuilder.toString());
        stringBuilder.append(RandomStringGenerator.stringFormat0(4, this.crc));
        return StringToHex.hexStringToByteArray(stringBuilder.toString());
    }
}
