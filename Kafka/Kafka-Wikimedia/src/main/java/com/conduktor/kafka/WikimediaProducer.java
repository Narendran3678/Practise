package com.conduktor.kafka;

import com.conduktor.kafka.util.KafkaUtil;
import com.kafka.constant.KafkaConstants;
import com.kafka.constant.KafkaTopic;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
    public static void wikiMediaEvent(boolean enableCallback,boolean enableMessageWithKey) throws InterruptedException {
        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);
        WikimediaHandler eventHandler = new WikimediaHandler(producer);
        eventHandler.setTopic(KafkaTopic.KAFKA_MY_FIRST_TOPIC.getValue());
        eventHandler.setEnableCallback(true);

        EventSource.Builder eventSourceBuilder = new EventSource.Builder( URI.create(KafkaConstants.WIKIMEDIA_DATA_STREAM_URL));
        BackgroundEventSource backgroundEventSource = new BackgroundEventSource.Builder(eventHandler,eventSourceBuilder).build();
        backgroundEventSource.start();

        TimeUnit.SECONDS.sleep(10);
    }
}
