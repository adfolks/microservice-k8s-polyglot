package in.zycon.demo.news.partner.model.fox;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Data
public class Channel {
    String title;
    String description;
    @JacksonXmlProperty(localName = "item")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    List<Item> item = new ArrayList<>();
}
