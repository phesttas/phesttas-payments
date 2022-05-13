from kafka import KafkaConsumer
from kafka.errors import KafkaError
import time

class KafkaHandler:
    def consume(self, topic):
        try:
            consumer = KafkaConsumer(topic)
            return consumer
        except KafkaError as e:
            seconds = 10
            print(f"{e} - Trying to reconnect in {seconds} seconds")
            time.sleep(seconds)
        except KeyboardInterrupt:
            pass
        except:
            seconds = 5
            print(f"Trying to reconnect in {seconds} seconds")
            time.sleep(seconds)


