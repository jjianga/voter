package org.jjianga.voter.util;

import java.util.Random;
import java.util.UUID;

/**
 	* 产生随机字符串的类
 * @author Mails-002
 *
 */
public class RandomStringGenerator {

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    public static String getRandomNumByLength(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     *  获取UUID
     * @return
     */
    public static String uuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public static String stringFormat0(int len, String str){
        return String.format("%4s", str).replaceAll("\\s", "0");
    }
}
