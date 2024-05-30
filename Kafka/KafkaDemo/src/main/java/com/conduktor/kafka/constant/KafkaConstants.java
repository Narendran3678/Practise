package com.conduktor.kafka.constant;

import org.apache.kafka.common.serialization.StringSerializer;

public enum KafkaConstants {
    BOOSTRAP_SERVERS_KEY("bootstrap.servers"), BOOSTRAP_SERVERS_VALUE("native-crawdad-13875-us1-kafka.upstash.io:9092"),
    SASL_MECHANISM_KEY("sasl.mechanism"), SASL_MECHANISM_VALUE("SCRAM-SHA-256"),
    SECURITY_PROTOCOL_KEY("security.protocol"), SECURITY_PROTOCOL_VALUE("SASL_SSL"),
    SASL_JAAS_CONFIG_KEY("sasl.jaas.config"), SASL_JAAS_CONFIG_VALUE("org.apache.kafka.common.security.scram.ScramLoginModule required username=\"bmF0aXZlLWNyYXdkYWQtMTM4NzUkcjT0tsf08zZH49ujrl5F7RyWwm8f_wf01zI\" password=\"ZThjNzMyZTQtN2ExYi00ZGQ2LTg4YTYtNTIwZmNjZDQ3YTI4\";"),
    KEY_SERIALIZER("key.serializer"), VALUE_SERIALIZER("value.serializer"), STRING_SERIALIZER_CLASS(StringSerializer.class.getName()),
    BATCH_SIZE_KEY("batch.size"),BATCH_SIZE_VALUE("10")
    ;
    private final String value;
    KafkaConstants(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
