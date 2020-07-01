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

    public BatchDrink find(Integer id) {
        Optional<BatchDrink> batchDrink = batchDrinkRepository.findById(id);
        return batchDrink.orElseThrow(() -> new ObjectNotFoundException("Drink batch not found :Id" + id,
                "Type: " + BatchDrink.class.getName()));
    }

    public Page<BatchDrink> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction.toUpperCase()), orderBy);
        return batchDrinkRepository.findAll(pageRequest);
    }

    public BatchDrink fromDTO(BatchDrinkDTO batchDrinkDTO) {

        BatchDrink batchDrink = null;

        Session session = sessionService.find(batchDrinkDTO.getIdSession());
        DrinkType drinkType = drinkTypeService.find(batchDrinkDTO.getIdDrinkType());

        if (batchDrinkDTO instanceof DrinkAlcoholicDTO) {

            batchDrink = new AlcoholicDrink(batchDrinkDTO.getId()
                    , batchDrinkDTO.getDateTime()
                    , batchDrinkDTO.getAmount()
                    , session
                    , drinkType
                    , ((DrinkAlcoholicDTO) batchDrinkDTO).getPercentAlcohol()
            );
        }

        if (batchDrinkDTO instanceof DrinkNonAlcoholicDTO) {
            batchDrink = new NonAlcoholicDrink(batchDrinkDTO.getId()
                    , batchDrinkDTO.getDateTime()
                    , batchDrinkDTO.getAmount()
                    , session
                    , drinkType
            );
        }
        return batchDrink;
    }

    public BatchDrink insert(BatchDrink batchDrink) {
        return batchDrinkRepository.save(batchDrink);
    }

    public void update(BatchDrink batchDrink) {
        batchDrinkRepository.save(batchDrink);
    }

    public void delete(Integer id) {
        try {
            batchDrinkRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("It's not possible delete a session that has drink");
        }
    }
}
