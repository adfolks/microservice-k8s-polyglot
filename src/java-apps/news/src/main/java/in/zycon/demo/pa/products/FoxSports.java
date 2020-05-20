package in.zycon.demo.pa.products;

import in.zycon.demo.pa.products.model.fox.Rss;
import in.zycon.demo.pa.properties.NewsPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FoxSports {
    @Autowired
    Helper helper;

    NewsPartner newsPartner;

    public Rss getResponse() {
        newsPartner = helper.getPartnerByName("fox");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(newsPartner.getUrl(), Rss.class).getBody();
    }


}
