package com.challange.drinkcontrol.resource;

import com.challange.drinkcontrol.domain.DrinkBatch;
import com.challange.drinkcontrol.domain.AlcoholicDrinkBatch;
import com.challange.drinkcontrol.dto.BatchDrinkDTO;
import com.challange.drinkcontrol.dto.DrinkAlcoholicDTO;
import com.challange.drinkcontrol.dto.DrinkNonAlcoholicDTO;
import com.challange.drinkcontrol.service.BatchDrinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Api(value = "API REST Drink")
@RestController
@RequestMapping("/drink")
public class BatchDrinkResource {

    @Autowired
    private BatchDrinkService batchDrinkService;

    @ApiOperation(value = "Find Batch of drink")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DrinkBatch> find(@PathVariable Integer id) {
        DrinkBatch drinkBatch = batchDrinkService.find(id);
        return ResponseEntity.ok().body(drinkBatch);
    }

    @ApiOperation(value = "Find all batches of drink")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<BatchDrinkDTO>> findAllBatchesPaginated(
            @RequestParam(value = "initialPage", defaultValue = "0") Integer page,
            @RequestParam(value = "linesAmount", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "orderField", defaultValue = "id") String orderBy,
            @RequestParam(value = "ascOrDesc", defaultValue = "asc") String direction) {
        Page<DrinkBatch> listBatches = batchDrinkService.findPage(page, linesPerPage, orderBy, direction);
        Page<BatchDrinkDTO> listDto = listBatches.map(dto ->
                (dto instanceof AlcoholicDrinkBatch ? new DrinkAlcoholicDTO(dto) : new DrinkNonAlcoholicDTO(dto)));
        return ResponseEntity.ok().body(listDto);
    }

    @ApiOperation(value = "Insert Batch of drink")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody BatchDrinkDTO batchDrinkDTO) {
        DrinkBatch drinkBatch = batchDrinkService.fromDTO(batchDrinkDTO);
        drinkBatch = batchDrinkService.insert(drinkBatch);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(drinkBatch.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Update Batch of drink")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody BatchDrinkDTO batchDrinkDTO, @PathVariable Integer id) {
        batchDrinkDTO.setId(id);
        DrinkBatch drinkBatch = batchDrinkService.fromDTO(batchDrinkDTO);
        batchDrinkService.update(drinkBatch);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete Batch of drink")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        batchDrinkService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @ApiOperation(value = "Find drink by type")

//    @ApiOperation(value = "Find total stored by type")

//    @ApiOperation(value = "Find session free")
}
