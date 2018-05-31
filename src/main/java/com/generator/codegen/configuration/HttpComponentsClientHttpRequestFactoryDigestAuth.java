package com.generator.codegen.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.net.URI;

public class HttpComponentsClientHttpRequestFactoryDigestAuth extends HttpComponentsClientHttpRequestFactory {

    public HttpComponentsClientHttpRequestFactoryDigestAuth(HttpClient client) {
        super(client);
    }

    @Override
    protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
        return createHttpContext(uri);
    }

    private HttpContext createHttpContext(URI uri) {
        BasicHttpContext localcontext = new BasicHttpContext();
        return localcontext;
    }
}
