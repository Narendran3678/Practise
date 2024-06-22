package com.kafka;

import com.google.gson.JsonParser;
import com.kafka.constant.KafkaConstants;
import com.kafka.constant.KafkaTopic;
import com.kafka.util.KafkaUtil;
import com.kafka.util.OpenSearchUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.opensearch.action.bulk.BulkItemResponse;
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.index.IndexResponse;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
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

        Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Detected Shutdown Let Exit by Wake UP Call which throw Exception");
            consumer.wakeup();
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        consumerWithBulkIndexRequest();
    }
    public static void consumerWithBulkIndexRequest() throws Exception {
        if(!OpenSearchUtil.createIndexes(KafkaConstants.OPEN_SEARCH_WIKIMEDIA_INDEX)) {
            logger.error("Index Not Created");
        }
        RestHighLevelClient restHighLevelClient = OpenSearchUtil.getRestHighLevelClient();
        consumer.subscribe(Collections.singletonList(KafkaTopic.KAFKA_MY_FIRST_TOPIC.getValue()));
        System.out.println("DocId\t\t\tTopic\t\t\tPartition\tKey\tValue\tOffset\t\tTimestamp");
        try {
            BulkRequest bulkRequest ;
            while (true) {
                bulkRequest = new BulkRequest();
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000L));
                System.out.println("Record "+consumerRecords.count()+" received");
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    String id = extractId(record.value());
                    IndexRequest indexRequest = new IndexRequest(KafkaConstants.OPEN_SEARCH_WIKIMEDIA_INDEX)
                            .source(record.value(), XContentType.JSON)
                            .id(id);
                    bulkRequest.add(indexRequest);
                }

                if (bulkRequest.numberOfActions() > 0) {
                    BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
                    for (BulkItemResponse response : bulkResponse.getItems()) {
                        System.out.println(response.getResponse());
                    }
                    bulkRequest = null;
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
            restHighLevelClient.close();
        }
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
                    String id = extractId(record.value());
                    IndexRequest indexRequest = new IndexRequest(KafkaConstants.OPEN_SEARCH_WIKIMEDIA_INDEX)
                            .source(record.value(), XContentType.JSON)
                            .id(id);

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
            restHighLevelClient.close();
        }
    }
    public static String extractId(String json) {
        //To Implement Idempotence (i.e Avoid sending same data twice when consumer restarted and start fetch old data twice
        return JsonParser.parseString(json)
                .getAsJsonObject()
                .get("meta")
                .getAsJsonObject()
                .get("id").toString();
    }
}
/*
{
	"$schema": "/mediawiki/recentchange/1.0.0",
	"meta": {
		"uri": "https://en.wikipedia.org/wiki/Jos%C3%A9_Rodr%C3%ADguez_(infielder,_born_2001)",
		"request_id": "03131a9e-504d-4d7b-b215-2d49071736a5",
		"id": "c2ff96af-9e07-47dc-acbe-64e9c8b20878",
		"dt": "2024-06-04T14:16:23Z",
		"domain": "en.wikipedia.org",
		"stream": "mediawiki.recentchange",
		"topic": "eqiad.mediawiki.recentchange",
		"partition": 0,
		"offset": 5149907973
	},
	"id": 1782756116,
	"type": "edit",
	"namespace": 0,
	"title": "José Rodríguez (infielder, born 2001)",
	"title_url": "https://en.wikipedia.org/wiki/Jos%C3%A9_Rodr%C3%ADguez_(infielder,_born_2001)",
	"comment": " Philadelphia Phillies ",
        "timestamp": 1717510583,
        "user": "71.166.42.177",
        "bot": false,
        "notify_url": "https://en.wikipedia.org/w/index.php?diff=1227224765&oldid=1227103592",
        "minor": false,
        "length": {
        "old": 6122,
        "new": 6344
        },
        "revision": {
        "old": 1227103592,
        "new": 1227224765
        },
        "server_url": "https://en.wikipedia.org",
        "server_name": "en.wikipedia.org",
        "server_script_path": "/w",
        "wiki": "enwiki",
        "parsedcomment": "<span dir=\"auto\"><span class=\"autocomment\"><a href=\"/wiki/Jos%C3%A9_Rodr%C3%ADguez_(infielder,_born_2001)#Philadelphia_Phillies\" title=\"José Rodríguez (infielder, born 2001)\">→‎Philadelphia Phillies</a></span></span>"
        }
 */
