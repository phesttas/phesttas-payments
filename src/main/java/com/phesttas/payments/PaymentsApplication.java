package com.phesttas.payments;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentsApplication {

	public static void main(String[] args) {

		// KafkaProducer producer = new KafkaProducer<String,String>(KafkaProperties.getProperties());
		// producer.send(new ProducerRecord<String, String>("topic", "message"));
		
		Sender sender = new Sender();
		PaymentRequest payreq1 = new PaymentRequest();
		// PaymentRequest payreq2 = new PaymentRequest();
		payreq1.start();
		// payreq2.start();
		sender.start();

		SpringApplication.run(PaymentsApplication.class, args);

	}

}
