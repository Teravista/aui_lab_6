package proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.MeatType;
import proj.event.MeatTypeEventRepository;
import proj.function.PutMeatTypeRequest;
import proj.repository.MeatTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeatTypeDefaultService implements  MeatTypeService{

    private final MeatTypeRepository repository;
    private final MeatTypeEventRepository eventRepository;

    public List<MeatType> findAll()
    {
        return repository.findAll();
    }

    @Override
    public void update(PutMeatTypeRequest meatTypeRequest, UUID id) {
        MeatType value = repository.getById(id);
        value.setName(meatTypeRequest.getName());
        value.setPopularity(meatTypeRequest.getPopularity());
        repository.save(value);
    }


    @Autowired
    public MeatTypeDefaultService(MeatTypeRepository repository,MeatTypeEventRepository eventRepository) {
        this.repository=repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<MeatType> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(MeatType meatType,Boolean event_Flag) {
        repository.save(meatType);
        if(event_Flag) {eventRepository.create(meatType);} //cannot figure out how to transfer body over restTemplate
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
