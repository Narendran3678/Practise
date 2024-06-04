package com.kafka;

import com.kafka.constant.KafkaConstants;
import com.kafka.util.OpenSearchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenSearchConsumer {
    public static final Logger logger = LoggerFactory.getLogger(OpenSearchConsumer.class.getSimpleName());
    public static void main(String[] args) throws Exception {
        createIndex();
    }
    public static void createIndex() throws Exception {
        OpenSearchUtil.createIndexes(KafkaConstants.OPEN_SEARCH_INDEX);
    }
}
