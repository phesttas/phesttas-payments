package com.phesttas.payments;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Sender extends Thread{
    
    public void run(){
        
        KafkaProducer producer = new KafkaProducer<String,String>(KafkaProperties.getProperties());
        
        int counter = 0;
        while(true){
            try {
                producer.send(new ProducerRecord<>("test", "Key-"+String.valueOf(counter), "Value-"+String.valueOf(counter)));
                counter++;
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
