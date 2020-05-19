package in.zycon.demo.pa.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @JsonProperty("product_id")
    Integer productId;
    @JsonProperty("product_quantity")
    Integer productQuantity;
    Date date;
}
