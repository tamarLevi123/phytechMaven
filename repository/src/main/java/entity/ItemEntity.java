package entity;

import lombok.*;
import javax.persistence.*;

@Table(name="ITEMS")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
    @Id
    private Integer id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Integer price;


    public class Fields {
        private Fields(){}
        public static final String ID = "id";
        public static final String DESCRIPTION = "description";
        public static final String PRICE = "price";
    }

}



