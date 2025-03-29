package com.demo.springdemo.config;
import com.demo.springdemo.interceptor.ApplicationInterceptor;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.CacheControl;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.*;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    private static final int CONNECT_TIMEOUT = 30000;
    private static final int REQUEST_TIMEOUT = 30000;
    private static final int SOCKET_TIMEOUT = 60000;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/public", "classpath:/static/")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }

    /*
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/marketing", HandlerTypePredicate.forAnnotation(Controller.class));
    }
    */

    @Bean
    public SSLContext sslContext() {
        System.out.println("Lets initialize the SSLContext ....");
        SSLContext sslContext = null;
        try {
            Path path2 = Paths.get("idmscorp.keystore");
            System.out.println("KeyStore Path :: " + path2.toAbsolutePath().toString());

            sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(
                            ResourceUtils.getFile(path2.toAbsolutePath().toString()),
                            "changeit".toCharArray()
                    ).build();
        } catch (NoSuchAlgorithmException nsex) {
            System.out.println("NoSuchAlgorithmException - "+ ExceptionUtils.getStackTrace(nsex));
        } catch (KeyManagementException kmex) {
            System.out.println("KeyManagementException - "+ ExceptionUtils.getStackTrace(kmex));
        } catch (KeyStoreException ksex) {
            System.out.println("KeyStoreException - "+ ExceptionUtils.getStackTrace(ksex));
        } catch (CertificateException cex) {
            System.out.println("CertificateException - "+ ExceptionUtils.getStackTrace(cex));
        } catch (IOException ex) {
            System.out.println("IOException - "+ ExceptionUtils.getStackTrace(ex));
        }
        System.out.println("Initialized the SSLContext ....");
        return sslContext;
    }
    
    @Bean
    @DependsOn({"sslContext"})
    public RestTemplate restTemplate(@Autowired SSLContext sslContext) {

        RestTemplate restTemplate = null;
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

        ConnectionConfig connectionConfig = ConnectionConfig
                .custom()
                .setConnectTimeout(Timeout.of(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS))
                .setSocketTimeout(Timeout.of(SOCKET_TIMEOUT, TimeUnit.MILLISECONDS))
                .build();

        HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder
                .create()
                .setDefaultConnectionConfig(connectionConfig)
                .setSSLSocketFactory(socketFactory)
                .build();

        CloseableHttpClient closeableHttpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .build();

        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(closeableHttpClient);

        restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(httpComponentsClientHttpRequestFactory));
        System.out.println("Created the restTemplate bean ....");
        return restTemplate;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApplicationInterceptor());
    }
}
