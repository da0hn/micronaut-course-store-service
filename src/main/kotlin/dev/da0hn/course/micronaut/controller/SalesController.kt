package dev.da0hn.course.micronaut.controller

import dev.da0hn.course.micronaut.controller.dto.SaleInput
import dev.da0hn.course.micronaut.service.SaleService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/sales")
@ExecuteOn(TaskExecutors.BLOCKING)
class SalesController(private val saleService: SaleService) {

  @Post
  fun makeSale(@Body saleInput: SaleInput) {
    this.saleService.makeSale(saleInput)
  }

}
