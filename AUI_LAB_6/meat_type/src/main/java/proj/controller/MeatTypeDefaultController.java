package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;
import proj.dto.GetMeatTypeResponse;
import proj.dto.GetMeatTypesResponse;
import proj.function.*;
import proj.service.MeatTypeService;

import java.util.UUID;

@Controller
public class MeatTypeDefaultController implements MeatTypeController{

    private final MeatTypeService service;
    private final MeatTypesToResponseFunction meatTypesToResponse;
    private final MeatTypeToResponseFunction meatTypeToResponse;

    private final RequestToMeatTypeFunction requestToMeatType;


    @Autowired
    public MeatTypeDefaultController(MeatTypeService service,
                                     MeatTypesToResponseFunction meatTypesToResponse,
                                     MeatTypeToResponseFunction meatTypeToResponse,
                                     RequestToMeatTypeFunction requestToMeatType
                                        ) {
        this.meatTypeToResponse=meatTypeToResponse;
        this.meatTypesToResponse=meatTypesToResponse;
        this.service = service;
        this.requestToMeatType=requestToMeatType;
    }
    @Override
    public GetMeatTypesResponse GetMeatTypes()
    {
        return meatTypesToResponse.apply(service.findAll());
    }

    @Override
    public GetMeatTypeResponse GetMeatType(UUID id) {
        return service.find(id)
                .map(meatTypeToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
    public void PutMeatType(PutMeatTypeRequest request) {
        service.create(requestToMeatType.apply(UUID.randomUUID(),request),true);
    }

    @Override
    public void PutMeatTypeById(PutMeatTypeRequest request, UUID id) {
        service.update(request,id);
    }
}
