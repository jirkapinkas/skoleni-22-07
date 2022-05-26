package com.example.demohazelcast2ndlevelcache;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    HazelcastInstance hazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("hc1");
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(clientConfig);
        instance.getConfig().addMapConfig(new MapConfig("items").setTimeToLiveSeconds(20));
        return instance;
    }

}
