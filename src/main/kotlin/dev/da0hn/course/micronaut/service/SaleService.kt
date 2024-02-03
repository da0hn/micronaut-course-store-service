package dev.da0hn.course.micronaut.service

import dev.da0hn.course.micronaut.controller.dto.SaleInput
import dev.da0hn.course.micronaut.domain.Sale
import dev.da0hn.course.micronaut.domain.Vehicle
import dev.da0hn.course.micronaut.http.client.VehicleHttpClient
import jakarta.inject.Singleton

@Singleton
class SaleService(private val vehicleService: VehicleService) {

  fun makeSale(saleInput: SaleInput): Sale {
    val vehicleDto = vehicleService.getVehicle(saleInput.vehicleId)

    val sale = Sale(
      client = saleInput.client,
      vehicle = Vehicle(
        id = vehicleDto.id,
        brand = vehicleDto.brand,
        model = vehicleDto.model,
        year = vehicleDto.year
      ),
      price = saleInput.price,
      installmentsQuantity = saleInput.installments,
    )

    return sale
  }

}
