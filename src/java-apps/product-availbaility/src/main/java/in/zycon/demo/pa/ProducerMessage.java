package in.zycon.demo.pa;

import in.zycon.demo.pa.products.Product;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ProducerMessage extends JsonSerializer<Product> {
}
