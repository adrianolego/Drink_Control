package com.challange.drinkcontrol.service;

import com.challange.drinkcontrol.domain.AlcoholicDrinkBatch;
import com.challange.drinkcontrol.domain.DrinkBatch;
import com.challange.drinkcontrol.domain.NonAlcoholicDrinkBatch;
import com.challange.drinkcontrol.repository.BatchDrinkRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.challange.drinkcontrol.builders.BatchDrinkBuilder.oneAlcoholicBatchDrink;
import static com.challange.drinkcontrol.builders.BatchDrinkBuilder.oneNonAlcoholicBatchDrink;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DrinkBatchServiceTest {

    @InjectMocks
    private BatchDrinkService batchDrinkService;

    @Mock
    private BatchDrinkRepository batchDrinkRepositoryMock;

    //@Before don't work
    public void setup() {
        initMocks(this);
    }

    @Test
    public void findAlcoholicDrinkBatchById() {
        setup();
        AlcoholicDrinkBatch alcoholicDrink = (AlcoholicDrinkBatch) oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(alcoholicDrink));

        AlcoholicDrinkBatch result = (AlcoholicDrinkBatch) batchDrinkService.find(alcoholicDrink.getId());

        Assert.assertNotNull(result);
        Assert.assertEquals(alcoholicDrink.getId(), result.getId());
        Assert.assertEquals(alcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(alcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(alcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
        Assert.assertEquals(alcoholicDrink.getPercentAlcohol(), result.getPercentAlcohol());
    }

    @Test
    public void findNonAlcoholicDrinkBatchById() {
        setup();
        NonAlcoholicDrinkBatch nonAlcoholicDrink = (NonAlcoholicDrinkBatch) oneNonAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(nonAlcoholicDrink));

        DrinkBatch result = batchDrinkService.find(nonAlcoholicDrink.getId());

        Assert.assertNotNull(result);
        Assert.assertEquals(nonAlcoholicDrink.getId(), result.getId());
        Assert.assertEquals(nonAlcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(nonAlcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(nonAlcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
    }

    @Test
    public void notFindDrinkBatchById() {
        setup();
        DrinkBatch drinkBatch = oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenThrow(new ObjectNotFoundException("Drink batch not found :Id " + drinkBatch.getId(),
                "Type: " + DrinkBatch.class.getName()));

        String msg = "";
        try {
            batchDrinkService.find(drinkBatch.getId());
        } catch (Exception e) {
            msg = e.getMessage();
        }

        Assert.assertFalse(msg.isEmpty());
        Assert.assertTrue(msg.contains("Drink batch not found :Id " + drinkBatch.getId()));

    }

    @Test
    public void FindAllDrinkBatches() {
        setup();
        AlcoholicDrinkBatch alcoholicDrink = (AlcoholicDrinkBatch) oneAlcoholicBatchDrink().now();
        NonAlcoholicDrinkBatch nonAlcoholicDrink = (NonAlcoholicDrinkBatch) oneNonAlcoholicBatchDrink().now();

        // paging parameters
        PageRequest paging = PageRequest.of(1, 2);
        List<DrinkBatch> drinkBatchList = Arrays.asList(alcoholicDrink, nonAlcoholicDrink);
        Page<DrinkBatch> drinkBatchPage = new PageImpl<>(drinkBatchList, paging, drinkBatchList.size());

        Integer page = 1;
        Integer linesPerPage = 10;
        String orderBy = "dateTime";
        String direction = "asc";

        when(batchDrinkRepositoryMock.findAll(any(PageRequest.class))).thenReturn(drinkBatchPage);

        Page result = batchDrinkService.findPage(page, linesPerPage, orderBy, direction);

        Assert.assertNotNull(result);
        Assert.assertEquals(drinkBatchList.size(), result.getContent().size());

        List<DrinkBatch> resultList = result.getContent();

        AlcoholicDrinkBatch alcoholicResult = (AlcoholicDrinkBatch) resultList.get(0);
        NonAlcoholicDrinkBatch nonAlcoholicResult = (NonAlcoholicDrinkBatch) resultList.get(1);

        Assert.assertEquals(alcoholicDrink.getId(), alcoholicResult.getId());
        Assert.assertEquals(alcoholicDrink.getAmount(), alcoholicResult.getAmount());
        Assert.assertEquals(alcoholicDrink.getDateTime(), alcoholicResult.getDateTime());
        Assert.assertEquals(alcoholicDrink.getResponsiblePerson(), alcoholicResult.getResponsiblePerson());
        Assert.assertEquals(alcoholicDrink.getPercentAlcohol(), alcoholicResult.getPercentAlcohol());

        Assert.assertEquals(nonAlcoholicDrink.getId(), nonAlcoholicResult.getId());
        Assert.assertEquals(nonAlcoholicDrink.getAmount(), nonAlcoholicResult.getAmount());
        Assert.assertEquals(nonAlcoholicDrink.getDateTime(), nonAlcoholicResult.getDateTime());
        Assert.assertEquals(nonAlcoholicDrink.getResponsiblePerson(), nonAlcoholicResult.getResponsiblePerson());
    }

    @Test
    public void InsertDrinkBatch() {
    }

    @Test
    public void UpdateDrinkBatch() {
    }

    @Test
    public void DeleteDrinkBatch() {
    }
}
