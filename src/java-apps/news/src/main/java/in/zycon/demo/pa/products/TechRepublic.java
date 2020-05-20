package in.zycon.demo.pa.products;

import in.zycon.demo.pa.products.model.techrepublic.Rss;
import in.zycon.demo.pa.properties.NewsPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TechRepublic {
    @Autowired
    Helper helper;

    NewsPartner newsPartner;

    public Rss getResponse() {
        newsPartner = helper.getPartnerByName("techrepublic");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(newsPartner.getUrl(), Rss.class).getBody();
    }


}
