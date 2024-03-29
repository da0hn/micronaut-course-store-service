package dev.da0hn.course.micronaut.http.client

import dev.da0hn.course.micronaut.http.client.dto.VehicleDto
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Recoverable


@Recoverable // Since Micronaut Framework 4.0, declarative clients annotated with @Client no longer invoke fallbacks by default. To restore the previous behaviour add the following dependency and annotate any declarative clients with @Recoverable.
@CircuitBreaker(attempts = "3")
@Client(id = "vehicle-service", path = "/vehicles")
interface VehicleHttpClient {

  @Get("/{id}")
  fun findById(id: Long): VehicleDto

}
