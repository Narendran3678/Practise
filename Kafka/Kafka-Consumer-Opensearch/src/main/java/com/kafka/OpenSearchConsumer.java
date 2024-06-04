package com.kafka;

import com.kafka.constant.KafkaConstants;
import com.kafka.constant.KafkaTopic;
import com.kafka.util.KafkaUtil;
import com.kafka.util.OpenSearchUtil;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.index.IndexResponse;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class OpenSearchConsumer {
    public static final Logger logger = LoggerFactory.getLogger(OpenSearchConsumer.class.getSimpleName());
    static Properties properties;
    static KafkaConsumer<String,String> consumer;
    static  {
        // Setting Kafka Properties
        properties = KafkaUtil.initializeKafkaProperties();
        consumer = new KafkaConsumer<>(properties);
    }
    public static void main(String[] args) throws Exception {
        if(properties==null)
            throw new Exception("Properties Not Initialized");

        consumer();
        Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                logger.info("Detected Shutdown Let Exit by Wake UP Call which throw Exception");
                consumer.wakeup();
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public static void consumer() throws Exception {
        if(!OpenSearchUtil.createIndexes(KafkaConstants.OPEN_SEARCH_WIKIMEDIA_INDEX)) {
            logger.error("Index Not Created");
        }
        RestHighLevelClient restHighLevelClient = OpenSearchUtil.getRestHighLevelClient();
        consumer.subscribe(Collections.singletonList(KafkaTopic.KAFKA_MY_FIRST_TOPIC.getValue()));
        System.out.println("DocId\t\t\tTopic\t\t\tPartition\tKey\tValue\tOffset\t\tTimestamp");
        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000L));
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    IndexRequest indexRequest = new IndexRequest(KafkaConstants.OPEN_SEARCH_WIKIMEDIA_INDEX)
                            .source(record.value(), XContentType.JSON);
                    IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
                    System.out.println(response.getId()+"\t\t\t\t"+record.topic() + "\t" + record.partition() + "\t\t\t" + record.key() + "\t\t" + record.value() + "\t\t\t" + record.offset() + "\t\t\t" + record.timestamp());
                }
            }
        }
        catch(Exception exception){
            logger.error("Inside Consumer Catch Block");
            exception.printStackTrace();

        }
        finally {
            logger.info("Consumer Closing Gracefully");
            consumer.close();
        }
    }
}
