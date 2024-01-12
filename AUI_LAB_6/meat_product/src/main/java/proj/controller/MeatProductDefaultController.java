package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;
import proj.dto.GetMeatProductResponse;
import proj.dto.GetMeatProductsResponse;
import proj.function.MeatProductToResponseFunction;
import proj.function.MeatProductsToResponseFunction;
import proj.function.PutMeatProductRequest;
import proj.function.RequestToMeatProductFunction;
import proj.service.MeatProductService;

import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
public class MeatProductDefaultController implements MeatProductController{

    private final MeatProductService service;
    private final MeatProductsToResponseFunction meatProductsToResponse;
    private final MeatProductToResponseFunction meatProductToResponse;
    private final RequestToMeatProductFunction requestToMeatProduct;

    @Autowired
    public MeatProductDefaultController(MeatProductService service,
                                        MeatProductsToResponseFunction meatProductsToResponse,
                                        MeatProductToResponseFunction meatProductToResponse,
                                        RequestToMeatProductFunction requestToMeatProduct)
    {
        this.service=service;
        this.meatProductsToResponse=meatProductsToResponse;
        this.meatProductToResponse=meatProductToResponse ;
        this.requestToMeatProduct= requestToMeatProduct;
    }
    @Override
    public GetMeatProductsResponse GetMeatProducts() {
        return meatProductsToResponse.apply(service.findAll());
    }

    @Override
    public GetMeatProductResponse GetMeatProduct(UUID id) {
        return service.find(id)
                .map(meatProductToResponse)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetMeatProductsResponse GetMeatTypeProducts(UUID meatTypeId) {
        return service.findAllByMeatType(meatTypeId)
                .map(meatProductsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public void putMeatProduct( PutMeatProductRequest request) {
        service.create(requestToMeatProduct.apply(UUID.randomUUID(),request));
    }

    @Override
    public void putMeatProductById(PutMeatProductRequest request, UUID id) {
        service.create(requestToMeatProduct.apply(id,request));
    }

    @Override
    public void deleteMeatProduct(UUID id) {
        service.find(id).ifPresentOrElse(
                meatProduct -> service.delete(id),
                () ->{
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }
}
