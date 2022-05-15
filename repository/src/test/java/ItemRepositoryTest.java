//
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//
//import gov.btl.tevel.common.categoryIskit.enumeration.KCITchumGimlaEnum;
//import gov.btl.tevel.liba.core.jpa.PeriodEntity;
//import gov.btl.tevel.liba.core.jpa.test.RepositoryTest;
//import gov.btl.tevel.zakaut.core.persistence.entity.IshurMetapelNosafEntity;
//import gov.btl.tevel.zakaut.core.persistence.repository.IshurMetapelNosafRepository;
//import persistence.repository.ItemRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//
//@ComponentScan(basePackages = {
//        "persistence*",
//})
//@EnableAutoConfiguration
//@ContextConfiguration(classes = {IshurMetapelNosafRepository.class })
//public class ItemRepositoryTest extends RepositoryTest {
//
//    @Autowired private ItemRepository repository;
//
//    @Test
//    public void injectedRepositoryNotNull() {
//
//        assertNotNull(repository);
//    }
//
//    @Test
//    public void save_saveMetapelNosafEntityRecord_findRecord() {
//        IshurMetapelNosafEntity entity = new IshurMetapelNosafEntity();
//        entity.setLakoachId(1L);
//        entity.setTchumId(KCITchumGimlaEnum.NACHUT.getId());
//        entity.setPeriod(new PeriodEntity(new Date(),null));
//        entity = repository.save(entity);
//
//        assertTrue(repository.findById(entity.getId()).isPresent());
//    }
//
//    @Test
//    public void findByLakoachId_noMatchingRecord() {
//        IshurMetapelNosafEntity entity = new IshurMetapelNosafEntity();
//        entity.setLakoachId(1L);
//        entity.setTchumId(KCITchumGimlaEnum.NACHUT.getId());
//        entity.setPeriod(new PeriodEntity(new Date(),null));
//        entity = repository.save(entity);
//
//        assertTrue(repository.findByLakoachId(2L).isEmpty());
//    }
//
//    @Test
//    public void findByLakoachId_matchingRecord() {
//        IshurMetapelNosafEntity entity = new IshurMetapelNosafEntity();
//        entity.setLakoachId(1L);
//        entity.setTchumId(KCITchumGimlaEnum.NACHUT.getId());
//        entity.setPeriod(new PeriodEntity(new Date(),null));
//        entity = repository.save(entity);
//
//        assertFalse(repository.findByLakoachId(entity.getLakoachId()).isEmpty());
//    }
//
//
//    @Test
//    public void findByLakoachIdAndTchum_noMatchingRecord() {
//        IshurMetapelNosafEntity entity = new IshurMetapelNosafEntity();
//        entity.setLakoachId(1L);
//        entity.setTchumId(KCITchumGimlaEnum.NACHUT.getId());
//        entity.setPeriod(new PeriodEntity(new Date(),null));
//        entity = repository.save(entity);
//
//        assertTrue(repository.findByLakoachIdAndTchumId(1L, KCITchumGimlaEnum.TCHUM_GIMLA_SHERUTIM_MEYUCHADIM.getId()).isEmpty());
//    }
//
//    @Test
//    public void findByLakoachIdAndTchum_matchingRecord() {
//        IshurMetapelNosafEntity entity = new IshurMetapelNosafEntity();
//        entity.setLakoachId(1L);
//        entity.setTchumId(KCITchumGimlaEnum.NACHUT.getId());
//        entity.setPeriod(new PeriodEntity(new Date(),null));
//        entity = repository.save(entity);
//
//        assertFalse(repository.findByLakoachIdAndTchumId(1L, KCITchumGimlaEnum.NACHUT.getId()).isEmpty());
//    }
//
//}