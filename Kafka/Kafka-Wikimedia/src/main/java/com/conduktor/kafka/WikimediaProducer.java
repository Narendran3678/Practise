package com.conduktor.kafka;

import com.conduktor.kafka.util.KafkaUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

public class WikimediaProducer {
    static Properties properties;
    public static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    static  {
        // Setting Kafka Properties
        properties = KafkaUtil.initializeKafkaProperties();
    }
    public static void main(String[] args) throws Exception {
        if(properties==null)
            throw new Exception("Properties Not Initialized");
        wikiMediaEvent(true,true);
    }
    public static void wikiMediaEvent(boolean enableCallback,boolean enableMessageWithKey) {

    }
}
