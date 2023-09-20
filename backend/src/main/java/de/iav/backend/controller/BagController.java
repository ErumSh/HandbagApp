package de.iav.backend.controller;

import de.iav.backend.model.Bag;
import de.iav.backend.service.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bags")
@RequiredArgsConstructor
public class BagController {
    private final BagService bagService;

    @GetMapping
    public List<Bag> getAllBags()
    {
        return bagService.getAllBags();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bag saveBag(@RequestBody Bag bag){
        System.out.println(bag.toString());
        return bagService.saveBag(bag);
    }
}
