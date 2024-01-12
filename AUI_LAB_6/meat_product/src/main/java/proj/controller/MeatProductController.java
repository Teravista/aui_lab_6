package proj.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import proj.dto.GetMeatProductResponse;
import proj.dto.GetMeatProductsResponse;
import proj.function.PutMeatProductRequest;

import java.util.UUID;

public interface MeatProductController {
    @GetMapping("api/meatProducts")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMeatProductsResponse GetMeatProducts();
    @GetMapping("/api/meatProducts/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMeatProductResponse GetMeatProduct( @PathVariable("id")UUID id);

    @GetMapping("/api/meatTypes/{meatTypeId}/meatProducts")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMeatProductsResponse GetMeatTypeProducts(@PathVariable("meatTypeId")UUID meatTypeId);

    @PutMapping("/api/meatProducts")
    @ResponseStatus(HttpStatus.CREATED)
    void putMeatProduct(@RequestBody PutMeatProductRequest request);

    @PutMapping("/api/meatProducts/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putMeatProductById(@RequestBody PutMeatProductRequest request,@PathVariable("id")UUID id);
    @DeleteMapping("/api/meatProducts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMeatProduct(@PathVariable("id")UUID id);
}
