package de.iav.backend.controller;

import de.iav.backend.model.Bag;
import de.iav.backend.repository.BagRepository;
import de.iav.backend.service.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bags")
@RequiredArgsConstructor
public class BagController {
    private final BagService bagService;
    private final BagRepository bagRepository;
    @GetMapping
    public List<Bag> getAllBags()
    {
       //Bag bag1 = new Bag("1","lunchbox","500", "Coach");
        //Bag bag2 = new Bag("2","MediumTote","250", "KS");
        //Bag bag3 = new Bag("3","LargeTote","450", "MK");
        //Bag bag4 = new Bag("4","LargeTote","450", "KS");
        //Bag bag5 = new Bag("5","Bucket","100", "CharlesAndKeith");
        //bagRepository.save(bag1);
        //bagRepository.save(bag2);
        //bagRepository.save(bag5);
        //bagRepository.save(bag4);
        return bagService.getAllBags();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBag(@RequestBody Bag bag){

        bagService.saveBag(bag);
    }
    @GetMapping("/type/{type}")
    public Optional<Bag> getBagByType(@PathVariable String type) {
        return bagService.getBagbyType(type);
    }

    @GetMapping("/id/{id}")
    public Optional<Bag> getBagById(@PathVariable String id) {
        return bagService.getBagById(id);
    }

}
