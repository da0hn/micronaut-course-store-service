package dev.da0hn.course.micronaut.service

import dev.da0hn.course.micronaut.controller.dto.SaleInput
import dev.da0hn.course.micronaut.domain.Sale
import dev.da0hn.course.micronaut.domain.Vehicle
import dev.da0hn.course.micronaut.producer.SaleProducer
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton
import java.util.*

@Singleton
class SaleService(
  private val vehicleService: VehicleService,
  private val saleProducer: SaleProducer,
  private val objectMapper: ObjectMapper,
) {

  fun makeSale(saleInput: SaleInput): Sale {
    val vehicleDto = this.vehicleService.getVehicle(saleInput.vehicleId)

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

    this.saleProducer.publishSale(UUID.randomUUID().toString(), this.objectMapper.writeValueAsString(sale))

    return sale
  }

}
