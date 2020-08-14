package com.kings.base.infrastructure.converter;

import com.kings.base.infrastructure.vo.RequestVO;
import com.kings.base.infrastructure.vo.ResponseVO;

/**
 * Created on 2019/11/18.
 */
public interface DataCrypto {

    /**
     * 验签&解密
     * @param aClass
     * @param requestVO
     * @return
     */
    boolean checkSignAndDecrypt(Class aClass, RequestVO requestVO);

    /**
     * 加密&签名
     * @param responseVO
     * @return
     */
    boolean signAndEncrypt(ResponseVO responseVO);

}
