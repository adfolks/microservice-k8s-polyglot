package in.zycon.demo.gateway.products;

import in.zycon.demo.gateway.properties.NewsPartner;
import in.zycon.demo.gateway.properties.Partners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Helper {
    @Autowired
    Partners partners;

    public NewsPartner getPartnerByName(String name){
        return partners.getNews().stream().filter(newsPartner -> {
            return newsPartner.getName().equalsIgnoreCase(name);
        }).findFirst().get();
    }
}
