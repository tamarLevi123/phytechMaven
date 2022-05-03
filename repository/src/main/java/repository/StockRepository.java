package repository;

import entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer>, JpaSpecificationExecutor {

}
