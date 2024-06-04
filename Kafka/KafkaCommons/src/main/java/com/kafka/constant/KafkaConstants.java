package com.kafka.constant;

public class KafkaConstants {
    public static final String BATCH_SIZE_DEFAULT = "10";
    public static final String GROUP_ID_DEFAULT = "KAFKA-APPLICATION";
    public static final String AUTO_OFFSET_RESET_EARLIEST = "earliest";
    public static final String WIKIMEDIA_DATA_STREAM_URL="https://stream.wikimedia.org/v2/stream/recentchange";
    public static final String OPENSEARCH_URL="https://localhost:9200";
    public static final String ACKS_ALL="all";
    public static String OPEN_SEARCH_WIKIMEDIA_INDEX ="wikimedia";
    public static String TRUSTSTORE_PATH = "/Users/narendran.babu/Eclipse_Workspace/MyRepo/Practise/truststore.jks";
    public static String TRUSTSTORE_PASSWORD = "password";

    public enum PARTITION_ASSIGNMENT_STRATEGY {
        ROUNDROBIN ("RoundRobin"),
        STICKYASSIGNOR ("StickyAssignor"),
        //Below 2 Are Default
        RANGEASSIGNOR("RangeAssignor"),
        COOPERATIVESTICKYASSIGNOR ("CooperativeStickyAssignor")
        ;
        private final String value;
        PARTITION_ASSIGNMENT_STRATEGY(String value){
            this.value=value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum COMPRESSION_TYPE {

        NONE("none"),
        GZIP("gzip"),
        LZ4("lz4"),  //Recommended
        SNAPPY("snappy"), //Recommended
        ZSTD("zstd"),
        PRODUCER("producer"),
        ;
        private final String value;
        COMPRESSION_TYPE(String value){
            this.value=value;
        }

        public String getValue() {
            return value;
        }
    }
}
