package com.conduktor.kafka.util;

import com.kafka.constant.KafkaConstants;
import com.kafka.constant.KafkaPropertyConstants;
import java.util.Properties;

public class KafkaUtil {
    static Properties properties = null;
    public static Properties initializeKafkaProperties() {
        if(properties == null ){
            properties = new Properties();
            //Connect to Conduktor-Upstash PlayGround
            properties.setProperty(KafkaPropertyConstants.BOOSTRAP_SERVERS_KEY.getValue(), KafkaPropertyConstants.BOOSTRAP_SERVERS_VALUE.getValue());
            properties.setProperty(KafkaPropertyConstants.SASL_MECHANISM_KEY.getValue(), KafkaPropertyConstants.SASL_MECHANISM_VALUE.getValue());
            properties.setProperty(KafkaPropertyConstants.SECURITY_PROTOCOL_KEY.getValue(), KafkaPropertyConstants.SECURITY_PROTOCOL_VALUE.getValue());
            properties.setProperty(KafkaPropertyConstants.SASL_JAAS_CONFIG_KEY.getValue(), KafkaPropertyConstants.SASL_JAAS_CONFIG_VALUE.getValue());

            //Set Producer Properties
            properties.setProperty(KafkaPropertyConstants.KEY_SERIALIZER.getValue(), KafkaPropertyConstants.STRING_SERIALIZER_CLASS.getValue());
            properties.setProperty(KafkaPropertyConstants.VALUE_SERIALIZER.getValue(), KafkaPropertyConstants.STRING_SERIALIZER_CLASS.getValue());

            //Set Consumer Properties
            properties.setProperty(KafkaPropertyConstants.KEY_DESERIALIZER.getValue(), KafkaPropertyConstants.STRING_DESERIALIZER_CLASS.getValue());
            properties.setProperty(KafkaPropertyConstants.VALUE_DESERIALIZER.getValue(), KafkaPropertyConstants.STRING_DESERIALIZER_CLASS.getValue());

            //For Producer Config
            properties.setProperty(KafkaPropertyConstants.BATCH_SIZE_KEY.getValue(), KafkaConstants.BATCH_SIZE_DEFAULT);

            //For Consumer Config
            properties.setProperty(KafkaPropertyConstants.GROUP_ID_KEY.getValue(), KafkaConstants.GROUP_ID_DEFAULT);
            properties.setProperty(KafkaPropertyConstants.AUTO_OFFSET_RESET_KEY.getValue(), KafkaConstants.AUTO_OFFSET_RESET_EARLIEST);

            return properties;
        }
        else {
            return properties;
        }
    }
}
