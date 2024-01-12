package proj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proj.dto.GetMeatTypeResponse;
import proj.dto.GetMeatTypesResponse;
import proj.function.PutMeatTypeRequest;

import java.util.UUID;

public interface MeatTypeController {
    @GetMapping("api/meatTypes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMeatTypesResponse GetMeatTypes();

    @GetMapping("/api/meatTypes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMeatTypeResponse GetMeatType(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/meatTypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMeatType(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/meatTypes")
    @ResponseStatus(HttpStatus.CREATED)
    void PutMeatType(@RequestBody PutMeatTypeRequest request
    );

    @PutMapping("/api/meatTypes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void PutMeatTypeById(@RequestBody PutMeatTypeRequest request,
                         @PathVariable("id")
                         UUID id
    );

}
