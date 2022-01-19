package com.shenxian.starter.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shenxian.starter.annotation.Encrypt;
import com.shenxian.starter.properties.EncryptProperties;
import com.shenxian.starter.utils.AESUtil;
import com.shenxian.starter.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 接口加密
 *
 * @author: shenxian
 * @date: 2022/1/19 10:04
 */
@EnableConfigurationProperties(EncryptProperties.class)
@ControllerAdvice
public class EncryptResponse implements ResponseBodyAdvice<RespBean> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    EncryptProperties encryptProperties;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.hasMethodAnnotation(Encrypt.class);
    }

    @Override
    public RespBean beforeBodyWrite(RespBean respBean, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        byte[] keyBytes = encryptProperties.getKey().getBytes();
        try {
            if (respBean.getMessage() != null) {
                respBean.setMessage(AESUtil.encrypt(respBean.getMessage().getBytes(), keyBytes));
            }
            if (respBean.getData() != null) {
                respBean.setData(AESUtil.encrypt(objectMapper.writeValueAsBytes(respBean.getData()), keyBytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respBean;
    }
}
