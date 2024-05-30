package com.conduktor.kafka.util;

import com.conduktor.kafka.constant.KafkaConstants;

import java.util.Properties;

public class KafkaUtil {
    static Properties properties = null;
    public static Properties initializeKafkaProperties() {
        if(properties == null ){
            properties = new Properties();
            //Connect to Conduktor-Upstash PlayGround
            properties.setProperty(KafkaConstants.BOOSTRAP_SERVERS_KEY.getValue(),KafkaConstants.BOOSTRAP_SERVERS_VALUE.getValue());
            properties.setProperty(KafkaConstants.SASL_MECHANISM_KEY.getValue(),KafkaConstants.SASL_MECHANISM_VALUE.getValue());
            properties.setProperty(KafkaConstants.SECURITY_PROTOCOL_KEY.getValue(),KafkaConstants.SECURITY_PROTOCOL_VALUE.getValue());
            properties.setProperty(KafkaConstants.SASL_JAAS_CONFIG_KEY.getValue(),KafkaConstants.SASL_JAAS_CONFIG_VALUE.getValue());

            //Set Producer Properties
            properties.setProperty(KafkaConstants.KEY_SERIALIZER.getValue(),KafkaConstants.STRING_SERIALIZER_CLASS.getValue());
            properties.setProperty(KafkaConstants.VALUE_SERIALIZER.getValue(),KafkaConstants.STRING_SERIALIZER_CLASS.getValue());

            properties.setProperty(KafkaConstants.BATCH_SIZE_KEY.getValue(),KafkaConstants.BATCH_SIZE_VALUE.getValue());
            return properties;
        }
        else {
            return properties;
        }
    }
}
