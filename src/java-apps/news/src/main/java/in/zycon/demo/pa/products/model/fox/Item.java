package in.zycon.demo.pa.products.model.fox;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

@Data
public class Item {
    String title;
    String link;
    String guid;
    String description;
    String pubDate;
    @XmlElement
    Enclosure enclosure;
}
