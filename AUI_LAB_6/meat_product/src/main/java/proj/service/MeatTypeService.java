package proj.service;

import proj.MeatProduct;
import proj.MeatType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MeatTypeService {
    Optional<MeatType> find(UUID id);
    List<MeatType> findAll();


    void create(MeatType meatType);

    void delete(UUID id);
}
