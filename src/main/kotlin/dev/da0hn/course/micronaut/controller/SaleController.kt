package dev.da0hn.course.micronaut.controller

import dev.da0hn.course.micronaut.controller.dto.SaleInput
import dev.da0hn.course.micronaut.domain.Sale
import dev.da0hn.course.micronaut.service.SaleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/sales")
@ExecuteOn(TaskExecutors.BLOCKING)
class SaleController(private val saleService: SaleService) {

  @Post
  fun makeSale(@Body saleInput: SaleInput): MutableHttpResponse<Sale>? {
    val sale = this.saleService.makeSale(saleInput)
    return HttpResponse.ok(sale)
  }

}
