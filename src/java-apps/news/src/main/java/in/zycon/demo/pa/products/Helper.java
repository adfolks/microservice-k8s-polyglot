package in.zycon.demo.pa.products;

import in.zycon.demo.pa.properties.NewsPartner;
import in.zycon.demo.pa.properties.Partners;
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
