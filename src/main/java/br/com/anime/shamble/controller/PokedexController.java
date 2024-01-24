package br.com.anime.shamble.controller;

import br.com.anime.shamble.dto.PokedexDto;
import br.com.anime.shamble.model.Pokedex;
import br.com.anime.shamble.repository.PokedexRepository;
import br.com.anime.shamble.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {
    @Autowired
    PokedexService service;

    @GetMapping
    public List<PokedexDto> getall(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PokedexDto findById(@PathVariable int id){
        return service.findById(id);
    }
    @PostMapping
    public void save(@RequestBody PokedexDto dto){
        service.savePokemon(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody PokedexDto dto){
        service.updatePokemon(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.deletePokemon(id);
    }

}