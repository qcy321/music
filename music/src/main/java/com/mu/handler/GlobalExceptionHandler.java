package com.mu.handler;

import com.mu.exception.BizException;
import com.mu.responseUtil.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/**
 * 全局异常处理类
 *
 * @author sw-code
 * @RestControllerAdvice(@ControllerAdvice)，拦截异常并统一处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     *
     * @param e       异常对象
     * @param request request
     * @return 错误结果
     */
    @ExceptionHandler(BizException.class)
    public R bizExceptionHandler(BizException e, HttpServletRequest request) {
        log.error("发生业务异常！原因是: {}", e.getMessage());
        return R.serviceError();
    }

    // 拦截抛出的异常，@ResponseStatus：用来改变响应状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public R handlerThrowable(Throwable e, HttpServletRequest request) {
        log.error("发生未知异常！原因是: ", e);
        return R.error();
    }

    // 参数校验异常
    @ExceptionHandler(BindException.class)
    public R handleBindException(BindException e, HttpServletRequest request) {
        log.error("发生参数校验异常！原因是：", e);
        return R.params_error(4);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("发生参数校验异常！原因是：", e);
        return R.params_error(1);
    }
}
