package br.com.anime.shamble.service;

import br.com.anime.shamble.dto.PokedexDto;
import br.com.anime.shamble.model.Pokedex;
import br.com.anime.shamble.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PokedexService {

    @Autowired
    PokedexRepository repository;

    public void savePokemon(PokedexDto pokemonDto){
        Pokedex pokemon = new Pokedex();

        pokemon.setId(pokemonDto.getNational());
        pokemon.setName(pokemonDto.getName());
        pokemon.setGen(pokemonDto.getGen());

        repository.save(pokemon);
    }
}
