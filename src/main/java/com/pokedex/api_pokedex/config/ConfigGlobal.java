package com.pokedex.api_pokedex.config;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.enums.Evolucao;
import com.pokedex.api_pokedex.enums.Status;
import com.pokedex.api_pokedex.enums.Tipo;
import com.pokedex.api_pokedex.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigGlobal {

    @Bean
    CommandLineRunner initDatabase(PokemonRepository repository) {
        return args -> {
            repository.save(new Pokemon("Pikachu","Pika", Tipo.ELETRICO,null,50,18, Evolucao.PRIMEIRA_EVOLUCAO,50,50,100, null, Status.BATALHANDO));
            repository.save(new Pokemon("Charmander","Cha",Tipo.FOGO,null,50,15,Evolucao.BASE,40,40,80, null,Status.FORA_DE_BATALHA));
            repository.save(new Pokemon("Squartle","squa",Tipo.AGUA,null,45,16,Evolucao.BASE,35,30,70, null,Status.DESMAIADO));
            repository.save(new Pokemon("RAYQUAZA","Rayquaza",Tipo.DRAGAO,null,250,70,Evolucao.BASE,170,240,280, null,Status.FORA_DE_BATALHA));
            repository.save(new Pokemon("ONIX","oni",Tipo.PEDRA,null,75,35,Evolucao.SEGUNDA_EVOLUCAO,70,80,50, null,Status.FORA_DE_BATALHA));
        };
    }
}
