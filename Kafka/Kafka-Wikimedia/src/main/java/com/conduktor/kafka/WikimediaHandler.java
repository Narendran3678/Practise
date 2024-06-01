package com.conduktor.kafka;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WikimediaHandler implements BackgroundEventHandler {
    private KafkaProducer<String,String> producer;
    private String topic;
    private String key;
    private boolean enableCallback;
    public static final Logger logger = LoggerFactory.getLogger(WikimediaHandler.class);

    public WikimediaHandler(KafkaProducer<String, String> producer) {
        this.producer = producer;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {
        if(producer!=null) {
            producer.close();
        }
    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) throws Exception {
        ProducerRecord<String,String> record =  new ProducerRecord<>(topic,key,messageEvent.getData());
        if(enableCallback) {
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("Topic\t\t\tPartition\tKeySize\tValueSize\tOffset\t\tTimestamp");
                        System.out.println(recordMetadata.topic() + "\t" + recordMetadata.partition() + "\t\t\t" + recordMetadata.serializedKeySize() + "\t\t" + recordMetadata.serializedValueSize() + "\t\t\t" + recordMetadata.offset() + "\t\t\t" + recordMetadata.timestamp());
                    } else {
                        throw new RuntimeException(exception);
                    }
                }
            });
        }
        else
            producer.send(record);
    }

    @Override
    public void onComment(String comment) throws Exception {

    }

    @Override
    public void onError(Throwable error) {
        logger.error(""+error);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isEnableCallback() {
        return enableCallback;
    }

    public void setEnableCallback(boolean enableCallback) {
        this.enableCallback = enableCallback;
    }
}
