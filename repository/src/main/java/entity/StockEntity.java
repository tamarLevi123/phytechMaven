package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="STOCK")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockEntity {
    @Id
    private Integer id;
    @Column(name = "AMOUNT")
    private Integer amount;


    public class Fields {
        private Fields(){}
        public static final String ID = "id";
        public static final String AMOUNT = "amount";
    }
}
