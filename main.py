from kafka import consumer
import entities

handler = entities.KafkaHandler()
consumer = handler.consume('create-payment')

