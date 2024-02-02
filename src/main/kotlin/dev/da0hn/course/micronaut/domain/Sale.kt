package dev.da0hn.course.micronaut.domain

import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

@Serdeable
class Sale(
  val client: String,
  val vehicle: Vehicle,
  val price: BigDecimal,
  val installmentsQuantity: Int,
  val installments: Installments = mutableListOf(),
) {

  constructor(client: String, vehicle: Vehicle, price: BigDecimal, installmentsQuantity: Int) : this(
    client = client,
    vehicle = vehicle,
    price = price,
    installmentsQuantity = installmentsQuantity,
    installments = mutableListOf()
  ) {
    generateInstallments()
  }

  private fun generateInstallments() {
    val installmentValue = price.divide(BigDecimal(installmentsQuantity), 4, RoundingMode.HALF_EVEN)
    val today = LocalDate.now()

    for (i in 1..installmentsQuantity) {
      val dueDate = today.plusMonths(i.toLong())
      installments.add(Installment(i, installmentValue, dueDate))
    }
  }

  fun installments(): List<Installment> {
    return installments.toList()
  }

  override fun toString(): String {
    return "Sale(client='$client', vehicle=$vehicle, price=$price, installmentsQuantity=$installmentsQuantity, installments=$installments)"
  }


}
