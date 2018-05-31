package com.generator.codegen.configuration;

import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTempleteConfig {

    @Bean
    public RestTemplate restTemplate() {
        //连接池
        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        httpClientConnectionManager.setMaxTotal(1000);
        httpClientConnectionManager.setDefaultMaxPerRoute(1000);
        //开启重试
        DefaultHttpRequestRetryHandler httpRequestRetryHandler = new DefaultHttpRequestRetryHandler(2, true);
        CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(httpClientConnectionManager).setRetryHandler(httpRequestRetryHandler).setDefaultCredentialsProvider(provider()).useSystemProperties().build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactoryDigestAuth(client);
        requestFactory.setConnectTimeout(10000);
        requestFactory.setReadTimeout(20000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        List messageConverters = new ArrayList();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        List supportedMediaTypes = new ArrayList();
        supportedMediaTypes.add("application/json;charset=UTF-8");
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        messageConverters.add(stringHttpMessageConverter);
        restTemplate.setMessageConverters(messageConverters);
/*        List<ClientHttpRequestInterceptor>  interceptorList = new ArrayList<ClientHttpRequestInterceptor>();
        interceptorList.add(new FollowAgentInterceptor());
        restTemplate.setInterceptors(interceptorList);*/
        return restTemplate;
    }

    private CredentialsProvider provider() {
        CredentialsProvider provider = new BasicCredentialsProvider();
        return provider;
    }
}