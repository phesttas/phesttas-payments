from kafka import KafkaConsumer, KafkaProducer, producer
from kafka.errors import KafkaError
import time

server = 'localhost:9092'

class PaymentDTO:
    def __init__(self, dto):
        pass

def consumePaymentTopic(topic):
    # When a message comes, call doPayment() and if the payment
    # is ok register whit registerPayment() and send a confirmation 
    # message with confirmPayment()
    while(True):
        try:
            consumer = KafkaConsumer(topic, bootstrap_servers=server)
            print("Broker connected")
            for message in consumer:
                dto = PaymentDTO(message)
                paymentStatus = doPayment(dto)
                if(paymentStatus == "Payment done"):
                    print(paymentStatus)
                    registerPayment(dto)
                    confirmPayment('payment-confirmation',dto)
        except KafkaError as e:
            seconds = 10
            print(f"{e} - Trying to reconnect in {seconds} seconds")
            time.sleep(seconds)
        except:
            seconds = 5
            print(f"Trying to reconnect in {seconds} seconds")
            time.sleep(seconds)

def doPayment(paymentDTO):
    # Try to make a payment on payment gateway 
    return "Payment done"

def registerPayment(paymentDTO):
    # Register a payment on database
    print("Payment registered")
    return "Payment registered"

def confirmPayment(topic, paymentDTO):
    # Sends a message with a payment confirmation
    try:
        producer = KafkaProducer(bootstrap_servers=server)
        producer.send(topic, b"Payment confirmed")
        print("Payment confirmed")
        return "Payment confirmed"
    except:
        print("An error occurred on confirm payment")

if __name__ == "__main__":
    consumePaymentTopic('create-payment')
