from kafka import KafkaConsumer
from kafka.errors import KafkaError
import time

while True:

    try:
        consumer = KafkaConsumer('create-payment')
        for message in consumer:
            print(message)
    
    except KafkaError as e:
        seconds = 10
        print(f"{e} - Trying to reconnect in {seconds} seconds")
        time.sleep(seconds)
    except KeyboardInterrupt:
        break
    except:
        seconds = 5
        print(f"Trying to reconnect in {seconds} seconds")
        time.sleep(seconds)

