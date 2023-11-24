package com.mu.handler;

import com.mu.annotation.ResponseResult;
import com.mu.responseUtil.R;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * 使用 @ControllerAdvice & ResponseBodyAdvice
 * 拦截Controller方法默认返回参数，统一处理返回值/响应体
 * 实现ResponseBodyAdvice接口，重写其方法
 */
@ControllerAdvice("com.mu.controller")
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    // 判断是否要执行 beforeBodyWrite 方法，true为执行，false不执行，有注解标记的时候处理返回值
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method = methodParameter.getMethod();//获取这个参数所在的方法类
        //通过方法类来判断该方法或者该方法所在的类是否包含该注解，包含该注解，返回true，执行下面的方法，否则下面的方法不执行
        if (method.isAnnotationPresent(ResponseResult.class) || method.getDeclaringClass().isAnnotationPresent(ResponseResult.class)) {
            return true;
        }
        return false;
    }

    // 对返回值做包装处理，如果属于异常结果，则需要再包装
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof R || body instanceof String) {
            return body;
        }
        return R.ok().data(body);
    }
}
