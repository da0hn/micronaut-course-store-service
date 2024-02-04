package dev.da0hn.course.micronaut.producer

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface SaleProducer {

  @Topic("sales")
  fun publishSale(@KafkaKey id: String, json: String)

}
