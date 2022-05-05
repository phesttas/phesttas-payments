package com.phesttas.payments;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;

public class KafkaProperties {
  public static Properties getProperties() {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    // props.put("bootstrap.servers", "broker:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);

    props.put(ConsumerConfig.GROUP_ID_CONFIG, "payments");
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    return props;
  }
}
