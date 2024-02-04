package dev.da0hn.course.micronaut.producer

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody

@KafkaClient(id = "sales-service-producer")
interface SaleProducer {

  @Topic("sales-topic")
  fun publishSale(@KafkaKey id: String, @MessageBody json: String)

}
