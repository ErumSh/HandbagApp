package de.iav.backend.service;



import de.iav.backend.model.Bag;
import de.iav.backend.repository.BagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BagService {
    private final BagRepository bagRepository;

    public List<Bag> getAllBags(){return bagRepository.findAll();}
    public Bag saveBag (Bag bag){
        System.out.println(bagRepository.save(bag));
        return bagRepository.save(bag);}
}
