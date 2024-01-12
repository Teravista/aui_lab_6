package proj.service;

import proj.MeatProduct;
import proj.MeatType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MeatProductService {
    Optional<MeatProduct> find(UUID id);

    Optional<MeatProduct> find(MeatType meatType,UUID id);

    List<MeatProduct> findAll();

    List<MeatProduct> findAll(MeatType meatType);

    void create(MeatProduct meatProduct);

    void update(MeatProduct meatProduct);

    void delete(UUID id);

    Optional<List<MeatProduct>> findAllByMeatType(UUID meatTypeId);
}
