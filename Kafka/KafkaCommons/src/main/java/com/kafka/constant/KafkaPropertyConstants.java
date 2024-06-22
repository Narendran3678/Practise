package com.kafka.constant;


import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public enum KafkaPropertyConstants {
//Mandatory Apache Kafke Cluster Connectivity Config
    BOOSTRAP_SERVERS_KEY("bootstrap.servers"), BOOSTRAP_SERVERS_VALUE("native-crawdad-13875-us1-kafka.upstash.io:9092"),
    SASL_MECHANISM_KEY("sasl.mechanism"), SASL_MECHANISM_VALUE("SCRAM-SHA-256"),
    SECURITY_PROTOCOL_KEY("security.protocol"), SECURITY_PROTOCOL_VALUE("SASL_SSL"),
    SASL_JAAS_CONFIG_KEY("sasl.jaas.config"), SASL_JAAS_CONFIG_VALUE("org.apache.kafka.common.security.scram.ScramLoginModule required username=\"bmF0aXZlLWNyYXdkYWQtMTM4NzUkcjT0tsf08zZH49ujrl5F7RyWwm8f_wf01zI\" password=\"ZThjNzMyZTQtN2ExYi00ZGQ2LTg4YTYtNTIwZmNjZDQ3YTI4\";"),

//For Producer Config
    KEY_SERIALIZER("key.serializer"), VALUE_SERIALIZER("value.serializer"), STRING_SERIALIZER_CLASS(StringSerializer.class.getName()),
    COMPRESSION_TYPE("compression.type"), // Enforce Compressing Message
    LINGER_MS("linger.ms"),BATCH_SIZE_KEY("batch.size"),// Enforce Batching Mechanism

    // Safe Producer Config and Below will auto set for version after 3.0 Starts
    MIN_INSYNC_REPLICAS("min.insync.replicas"),
    ACKS("acks"), //Defaul All
    ENABLE_IDEMPOTENCE("enable.idempotence"), //Default True
    RETRIES("retries"), //Defualt Integer Max
    DELIVERY_TIMEOUT_MS("delivery.timeout.ms"), MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION("max.in.flight.requests.per.connection"),
    // Safe Producer Config Ends

// For Consumer
    KEY_DESERIALIZER("key.deserializer"), VALUE_DESERIALIZER("value.deserializer"), STRING_DESERIALIZER_CLASS(StringDeserializer.class.getName()),
    GROUP_ID_KEY("group.id") , AUTO_OFFSET_RESET_KEY("auto.offset.reset"), PARTITION_ASSIGNMENT_STRATEGY("partition.assignment.strategy"),
    GROUP_INSTANCE_ID("group.instance.id"), SESSION_TIMEOUT_MS("session.timeout.ms"), AUT0_C0MMIT_INTERVAL_MS("auto.commit.interval.ms"),
    ENABLE_AUTO_COMMIT("enable.auto.commit"),HEARTBEAT_INTERVAL_MS("heartbeat.interval.ms"),MAX_POLL_INTERVAL_MS("max.poll.interval.ms"),
    MAX_POLL_RECORDS("max.poll.records"),FETCH_MIN_BYTES("fetch.min.bytes"),FETCH_MAX_WAIT_MS("fetch.max.wait.ms"),
    MAX_PARTITION_FETCH_BYTES("max.partition.fetch.bytes"),FETCH_MAX_BYTES("fetch.max.bytes"),
    REPLICA_SELECTOR_CLASS_KEY("replica.selector.class"),REPLICA_SELECTOR_CLASS_VALUE("org.apache.kafka.common.replica.RackAwareReplicaSelector")
    ;
    private final String value;
    KafkaPropertyConstants(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
