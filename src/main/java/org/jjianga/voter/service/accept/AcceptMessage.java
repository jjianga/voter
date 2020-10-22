package org.jjianga.voter.service.accept;

import org.jjianga.voter.entity.BestObject;
import org.jjianga.voter.util.CRC16Util;
import org.jjianga.voter.util.StringToHex;

import java.util.UUID;

public abstract class AcceptMessage {

    protected int initOff = 4;

    /**
     *  类型判断
     * @return
     */
    public abstract boolean isType(String type);

    /**
     *  获取转换后的对象
     * @return
     */
    public abstract BestObject getAcceptMessage(String type, String message);

    /**
     * 转换响应的消息
     * @param bestObject
     * @return
     */
    public abstract byte[] responseAcceptMessage(BestObject bestObject);

}
