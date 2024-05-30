package com.conduktor.kafka.constant;

public enum KafkaTopic {
    KAFKA_MY_FIRST_TOPIC("my-first-topic"),
    KAFKA_MY_SECOND_TOPIC("my-second-topic"),
    KAFKA_MY_THIRD_TOPIC("my-third-topic");
    private final String value;
    KafkaTopic(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
