package proj.service;

import proj.MeatType;
import proj.function.PutMeatTypeRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MeatTypeService {
    Optional<MeatType> find(UUID id);
    List<MeatType> findAll();

    void update(PutMeatTypeRequest meatTypeRequest,UUID id);
    void create(MeatType meatType,Boolean event_Flag);

    void delete(UUID id);
}
