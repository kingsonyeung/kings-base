package com.kings.base.infrastructure.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kings.base.infrastructure.vo.RequestVO;
import com.kings.base.infrastructure.vo.ResponseVO;
import org.springframework.util.Base64Utils;

import java.util.Objects;

/**
 * Created on 2019/11/18.
 */
public class DataCryptoImpl implements DataCrypto {

    /**
     * 解密
     * @param aClass
     * @param requestVO
     * @return
     */
    @Override
    public boolean checkSignAndDecrypt(Class aClass, RequestVO requestVO) {
        byte[] bytes = Base64Utils.decodeFromString(requestVO.getPayload().toString());
        String payload = new String(bytes);
        requestVO.setPayload(JSONObject.parseObject(payload, aClass));
        return true;
    }

    /**
     * 加密
     * @param responseVO
     * @return
     */
    @Override
    public boolean signAndEncrypt(ResponseVO responseVO) {
        if (Objects.nonNull(responseVO.getData())) {
            String data = JSON.toJSONString(responseVO.getData());
            responseVO.setData(Base64Utils.encodeToString(data.getBytes()));
        }
        return true;
    }

    public static void main(String[] args) {
        String content = "{\"id\": 1,\"name\": \"xxxx\"}";
        byte[] bytes = Base64Utils.decodeFromString(content);
        String payload = new String(bytes);
        System.out.println(payload);
    }
}
