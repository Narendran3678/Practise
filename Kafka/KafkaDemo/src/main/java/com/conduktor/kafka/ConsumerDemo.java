package com.conduktor.kafka;

import com.conduktor.kafka.constant.KafkaTopic;
import com.conduktor.kafka.util.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {
    static Properties properties;
    public static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    static  {
        // Setting Kafka Properties
        properties = KafkaUtil.initializeKafkaProperties();
    }
    public static void main(String[] args) throws Exception {
        if(properties==null)
            throw new Exception("Properties Not Initialized");
        consumeData();
    }
    public static void consumeData() {
        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(KafkaTopic.KAFKA_MY_THIRD_TOPIC.getValue()));
        int i=1;
        logger.info("Topic\t\t\tPartition\tKey\tValue\tOffset\t\tTimestamp");
        while(true) {
            logger.info("Pulling Call "+i++);
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String,String> record : records)
            {
                System.out.println(record.topic()+"\t"+record.partition()+"\t\t\t"+record.key()+"\t\t"+record.value()+"\t\t\t"+record.offset()+"\t\t\t"+record.timestamp());
            }
        }
    }
}
