package provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by whyse
 * on 2018/1/11 18:06
 */
@Controller
public class HelloController {
    static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    DiscoveryClient discoveryClient;
    //=======================================================
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        ServiceInstance serviceInstance =  discoveryClient.getLocalServiceInstance();
        logger.info("Host:"+serviceInstance.getHost()+"   ServiceId:"+serviceInstance.getServiceId());
        return "hello world";
    }
}
