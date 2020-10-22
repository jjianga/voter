package org.jjianga.voter.util;

/**
 * 静态码
 * @author Mails-002
 *
 */
public class StaticCode {

    public static boolean ADVERLISTOPEN = true;

    public static boolean SHARELISTOPEN = true;

    public static boolean SHAREOPEN = false;

    public static boolean DELAYOPEN = false;
    
    /**
     * 	绑定状态  验证码无效
     */
    public final static int ERROR_VERIFICATION_CODE_INVALID = -40001;
    /**
     * 	绑定状态  验证码异常
     */
    public final static int EXCEPTION_VERIFICATION_CODE = -40002;
    /**
     * 	登录用户 电话未注册
     */
	public static final int ERROR_NOT_REGISTER_PHOME = -40003;
	/**
	 *	 异常没有输入密码
	 */
	public static final int EXCEPTION_PASSWORD_NOT = -40004;
	/**
	 *	 错误的验证码 登录失败
	 */
	public static final int ERROR_PASSWORD_FAILE = -40005;
	/**
	 * 	电话已经注册
	 */
	public static final int ERROR_PHONE_YET_REGISTER = -40006;
	/**
	 * 	微信绑定失败 当前已经绑定
	 */
	public static final int ERROR_PHONE_BIND_WX_FILA_YET_BIND = -40007;
	/**
	 * 	微信绑定失败 当前手机未注册
	 */
	public static final int ERROR_PHONE_BIND_WX_FILA_PHONE_NO_REGISTER = -40008;
	/**
	 * 	微信 CODE 无效
	 */
	public static final int ERROR_CODE_INVALID = -40009;
    
    
    
    
    /**
     * "您的手机 和 微信都没绑定 确认合并账户
     */
    public final static int WARN_PHONE_BIND_WX_MERGE = -10001;
    /**
     * "您手机已经绑定微信， 是否合并， 更新绑定
     */
    public final static int WARN_PHONE_BIND_WX_AND_DELET_WX_UPDATE= -10002;
    /**
     * "手机没绑过微信， 微信帮过手机
     */
    public final static int WARN_PHONE_BIND_WX_IS_UPDATE_WX= -10003;
    /**
     * "微信和手机都绑定过其它账号，确定绑定吗？"
     */
	public static final int WARN_PHONE_WX_YET_BIND_IS_BIND_WX = -10004;



}
