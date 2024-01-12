package proj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proj.dto.GetMeatProductsResponse;
import proj.dto.GetMeatTypeResponse;
import proj.dto.GetMeatTypesResponse;
import proj.function.PutMeatProductRequest;
import proj.function.PutMeatTypeRequest;

import java.util.UUID;

public interface MeatTypeController {


    @DeleteMapping("/api/meatTypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMeatType(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/meatTypes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMeatTypesResponse getMeatType(
    );

    @PutMapping("/api/meatTypes")
    @ResponseStatus(HttpStatus.CREATED)
    void PutMeatType(@RequestBody PutMeatTypeRequest request
    );

    @PutMapping("/api/meatTypes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void PutMeatTypeWithID(
            @PathVariable("id") UUID id,
            @RequestBody PutMeatTypeRequest request
    );

}
