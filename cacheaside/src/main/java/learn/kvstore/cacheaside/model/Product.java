package learn.kvstore.cacheaside.model;


import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("products")
public class Product {
    @Id
    private String id;
    private String gender;
    private String masterCategory;
    private String subCategory;
    private String articleType;
    private String baseColour;
    private String season;
    private Integer year;
    private String usage;
    private String productDisplayName;
}
