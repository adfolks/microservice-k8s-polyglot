package in.zycon.demo.gateway.products.model.techrepublic;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class Rss {
    @XmlElement
    Channel channel;
}
