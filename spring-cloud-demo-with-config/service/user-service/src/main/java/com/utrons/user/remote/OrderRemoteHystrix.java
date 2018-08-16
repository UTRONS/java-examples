package com.utrons.user.remote;

import org.springframework.stereotype.Component;

@Component
public class OrderRemoteHystrix implements OrderRemote {
    @Override
    public String getOrderPort() {
        return "order service 调用失败！";
    }
}
