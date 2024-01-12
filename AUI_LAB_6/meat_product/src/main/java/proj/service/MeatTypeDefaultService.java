package proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.MeatType;
import proj.repository.MeatTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeatTypeDefaultService implements  MeatTypeService{

    private final MeatTypeRepository repository;

    public List<MeatType> findAll()
    {
        return repository.findAll();
    }


    @Autowired
    public MeatTypeDefaultService(MeatTypeRepository repository) {this.repository=repository;}

    @Override
    public Optional<MeatType> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(MeatType meatType) {repository.save(meatType);}

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
