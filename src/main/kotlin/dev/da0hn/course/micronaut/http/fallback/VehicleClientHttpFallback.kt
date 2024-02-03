package dev.da0hn.course.micronaut.http.fallback

import dev.da0hn.course.micronaut.http.client.VehicleHttpClient
import dev.da0hn.course.micronaut.http.client.dto.VehicleDto
import io.micronaut.retry.annotation.Fallback

@Fallback
class VehicleClientHttpFallback : VehicleHttpClient {
  override fun findById(id: Long): VehicleDto {
    return VehicleDto(-1, "Fallback Model", "Fallback Brand", -1)
  }
}
