package proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.MeatProduct;
import proj.MeatType;
import proj.repository.MeatProductRepository;
import proj.repository.MeatTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeatProductDefaultService implements MeatProductService{

    private final MeatProductRepository repository;

    private final MeatTypeRepository meatTypeRepository;

    @Autowired
    public MeatProductDefaultService(MeatProductRepository repository,
                                     MeatTypeRepository meatTypeRepository)
    {
        this.repository=repository;
        this.meatTypeRepository=meatTypeRepository;
    }


    @Override
    public Optional<MeatProduct> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<MeatProduct> find(MeatType meatType, UUID id) {
        return repository.findByIdAndMeatType(id,meatType);

    }

    @Override
    public List<MeatProduct> findAll() {
        return repository.findAll();
    }

    @Override
    public List<MeatProduct> findAll(MeatType meatType) {
        return repository.findAllByMeatType(meatType);
    }

    @Override
    public void create(MeatProduct meatProduct) {
        repository.save(meatProduct);
    }

    @Override
    public void update(MeatProduct meatProduct) {
        repository.save(meatProduct);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<List<MeatProduct>> findAllByMeatType(UUID meatTypeId) {
        return meatTypeRepository.findById(meatTypeId)
                .map(repository::findAllByMeatType);
    }
}
