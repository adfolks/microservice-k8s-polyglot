package in.zycon.demo.gateway.services;

import in.zycon.demo.hawks.models.ProductQuantityStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductsOMS {
    @Value("${oms.product}")
    String omsPath;
    public String getProducts() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForEntity(omsPath, String.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
