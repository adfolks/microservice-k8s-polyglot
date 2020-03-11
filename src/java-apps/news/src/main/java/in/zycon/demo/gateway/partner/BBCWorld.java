package in.zycon.demo.gateway.partner;

import in.zycon.demo.gateway.partner.model.bbc.Rss;
import in.zycon.demo.gateway.properties.NewsPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BBCWorld {
    @Autowired
    Helper helper;

    NewsPartner newsPartner;

    public Rss getResponse() {
        newsPartner = helper.getPartnerByName("bbc");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(newsPartner.getUrl(), Rss.class).getBody();
    }


}
