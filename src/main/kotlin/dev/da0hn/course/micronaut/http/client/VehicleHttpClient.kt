package dev.da0hn.course.micronaut.http.client

import dev.da0hn.course.micronaut.http.client.dto.VehicleDto
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client(id = "http://localhost:8080", path = "/vehicles")
interface VehicleHttpClient {

  @Get("/{id}")
  fun findById(id: Long): VehicleDto

}
