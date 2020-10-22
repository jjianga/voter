package org.jjianga.voter.util;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 从 HttpServletRequest 获取特定数据
 * @author Mails-002
 *
 */
public class CommonUtil {

    public static int getUserId(HttpServletRequest request) {
        return (int) request.getAttribute("userId");
    }

    public static String getOrderId(int gameId, String userId) {
        if (userId.length() > 4) {
            userId = userId.substring(userId.length() - 4);
        } else {
            userId = String.format("%04d", Integer.parseInt(userId));
        }
        String time = TimeUtils.getNowString(new SimpleDateFormat("MMdd"));

        int rand = CommonUtil.getRand(99999, 10000);

        String nowTime = String.valueOf(System.currentTimeMillis()).substring(5);
        StringBuffer orderId = new StringBuffer();
        orderId.append(time);
        orderId.append(rand);
        orderId.append(userId);
        orderId.append(nowTime);
        orderId.append(gameId);
        return orderId.toString();
    }

    public static int getRand(int max, int min) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        ip = ip.replace(" ", "");
        ip = ip.replace(",127.0.0.1", "");
        ip = ip.replace("127.0.0.1,", "");
        if (ip == null || ip.length() == 0) {
            ip = "127.0.0.1";
        }
        return ip;
    }

}

