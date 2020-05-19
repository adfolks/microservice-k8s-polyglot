package in.zycon.demo.pa.services;

import in.zycon.demo.hawks.models.ProductQuantityStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductStatus {
    @Value("${pa.host}")
    String host;
    @Value("${pa.path}")
    String path;

    public ProductQuantityStatus getProductStatus(Integer id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForEntity(host + path, ProductQuantityStatus.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
