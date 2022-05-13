package controller;

import entity.ItemEntity;
import entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.ItemRepository;
import repository.StockRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController("/store")
public class StoreController {

    private static final String GET_ITEMS_IN_STOCK = "/getItemsInStock";
    private static final String AMOUNT_OF_ITEM = "/getAmountOfItem";
    private static final String SELL_AN_ITEM = "/sellAnItem";
    private static final String GET_ITEMS = "/getItems";

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StockRepository stockRepository;

    @GetMapping(name = GET_ITEMS_IN_STOCK)
    public List<ItemEntity> getItemsInStock() {
        List<Integer> itemIdsInStock = stockRepository.findAll().stream()
                .filter(stock -> stock.getAmount() > 0)
                .map(StockEntity::getId)
                .collect(Collectors.toList());
        return itemRepository.findAllById(itemIdsInStock);
    }
    @GetMapping(name = GET_ITEMS)
    public List<ItemEntity> getItems() {
        return itemRepository.findAll();
    }
    @GetMapping(name = AMOUNT_OF_ITEM)
    public Integer getAmountOfItem(Integer id) {
        Optional<StockEntity> stockById = stockRepository.findById(id);
        return stockById.isPresent() ? stockById.get().getAmount() : 0;
    }

    @PostMapping(name = SELL_AN_ITEM)
    public void sellAnItem(Integer id) {
        StockEntity stockById = stockRepository.getById(id);
        stockById.setAmount(stockById.getAmount() - 1);
        stockRepository.save(stockById);
    }
}
