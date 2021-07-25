package com.huskyui.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author 王鹏
 */
@RestController
public class SendController {

    @Resource
    KafkaTemplate<String,String> kafkaTemplate;


    @GetMapping("send")
    public String send(@RequestParam("msg")String msg) throws ExecutionException, InterruptedException {
        return kafkaTemplate.send("topic1",msg).get().toString();
    }
}
