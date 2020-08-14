package com.kings.base.api.config;

import com.kings.base.infrastructure.converter.CryptoMessageConverter;
import com.kings.base.infrastructure.converter.DataCryptoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2019/11/20.
 */
@Configuration
public class SpringBean {

    /**
     * 类：对请求报文、响应报文进行加解密
     *
     * @return
     */
    @Bean
    public CryptoMessageConverter cryptoMessageConverter() {
        return new CryptoMessageConverter(new DataCryptoImpl());
    }

}
