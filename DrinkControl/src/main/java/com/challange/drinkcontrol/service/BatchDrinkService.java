package com.challange.drinkcontrol.service;

import com.challange.drinkcontrol.domain.*;
import com.challange.drinkcontrol.dto.BatchDrinkDTO;
import com.challange.drinkcontrol.dto.DrinkAlcoholicDTO;
import com.challange.drinkcontrol.dto.DrinkNonAlcoholicDTO;
import com.challange.drinkcontrol.repository.BatchDrinkRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatchDrinkService {

    @Autowired
    private BatchDrinkRepository batchDrinkRepository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private DrinkTypeService drinkTypeService;

    public DrinkBatch find(Integer id) {
        Optional<DrinkBatch> batchDrink = batchDrinkRepository.findById(id);
        return batchDrink.orElseThrow(() -> new ObjectNotFoundException("Drink batch not found :Id" + id,
                "Type: " + DrinkBatch.class.getName()));
    }

    public Page<DrinkBatch> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction.toUpperCase()), orderBy);
        return batchDrinkRepository.findAll(pageRequest);
    }

    public DrinkBatch fromDTO(BatchDrinkDTO batchDrinkDTO) {

        DrinkBatch drinkBatch = null;

        Session session = sessionService.find(batchDrinkDTO.getIdSession());
        DrinkType drinkType = drinkTypeService.find(batchDrinkDTO.getIdDrinkType());

        if (batchDrinkDTO instanceof DrinkAlcoholicDTO) {

            drinkBatch = new AlcoholicDrinkBatch(batchDrinkDTO.getId()
                    , batchDrinkDTO.getDateTime()
                    , batchDrinkDTO.getAmount()
                    , session
                    , drinkType
                    , ((DrinkAlcoholicDTO) batchDrinkDTO).getPercentAlcohol()
            );
        }

        if (batchDrinkDTO instanceof DrinkNonAlcoholicDTO) {
            drinkBatch = new NonAlcoholicDrinkBatch(batchDrinkDTO.getId()
                    , batchDrinkDTO.getDateTime()
                    , batchDrinkDTO.getAmount()
                    , session
                    , drinkType
            );
        }
        return drinkBatch;
    }

    public DrinkBatch insert(DrinkBatch drinkBatch) {
        return batchDrinkRepository.save(drinkBatch);
    }

    public void update(DrinkBatch drinkBatch) {
        batchDrinkRepository.save(drinkBatch);
    }

    public void delete(Integer id) {
        try {
            batchDrinkRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("It's not possible delete a session that has drink");
        }
    }
}
