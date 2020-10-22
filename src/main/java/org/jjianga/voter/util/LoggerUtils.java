package org.jjianga.voter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 特定错误日志类
 * @author Mails-002
 *
 */
@Component
public class LoggerUtils {
    Logger msgLog = LoggerFactory.getLogger("MsgLog");
    Logger consoleLog = LoggerFactory.getLogger("ConsoleLog");
    Logger errorLog = LoggerFactory.getLogger("ErrorLog");
    Logger orderLog = LoggerFactory.getLogger("OrderLog");
    Logger merchantLog = LoggerFactory.getLogger("MerchantLog");

    public void merchantInfo(String msg) {
        merchantLog.info(msg);
    }

    public void merchantDebug(String msg) {
        merchantLog.debug(msg);
    }

    public void merchantError(String msg) {
        merchantLog.error(msg);
    }


    public void mswInfo(String msg) {
        msgLog.info(msg);
    }

    public void mswDebug(String msg) {
        msgLog.debug(msg);
    }

    public void mswError(String msg) {
        msgLog.error(msg);
    }

    public void errrorInfo(String msg) {
        errorLog.info(msg);
    }

    public void errrorDebug(String msg) {
        errorLog.debug(msg);
    }

    public void errrorError(String msg) {
        errorLog.error(msg);
    }

    public void orderInfo(String msg) {
        orderLog.info(msg);
    }

    public void orderDebug(String msg) {
        orderLog.debug(msg);
    }

    public void orderError(String msg) {
        orderLog.error(msg);
    }

}
