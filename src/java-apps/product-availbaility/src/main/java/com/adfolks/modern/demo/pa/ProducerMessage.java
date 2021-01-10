package com.adfolks.modern.demo.pa;

import com.adfolks.modern.demo.pa.products.Product;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ProducerMessage extends JsonSerializer<Product> {
}
