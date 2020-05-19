package in.zycon.demo.pa.services;

import in.zycon.demo.hawks.models.Ads;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Service
public class AdService {
    @Value("${ads.host}")
    String host;
    @Value("${ads.path}")
    String path;

    public Set<Ads> getAllAds() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return new HashSet<>(Arrays.asList(restTemplate.getForEntity(host + path, Ads[].class).getBody()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
