package dev.da0hn.course.micronaut.service

import dev.da0hn.course.micronaut.controller.dto.SaleInput
import dev.da0hn.course.micronaut.http.client.VehicleHttpClient
import jakarta.inject.Singleton

@Singleton
class SaleService(private val vehicleHttpClient: VehicleHttpClient) {

  fun makeSale(saleInput: SaleInput) {
    val vehicleDto = vehicleHttpClient.findById(saleInput.vehicleId)
    println(vehicleDto)
  }

}
