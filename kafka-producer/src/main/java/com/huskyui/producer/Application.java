package com.huskyui.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author 王鹏
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }

//    @Bean
//    public ApplicationRunner runner(KafkaTemplate<String,String> template){
//        return args -> {
//            ListenableFuture<SendResult<String, String>> future = template.send("topic1", "test");
//            SendResult<String, String> stringStringSendResult = future.get();
//            System.out.println(stringStringSendResult.toString());
//
//        };
//    }

}
