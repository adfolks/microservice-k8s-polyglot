package in.zycon.demo.pa.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "partners")
public class Partners {
    @NotEmpty
    List<NewsPartner> news;
    String version;
}
