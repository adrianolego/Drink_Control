package com.challange.drinkcontrol.service;

import com.challange.drinkcontrol.domain.AlcoholicDrink;
import com.challange.drinkcontrol.domain.BatchDrink;
import com.challange.drinkcontrol.domain.NonAlcoholicDrink;
import com.challange.drinkcontrol.repository.BatchDrinkRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.challange.drinkcontrol.builders.BatchDrinkBuilder.oneAlcoholicBatchDrink;
import static com.challange.drinkcontrol.builders.BatchDrinkBuilder.oneNonAlcoholicBatchDrink;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BatchDrinkServiceTest {

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
        AlcoholicDrink alcoholicDrink = (AlcoholicDrink) oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(alcoholicDrink));

        AlcoholicDrink result = (AlcoholicDrink) batchDrinkService.find(alcoholicDrink.getId());

        Assert.assertEquals(alcoholicDrink.getId(), result.getId());
        Assert.assertEquals(alcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(alcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(alcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
        Assert.assertEquals(alcoholicDrink.getPercentAlcohol(), result.getPercentAlcohol());
    }

    @Test
    public void findNonAlcoholicDrinkBatchById() {
        setup();
        NonAlcoholicDrink nonAlcoholicDrink = (NonAlcoholicDrink) oneNonAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(nonAlcoholicDrink));

        BatchDrink result = batchDrinkService.find(nonAlcoholicDrink.getId());

        Assert.assertEquals(nonAlcoholicDrink.getId(), result.getId());
        Assert.assertEquals(nonAlcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(nonAlcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(nonAlcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
    }

    @Test
    public void notFindDrinkBatchById() {
        setup();
        BatchDrink batchDrink = oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenThrow(new ObjectNotFoundException("Drink batch not found :Id " + batchDrink.getId(),
                "Type: " + BatchDrink.class.getName()));

        String msg = "";
        try {
            batchDrinkService.find(batchDrink.getId());
        } catch (Exception e) {
            msg = e.getMessage();
        }

        Assert.assertTrue(msg.contains("Drink batch not found :Id " + batchDrink.getId()));

    }

    @Test
    public void FindAllDrinkBatches() {
        setup();
        AlcoholicDrink alcoholicDrink = (AlcoholicDrink) oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(alcoholicDrink));

        AlcoholicDrink result = (AlcoholicDrink) batchDrinkService.find(alcoholicDrink.getId());

        Assert.assertEquals(alcoholicDrink.getId(), result.getId());
        Assert.assertEquals(alcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(alcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(alcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
        Assert.assertEquals(alcoholicDrink.getPercentAlcohol(), result.getPercentAlcohol());

    }

    @Test
    public void InsertDrinkBatch() {
        setup();
        AlcoholicDrink alcoholicDrink = (AlcoholicDrink) oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(alcoholicDrink));

        AlcoholicDrink result = (AlcoholicDrink) batchDrinkService.find(alcoholicDrink.getId());

        Assert.assertEquals(alcoholicDrink.getId(), result.getId());
        Assert.assertEquals(alcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(alcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(alcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
        Assert.assertEquals(alcoholicDrink.getPercentAlcohol(), result.getPercentAlcohol());

    }

    @Test
    public void UpdateDrinkBatch() {
        setup();
        AlcoholicDrink alcoholicDrink = (AlcoholicDrink) oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(alcoholicDrink));

        AlcoholicDrink result = (AlcoholicDrink) batchDrinkService.find(alcoholicDrink.getId());

        Assert.assertEquals(alcoholicDrink.getId(), result.getId());
        Assert.assertEquals(alcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(alcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(alcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
        Assert.assertEquals(alcoholicDrink.getPercentAlcohol(), result.getPercentAlcohol());

    }

    @Test
    public void DeleteDrinkBatch() {
        setup();
        AlcoholicDrink alcoholicDrink = (AlcoholicDrink) oneAlcoholicBatchDrink().now();
        when(batchDrinkRepositoryMock.findById(any())).thenReturn(Optional.of(alcoholicDrink));

        AlcoholicDrink result = (AlcoholicDrink) batchDrinkService.find(alcoholicDrink.getId());

        Assert.assertEquals(alcoholicDrink.getId(), result.getId());
        Assert.assertEquals(alcoholicDrink.getAmount(), result.getAmount());
        Assert.assertEquals(alcoholicDrink.getDateTime(), result.getDateTime());
        Assert.assertEquals(alcoholicDrink.getResponsiblePerson(), result.getResponsiblePerson());
        Assert.assertEquals(alcoholicDrink.getPercentAlcohol(), result.getPercentAlcohol());

    }

}
