package br.com.anime.shamble.service;

import br.com.anime.shamble.dto.PokedexDto;
import br.com.anime.shamble.model.Pokedex;
import br.com.anime.shamble.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokedexService {

    @Autowired
    PokedexRepository repository;

    public List<PokedexDto> getAll(){
        List<PokedexDto> listDto = new ArrayList<PokedexDto>();
        List<Pokedex> listPokemon =  repository.findAll();

        for(Pokedex pokemon : listPokemon){
            listDto.add(fillDto(pokemon.getId(), pokemon.getName(), pokemon.getGen()));;
        }
        return listDto;
    }
    private Optional<Pokedex> getById(int id){
        return repository.findById(id);
    }

    public PokedexDto findById(int id){
        Optional<Pokedex> result = getById(id);

        if(result.isPresent()){
            Pokedex pokemon = result.get();
            return fillDto(pokemon.getId(), pokemon.getName(), pokemon.getGen());
        };
        return null;
    };

    public void savePokemon(PokedexDto pokemonDto){
        Pokedex pokemon = new Pokedex();

        repository.save(fillPokedex(pokemon, pokemonDto.getNational(), pokemonDto.getName(), pokemonDto.getGen()));
    }

    public void updatePokemon(int id, PokedexDto pokemonDto){
        Optional<Pokedex> result  = getById(id);

        if(result.isPresent()){
            Pokedex pokemon = result.get();

            repository.save(fillPokedex(pokemon, pokemonDto.getNational(), pokemonDto.getName(), pokemonDto.getGen()));
        }
    }

    public void deletePokemon(int id){
        repository.deleteById(id);
    }

    private PokedexDto fillDto(int id, String name, int gen){
        PokedexDto pokemonDto = new PokedexDto();

        pokemonDto.setNational(id);
        pokemonDto.setName(name);
        pokemonDto.setGen(gen);

        return pokemonDto;
    }

    private Pokedex fillPokedex(Pokedex pokemon, int id, String name, int gen){
        System.out.println(pokemon);

        pokemon.setId(id);
        pokemon.setName(name);
        pokemon.setGen(gen);
        System.out.println(pokemon);

        return pokemon;
    }
}
