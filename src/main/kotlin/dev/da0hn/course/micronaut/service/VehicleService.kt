package dev.da0hn.course.micronaut.service

import dev.da0hn.course.micronaut.http.client.VehicleHttpClient
import dev.da0hn.course.micronaut.http.client.dto.VehicleDto
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

@Singleton
class VehicleService(
  private val vehicleHttpClient: VehicleHttpClient,
  private val objectMapper: ObjectMapper
) {

  fun getVehicle(vehicleId: Long): VehicleDto {
    val vehicle = this.vehicleHttpClient.findById(vehicleId)
    registryInCache(vehicle);
    return vehicle
  }

  private fun registryInCache(vehicle: VehicleDto) {
    val jedisPool = JedisPool(JedisPoolConfig(), "localhost", 6379)
    objectMapper.writeValueAsString(vehicle).let { vehicleJson ->
      jedisPool.resource.set(vehicle.id.toString(), vehicleJson)
    }
  }

}
