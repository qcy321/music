package com.mu.responseUtil;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    /* 成功状态码 */
    SUCCESS(200, "成功"),
    /* 参数错误 */
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    /* 用户错误 2001-2999*/
    USER_NO_LOGIN(2001, "用户未登录"),
    USER_LOGIN_ERROR(2002, "账号不存在或密码错误"),
    SYSTEM_ERROR(10000, "系统异常，请稍后重试"),

    SERVICE_ERROR(300, "业务异常"),

    UNKNOWN_ERROR(400, "未知错误");
   /*
    SUCCESS(200, "成功"),
    UNKNOWN_ERROR(400, "未知错误"),
    PARAM_ERROR(401, "参数错误"),
    NULL_POINT(402, "空指针异常"),
    HTTP_CLIENT_ERROR(404, "客户端连接异常");*/

    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
