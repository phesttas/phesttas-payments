package com.phesttas.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentsApplication {

  public static void main(String[] args) {

    Sender sender = new Sender();
    PaymentRequest payreq1 = new PaymentRequest();
    // PaymentRequest payreq2 = new PaymentRequest();
    payreq1.start();
    // payreq2.start();
    sender.start();

    SpringApplication.run(PaymentsApplication.class, args);

  }

}
