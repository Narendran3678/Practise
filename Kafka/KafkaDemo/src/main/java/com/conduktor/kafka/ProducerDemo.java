package com.conduktor.kafka;

import com.conduktor.kafka.util.KafkaUtil;
import com.kafka.constant.KafkaTopic;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

public class ProducerDemo {
    static Properties properties;
    public static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    static  {
        // Setting Kafka Properties
        properties = KafkaUtil.initializeKafkaProperties();
    }
    public static void main(String[] args) throws Exception {
        if(properties==null)
            throw new Exception("Properties Not Initialized");
        producerWithCallBack(true,true);
    }
    public static void producerWithCallBack(boolean enableCallback,boolean enableMessageWithKey) {
        logger.info("Producer Demo With Callback Start");
        KafkaProducer<String,String> producer = null;
        int messageCount = 3;
        try {
            //Create a Producer
            producer = new KafkaProducer<>(properties);

            //Send the Data
            for(int i=1;i<=messageCount;i++) {
                //Create a Producer Record
                ProducerRecord<String,String> producerRecord = new ProducerRecord<>(KafkaTopic.KAFKA_MY_THIRD_TOPIC.getValue(), "Kafka-Message-"+i);
                if(enableMessageWithKey)
                {
                    producerRecord = new ProducerRecord<>(KafkaTopic.KAFKA_MY_THIRD_TOPIC.getValue(), "Kafka-Key","Kafka-Message-"+i);
                }
                else
                {
                    producerRecord = new ProducerRecord<>(KafkaTopic.KAFKA_MY_THIRD_TOPIC.getValue(), "Kafka-Message-"+i);
                }
                final int index = i;
                if (enableCallback) {
                    if(index==1)
                        logger.info("============== Received Metadata with Callback Start ==============");
                    producer.send(producerRecord, new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                            if (exception == null) {
                                System.out.println("Topic\t\t\tPartition\tKeySize\tValueSize\tOffset\t\tTimestamp");
                                System.out.println(recordMetadata.topic() + "\t" + recordMetadata.partition() + "\t\t\t" + recordMetadata.serializedKeySize() + "\t\t" + recordMetadata.serializedValueSize() + "\t\t\t" + recordMetadata.offset() + "\t\t\t" + recordMetadata.timestamp());

                                if(index==messageCount)
                                    logger.info("============== Received Metadata with Callback Ends ==============");
                            } else {
                                throw new RuntimeException(exception);
                            }
                        }
                    });
                } else {
                    producer.send(producerRecord);
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            if(producer!=null) {
                //Flush the Producer
                producer.flush();
                //Close the Producer
                producer.close();
            }
        }
        logger.info("Producer Demo With Callback Ends");
    }
}
