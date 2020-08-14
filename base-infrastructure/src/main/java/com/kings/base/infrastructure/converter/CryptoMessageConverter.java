package com.kings.base.infrastructure.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kings.base.infrastructure.vo.RequestVO;
import com.kings.base.infrastructure.vo.ResponseVO;
import com.google.common.io.CharStreams;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 加密报文转换
 * 1、仅适用于 application/json 类型的请求
 * Created on 2019/11/21.
 */
public class CryptoMessageConverter extends MappingJackson2HttpMessageConverter {

    /**
     * http header key:判断是否需要进行加解密处理
     */
    private static final String HEADER_KEY_IS_CRYPTO = "X-IS-CRYPTO";

    private DataCrypto dataCrypto;

    public CryptoMessageConverter(DataCrypto dataCrypto) {
        super();
        this.dataCrypto = dataCrypto;
    }

    @Override
    public boolean canRead(@Nullable MediaType mediaType) {
        return super.canRead(mediaType) && isCrypto();
    }

    @Override
    public boolean canWrite(Class<?> clazz, @Nullable MediaType mediaType) {
        return super.canWrite(clazz, mediaType) && isCrypto() && ResponseVO.class.isAssignableFrom(clazz);
    }

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage httpInputMessage)
            throws IOException, HttpMessageNotReadableException {
        InputStreamReader reader = new InputStreamReader(httpInputMessage.getBody(), StandardCharsets.UTF_8);
        String body = CharStreams.toString(reader);
        RequestVO requestVO = JSON.parseObject(body, RequestVO.class);
        Class tClass = (Class) ((ParameterizedTypeImpl) type).getActualTypeArguments()[0];
        dataCrypto.checkSignAndDecrypt(tClass, requestVO);
        return requestVO;
    }

    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage httpOutputMessage)
            throws IOException, HttpMessageNotWritableException {
        ResponseVO responseVO = (ResponseVO)object;
        dataCrypto.signAndEncrypt(responseVO);
        httpOutputMessage.getBody().write(JSON.toJSONString(responseVO).getBytes("UTF-8"));
    }

//    /**
//     * 解密
//     * @param aClass
//     * @param requestVO
//     * @return
//     */
//    private boolean checkSignAndDecrypt(Class aClass, RequestVO requestVO) {
//        byte[] bytes = Base64Utils.decodeFromString(requestVO.getPayload().toString());
//        String payload = new String(bytes);
//        requestVO.setPayload(JSONObject.parseObject(payload, aClass));
//        return true;
//    }
//
//    /**
//     * 加密
//     * @param responseVO
//     * @return
//     */
//    private boolean signAndEncrypt(ResponseVO responseVO) {
//        if (Objects.nonNull(responseVO.getData())) {
//            String data = JSON.toJSONString(responseVO.getData());
//            responseVO.setData(Base64Utils.encodeToString(data.getBytes()));
//        }
//        return true;
//    }

    /**
     * 判断是否进行加解密
     * X-IS-CRYPTO=true，加密
     * X-IS-CRYPTO=false，不加密
     * X-IS-CRYPTO为空，加密
     * 其他情况，加密
     *
     * @return
     */
    private boolean isCrypto() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String isCrypto = httpServletRequest.getHeader(HEADER_KEY_IS_CRYPTO);
        if (Objects.nonNull(isCrypto)) {
            return Boolean.valueOf(isCrypto);
        }
        return true;
    }
}
