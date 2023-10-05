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
        Bag bag1 = new Bag("1","lunchbox","23", "KS");
        Bag bag2 = new Bag("2","tabby","25", "KS");
        bagRepository.save(bag1);
        bagRepository.save(bag2);
        return bagService.getAllBags();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bag saveBag(@RequestBody Bag bag){
        return bagService.saveBag(bag);
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
