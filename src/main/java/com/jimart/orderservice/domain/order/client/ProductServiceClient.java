package com.jimart.orderservice.domain.order.client;

import com.jimart.orderservice.core.common.ApiResponse;
import com.jimart.orderservice.domain.product.dto.ProductResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/product-service/v1/product/{id}")
    ApiResponse<ProductResDto> getProductById(@PathVariable Long id);
}
