package com.conduktor.kafka.constant;

public class KafkaConstants {
    public static final String BATCH_SIZE_DEFAULT = "10";
    public static final String GROUP_ID_DEFAULT = "KAFKA-APPLICATION";
    public static final String AUTO_OFFSET_RESET_EARLIEST = "earliest";
    public static final String PARTITION_ASSIGNMENT_STRATEGY_RANGEASSIGNOR ="RangeAssignor";
    public static final String PARTITION_ASSIGNMENT_STRATEGY_ROUNDROBIN ="RoundRobin";
    public static final String PARTITION_ASSIGNMENT_STRATEGY_STICKYASSIGNOR ="StickyAssignor";
    public static final String PARTITION_ASSIGNMENT_STRATEGY_COOPERATIVESTICKYASSIGNOR ="CooperativeStickyAssignor";

}
