package com.xkcoding.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RestTemplateTest {
    public static void main(String[] args) {
        String url = "https://qr-test3.chinaums.com/netpay-route-server/api/";

//        JSONObject query = new JSONObject();
//        query.put("msgType","upfq.query");
//        query.put("requestTimestamp","2020-03-31 14:36:39");
//        query.put("msgSrc","WWW.TEST.COM");
//        query.put("sign","6B31FAD8D80959A658D24A820BE0AAF05516AB7F8DF5F606472FB6B92799D757");
//        put("signType","SHA256");
//        query.put("mid","777290058176453");
//        query.put("instMid","QRINSTALDEFAULT");
//        query.put("merOrderId","3194202003310000001");
//        query.put("tid","12345080");


        Map<String,String> query = new HashMap<String,String>(){{
            put("msgType","upfq.query");
            put("requestTimestamp","2020-03-31 14:36:39");
            put("msgSrc","WWW.TEST.COM");
            put("sign","6B31FAD8D80959A658D24A820BE0AAF05516AB7F8DF5F606472FB6B92799D757");
            put("signType","SHA256");
            put("mid","777290058176453");
            put("instMid","QRINSTALDEFAULT");
            put("merOrderId","3194202003310000001");
            put("tid","12345080");
        }};



        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(null, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        ResponseEntity<String> responseMsgEntity = restTemplate.postForEntity(url, query,String.class);
        String body = responseMsgEntity.getBody();


        JSONObject jsonObject =  JSONObject.parseObject(body);

        System.out.println("dfa"+jsonObject);



    }
}
