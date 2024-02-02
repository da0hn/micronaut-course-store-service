package dev.da0hn.course.micronaut.controller.dto

import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal

@Serdeable
data class SaleInput(
  val client: String,
  val vehicleId: Long,
  val price: BigDecimal,
  val installments: Int,
)

