package com.springboot.SpringBootDemo.beans;

public class ThirdPartyBean {

    public String sendDocument() {
        System.out.println("Third Party Bean sent a document");
        return "Third Party Bean sent a document";
    }
}
