package com.example.demohazelcast2ndlevelcache;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
@Slf4j
@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
public class DemoHazelcast2ndLevelCacheApplication {

    @Autowired
    private ItemRepository itemRepository;

    private boolean running = true;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws InterruptedException {
        Item item = new Item();
        item.setName("blabla");
        itemRepository.save(item);
        while(running) {
//            Collection<HazelcastInstance> allHazelcastClients = HazelcastClient.getAllHazelcastClients();
//            allHazelcastClients.forEach(hazelcastInstance -> {
//                Set<Map.Entry<Object, Object>> entries = hazelcastInstance.getMap(Item.class.getName()).entrySet();
//                log.info("number of cached Items: {}", entries.size());
//            });


            Set<HazelcastInstance> allHazelcastInstances = Hazelcast.getAllHazelcastInstances();
            allHazelcastInstances.forEach(hazelcastInstance -> {
                Set<Map.Entry<Object, Object>> entries = hazelcastInstance.getMap(Item.class.getName()).entrySet();
                log.info("number of cached Items: {}", entries.size());
            });
            Thread.sleep(1_000);
        }
    }

    @PreDestroy
    public void destroy() {
        running = false;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoHazelcast2ndLevelCacheApplication.class, args);
    }

}
