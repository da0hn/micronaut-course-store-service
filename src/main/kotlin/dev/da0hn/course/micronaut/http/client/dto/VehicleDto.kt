package dev.da0hn.course.micronaut.http.client.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class VehicleDto(
  val id: Long,
  val model: String,
  val brand: String,
  val year: Int,
)
