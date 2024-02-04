package dev.da0hn.course.micronaut.http.fallback

import dev.da0hn.course.micronaut.functions.orElseThrow
import dev.da0hn.course.micronaut.http.client.VehicleHttpClient
import dev.da0hn.course.micronaut.http.client.dto.VehicleDto
import io.micronaut.retry.annotation.Fallback
import io.micronaut.serde.ObjectMapper
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Fallback
class VehicleClientHttpFallback(
  private val objectMapper: ObjectMapper,
) : VehicleHttpClient {
  override fun findById(id: Long): VehicleDto {
    val jedisPool = JedisPool(JedisPoolConfig(), "localhost", 6379)
    return jedisPool.resource.get(id.toString())
      ?.let { json -> objectMapper.readValue(json, VehicleDto::class.java) }
      .orElseThrow { IllegalStateException("Vehicle not found") }
  }
}
