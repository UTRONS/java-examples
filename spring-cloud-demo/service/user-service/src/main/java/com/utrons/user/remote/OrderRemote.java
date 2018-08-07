package com.utrons.user.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "order-service", fallback = OrderRemoteHystrix.class)
public interface OrderRemote {
    @GetMapping("/order/getOrderPort")
    String getOrderPort();
}
