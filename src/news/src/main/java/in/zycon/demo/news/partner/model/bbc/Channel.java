package in.zycon.demo.news.partner.model.bbc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Data
public class Channel {
    String title;
    String description;
    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElement
    List<Item> item = new ArrayList<>();
}
