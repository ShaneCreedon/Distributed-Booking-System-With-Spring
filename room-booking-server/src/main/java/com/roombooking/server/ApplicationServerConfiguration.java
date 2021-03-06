package com.roombooking.server;

import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ApplicationServerConfiguration {

    @Bean
    public Rooms readRooms(RoomsMapper roomsMapper){
        try {
            return roomsMapper.readJsonWithObjectMapper();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public RoomsMapper readRoomJson(){
        return new RoomsMapper();
    }

    @Bean
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Request-");
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }
}
