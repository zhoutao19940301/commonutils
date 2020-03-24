package com.zmm.commonutils.exception;

/**
 * 参数错误异常类
 *
 * @author lzy
 */
public class BaseRuntimeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -4132022779668009005L;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误详情;
     */
    private String message = "";

    /**
     * 参数信息
     */
    private String paraName = "";

    /**
     *
     *
     * @param message String
     */
    public BaseRuntimeException(String message)
    {
        super(message);
    }

    /**
     * 带错误码和参数名称的构造函数
     *
     * @param code 错误码
     * @param paraName 参数名称
     * @param paraName 详细描述信息
     */
    public BaseRuntimeException(String code, String message, String paraName)
    {
        this(message);
        this.code = code;
        this.message = message;
        this.paraName = paraName;
    }

    /**
     * 带错误码和参数名称的构造函数
     *
     * @param code 错误码
     * @param message 参数名称
     */
    public BaseRuntimeException(String code, String message)
    {
        this(code, message, "");
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getParaName()
    {
        return paraName;
    }

    public void setParaName(String paraName)
    {
        this.paraName = paraName;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

}
