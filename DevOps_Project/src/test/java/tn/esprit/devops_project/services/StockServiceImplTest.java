package tn.esprit.devops_project.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddStock() {
        Stock stock = new Stock();
        Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
        Stock result = stockService.addStock(stock);
        assertNotNull(result);
        assertEquals(stock, result);
    }

    @Test
    public void testRetrieveAllStock() {
        // Mocking data
        Stock stock1 = new Stock();
        stock1.setIdStock(1L);
        stock1.setTitle("Stock 1");

        Stock stock2 = new Stock();
        stock2.setIdStock(2L);
        stock2.setTitle("Stock 2");

        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);

        // Mocking behavior
        when(stockRepository.findAll()).thenReturn(stocks);

        // Calling the method to be tested
        List<Stock> retrievedStocks = stockService.retrieveAllStock();

        // Verifying the result
        assertEquals(2, retrievedStocks.size());
        assertEquals("Stock 1", retrievedStocks.get(0).getTitle());
        assertEquals("Stock 2", retrievedStocks.get(1).getTitle());
    }
}
