package com.adfolks.modern.demo.pa.products.model.techrepublic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    String title;
    String description;
    String pubDate;
    String link;
}
