package in.zycon.demo.news.partner;

import in.zycon.demo.news.properties.NewsPartner;
import in.zycon.demo.news.properties.Partners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FoxSports {
    @Autowired
    Helper helper;

    NewsPartner newsPartner;

    public Object getResponse() {
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.ge

    }
}
