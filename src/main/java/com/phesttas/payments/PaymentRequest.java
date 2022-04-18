package com.phesttas.payments;

import java.time.Duration;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class PaymentRequest extends Thread{
    
   
    public void run(){
        final String topic = "test";
        final Consumer<String, String> consumer = new KafkaConsumer<>(KafkaProperties.getProperties());
        consumer.subscribe(Arrays.asList(topic));

        try{
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    String key = record.key();
                    String value = record.value();
                    long offset = record.offset();
                    System.out.println("Received message: (" + key + ", " + value + ") at offset " + offset + " - " + Thread.currentThread().getName());
                }
            }
        } finally {
            consumer.close();
        }
        
    }

    // try {
    //     while (true) {
    //         ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
    //         for (ConsumerRecord<String, String> record : records) {
    //             String key = record.key();
    //             String value = record.value();
    //             System.out.println(
    //                 String.format("Consumed event from topic %s: key = %-10s value = %s", topic, key, value));
    //         }
    //     }
    // } finally {
    //     consumer.close();
    // }
}
