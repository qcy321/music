package com.mu.responseUtil;

import com.mu.exception.OrderException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel("R响应封装")
@AllArgsConstructor
@Data
public class R {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("消息")
    private String message;

    @ApiModelProperty("响应数据")
    private Object data;

    private R() {
    }

    /**
     * 返回成功
     */
    public static R ok() {
        R res = new R();
        res.setCode(ResultCodeEnum.SUCCESS.getCode());
        res.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return res;
    }


    /**
     * 通用返回失败，未知错误
     */
    public static R error() {
        R res = new R();
        res.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        res.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return res;
    }

    /**
     * 通用返回失败，未知错误
     *
     * @param order - 1:参数无效
     *              - 2:参数为空
     *              - 3:参数类型错误
     *              - 4:参数缺失
     */
    public static R params_error(int order) {
        if (order < 0 || order > 4) {
            throw new OrderException();
        }
        R res = new R();
        switch (order) {
            case 1: {
                res.setCode(ResultCodeEnum.PARAM_IS_INVALID.getCode());
                res.setMessage(ResultCodeEnum.PARAM_IS_INVALID.getMessage());
                break;
            }
            case 2: {
                res.setCode(ResultCodeEnum.PARAM_IS_BLANK.getCode());
                res.setMessage(ResultCodeEnum.PARAM_IS_BLANK.getMessage());
                break;
            }
            case 3: {
                res.setCode(ResultCodeEnum.PARAM_TYPE_BIND_ERROR.getCode());
                res.setMessage(ResultCodeEnum.PARAM_TYPE_BIND_ERROR.getMessage());
                break;
            }
            case 4: {
                res.setCode(ResultCodeEnum.PARAM_NOT_COMPLETE.getCode());
                res.setMessage(ResultCodeEnum.PARAM_NOT_COMPLETE.getMessage());
                break;
            }
        }
        return res;
    }

    /**
     * 没有登录
     */
    public static R noLoginError() {
        R res = new R();
        res.setCode(ResultCodeEnum.USER_NO_LOGIN.getCode());
        res.setMessage(ResultCodeEnum.USER_NO_LOGIN.getMessage());
        return res;
    }

    /**
     * 登录密码或者账号错误
     */
    public static R loginError() {
        R res = new R();
        res.setCode(ResultCodeEnum.USER_LOGIN_ERROR.getCode());
        res.setMessage(ResultCodeEnum.USER_LOGIN_ERROR.getMessage());
        return res;
    }

    /**
     * 系统异常错误
     *
     * @return
     */
    public static R systemError() {
        R res = new R();
        res.setCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
        res.setMessage(ResultCodeEnum.SYSTEM_ERROR.getMessage());
        return res;
    }

    /**
     * 系统异常错误
     *
     * @return
     */
    public static R serviceError() {
        R res = new R();
        res.setCode(ResultCodeEnum.SERVICE_ERROR.getCode());
        res.setMessage(ResultCodeEnum.SERVICE_ERROR.getMessage());
        return res;
    }

    /**
     * 设置返回数据
     */
    public R data(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 设置状态码
     */
    public R code(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * 设置消息
     *
     * @param message - 消息
     */
    public R message(String message) {
        this.message = message;
        return this;
    }

}
