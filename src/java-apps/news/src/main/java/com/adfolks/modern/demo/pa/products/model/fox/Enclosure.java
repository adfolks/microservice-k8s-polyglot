package com.adfolks.modern.demo.pa.products.model.fox;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enclosure {
    @JacksonXmlProperty(isAttribute = true)
    public String url;

}
