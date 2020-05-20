package in.zycon.demo.gateway.services;

import in.zycon.demo.hawks.models.ProductQuantityStatus;
import in.zycon.demo.hawks.models.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ProdAvail {
    @Value("${ps.host}")
    String host;
    @Value("${ps.path}")
    String path;

    public String getProductStatus(String id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            System.out.println(restTemplate.getForEntity(host + path + id, ProductQuantityStatus.class).getBody());
            System.out.println(host+path+id);
            return restTemplate.getForEntity(host + path + id, String.class).getBody();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
