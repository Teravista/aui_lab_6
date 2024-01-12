package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;
import proj.dto.GetMeatProductsResponse;
import proj.dto.GetMeatTypeResponse;
import proj.dto.GetMeatTypesResponse;
import proj.function.*;
import proj.service.MeatProductService;
import proj.service.MeatTypeService;

import java.util.UUID;

@Controller
public class MeatTypeDefaultController implements MeatTypeController{

    private final MeatTypeService service;
    private final RequestToMeatTypeFunction requestToMeatType;

    private final MeatTypesToResponseFunction meatTypesToResponseFunction;

    @Autowired
    public MeatTypeDefaultController(MeatTypeService service,RequestToMeatTypeFunction requestToMeatType,MeatTypesToResponseFunction meatTypesToResponseFunction) {
        this.service = service;
        this.requestToMeatType=requestToMeatType;
        this.meatTypesToResponseFunction=meatTypesToResponseFunction;
    }

    @Override
    public void deleteMeatType(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public GetMeatTypesResponse getMeatType() {
        return meatTypesToResponseFunction.apply(service.findAll());
    }

    @Override
    public void PutMeatType(PutMeatTypeRequest request) {
        service.create(requestToMeatType.apply(UUID.randomUUID(),request));
    }

    @Override
    public void PutMeatTypeWithID(UUID id, PutMeatTypeRequest request) {
        service.create(requestToMeatType.apply(id,request));
    }
}
