package br.com.anime.shamble.repository;

import br.com.anime.shamble.model.Pokedex;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokedexRepository extends MongoRepository<Pokedex, Integer> {
}
