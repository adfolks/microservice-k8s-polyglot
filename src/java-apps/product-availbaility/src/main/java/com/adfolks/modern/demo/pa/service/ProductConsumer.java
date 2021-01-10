package com.adfolks.modern.demo.pa.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ProductConsumer {
    HashMap<Integer, Integer> dataStore=new HashMap();
    @KafkaListener(topics = "${topic.name}")
    public void receive(String test) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Integer> map = (HashMap<String, Integer>) objectMapper.readValue(test, Map.class);
        System.out.println(map);
        dataStore.put(map.get("product_id"),map.get("product_quantity"));
    }

    public HashMap<Integer, Integer> getDataStore() {
        return dataStore;
    }
}


