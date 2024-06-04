package com.kafka.util;

import com.kafka.constant.KafkaConstants;
import com.kafka.constant.KafkaPropertyConstants;
import org.apache.kafka.clients.producer.ProducerConfig;

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

            //Batching Mechanism
            properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG,KafkaConstants.COMPRESSION_TYPE.SNAPPY.getValue());
            properties.setProperty(ProducerConfig.LINGER_MS_CONFIG,String.valueOf(20));
            properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,Integer.toString(32 * 1024));

            //For Consumer Config
            properties.setProperty(KafkaPropertyConstants.GROUP_ID_KEY.getValue(), KafkaConstants.GROUP_ID_DEFAULT);
            properties.setProperty(KafkaPropertyConstants.AUTO_OFFSET_RESET_KEY.getValue(), KafkaConstants.AUTO_OFFSET_RESET_EARLIEST);

            //Recommended Safe Producer
            properties.setProperty(KafkaPropertyConstants.ACKS.getValue(),KafkaConstants.ACKS_ALL);
            properties.setProperty(KafkaPropertyConstants.MIN_INSYNC_REPLICAS.getValue(),String.valueOf(5));
            properties.setProperty(KafkaPropertyConstants.ENABLE_IDEMPOTENCE.getValue(), Boolean.TRUE.toString());
            properties.setProperty(KafkaPropertyConstants.RETRIES.getValue(), String.valueOf(Integer.MAX_VALUE));
            properties.setProperty(KafkaPropertyConstants.DELIVERY_TIMEOUT_MS.getValue(), String.valueOf(120000));
            properties.setProperty(KafkaPropertyConstants.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION.getValue(), String.valueOf(5));
            return properties;
        }
        else {
            return properties;
        }
    }
}
