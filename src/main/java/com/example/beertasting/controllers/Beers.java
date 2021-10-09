package com.example.beertasting.controllers;

import com.example.beertasting.models.Beer;
import com.example.beertasting.repositories.BeerRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Beers controller", description = "REST endpoints for beerratings mandatory1")
@RestController
public class Beers {

    @Autowired
    BeerRepository beers;

    @GetMapping("/beers")
    public Iterable<Beer> getBeers(){
        return beers.findAll();
    }

    @GetMapping("/beers/{id}")
    public Beer getBeer(@PathVariable Long id){
        return beers.findById(id).get();
    }

    @PostMapping("/beers")
    public Beer addBeer(@RequestBody Beer newBeer){
        newBeer.setId(null);
        return beers.save(newBeer);
    }

    @PutMapping("/beers/{id}")
    public String updateBeerById(@PathVariable Long id, @RequestBody Beer beerToUpdate){
        return beers.findById(id).map(foundBeer -> {
            foundBeer.setName(beerToUpdate.getName());
            foundBeer.setBeerType(beerToUpdate.getBeerType());
            foundBeer.setDateTasted(beerToUpdate.getDateTasted());
            foundBeer.setLooks(beerToUpdate.getLooks());
            foundBeer.setSmell(beerToUpdate.getSmell());
            foundBeer.setTaste(beerToUpdate.getTaste());
            foundBeer.setMouthfeel(beerToUpdate.getMouthfeel());
            foundBeer.setOverallScore(beerToUpdate.getOverallScore());
            beers.save(foundBeer);
            return "Beer updated";
        }).orElse("Beer not found");
    }

    @DeleteMapping("/beers/{id}")
    public void deleteBeer(@PathVariable Long id){
        beers.deleteById(id);
    }




}
