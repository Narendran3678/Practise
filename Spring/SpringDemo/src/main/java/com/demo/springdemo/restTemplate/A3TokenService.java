package com.demo.springdemo.restTemplate;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class A3TokenService {
    public static final String idmsCorpUrl = "https://idmsservice-uat.corp.apple.com/auth/apptoapp/token/generate";
    private final RestTemplate restTemplate;
    @Autowired
    public A3TokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateA3Token(Long senderAppId, String senderPassword, Long receiverAppId, String a3TokenContext) throws Exception {
        String responseXml = null;
        try {
            A3TokenRequest a3TokenRequest = new A3TokenRequest(senderAppId,senderPassword,a3TokenContext,receiverAppId,1L);
            String requestBody = new Gson().toJson(a3TokenRequest);
            System.out.println("A3TokenGen Request["+requestBody+"]");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(requestBody ,headers);
            responseXml = restTemplate.postForObject(idmsCorpUrl, entity,String.class);
            System.out.println(responseXml);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return responseXml;
    }
}
