package com.pokedex.api_pokedex.service;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.enums.Evolucao;
import com.pokedex.api_pokedex.enums.Status;
import com.pokedex.api_pokedex.enums.Tipo;
import com.pokedex.api_pokedex.enums.Treinador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PokemonService {

    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    static Long proximoId = 1L;

    public PokemonService() {
        pokemons.add(new Pokemon(proximoId++,"Pikachu","Pika", Tipo.ELETRICO,null,50,18, Evolucao.SEGUNDA_EVOLUCAO,50,50,100, Treinador.ASH, Status.BATALHANDO));
        pokemons.add(new Pokemon(proximoId++,"Charmander","Cha",Tipo.FOGO,null,50,15,Evolucao.PRIMEIRA_EVOLUCAO,40,40,80,Treinador.CLEMENT,Status.FORA_DE_BATALHA));
        pokemons.add(new Pokemon(proximoId++,"Squartle","Squa",Tipo.AGUA,null,50,16,Evolucao.PRIMEIRA_EVOLUCAO,45,45,90,Treinador.SERENA,Status.FORA_DE_BATALHA));
        pokemons.add(new Pokemon(proximoId++,"Mewtwo","MewCU",Tipo.PSIQUICO,null,180,50,Evolucao.SEGUNDA_EVOLUCAO,70,270,380,Treinador.ASH,Status.FORA_DE_BATALHA));
    }

    public ArrayList<Pokemon> listarPokemons(){
        return pokemons;
    }

    public Pokemon buscarPokemonId(Long id){

        if (id <= 0 ) {
            throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
        }

        for(Pokemon p : pokemons) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public Pokemon cadastrarPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
        return pokemon;
    }

    public Pokemon atualizarDados(Long id,Pokemon pokemon){

        if (id <= 0 ) {
            throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
        }

        for (Pokemon p : pokemons) {
            if (p.getId() == id) {
                p.setId(pokemon.getId());
                p.setNome(pokemon.getNome());
                p.setTipo1(pokemon.getTipo1());
                p.setVida(pokemon.getVida());
                p.setNivel(pokemon.getNivel());
                p.setEvolucao(p.getEvolucao());

                return p;
            }
        }

        return null;
    }

    public Pokemon deletarPokemon(Long id){

        if (id <= 0 ) {
            throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
        }

        for(Pokemon p : pokemons) {
            if (p.getId() == id) {
                pokemons.remove(p);
                return p;
            }
        }

        return null;
    }

    public ArrayList<Pokemon> listarPokemonsTipo(String tipo){

        if (tipo.isBlank() || tipo.isEmpty()){
            throw new RuntimeException("ERRO - O tipo não pode ser nulo");
        }

        ArrayList<Pokemon> pokemonsEncontrados = new ArrayList<>();

        for (Pokemon p : pokemons){
            if (p.getTipo1().equals(tipo)){
                pokemonsEncontrados.add(p);
            }
        }
        return pokemonsEncontrados;
    }

    public Pokemon listarPokemonsNome(String nome){

        if (nome.isBlank() || nome.isEmpty()){
            throw new RuntimeException("ERRO - O tipo não pode ser nulo");
        }

        for (Pokemon p : pokemons){
            if (p.getNome().equals(nome)){
                return p;
            }
        }
        return null;
    }

    public ArrayList<Pokemon> listarPorNivel(int nivel){

        if (nivel <= 0){
            throw new RuntimeException("ERRO - O nivel do pokemon não pode ser igual ou menor que 0");
        }
        ArrayList<Pokemon> pokemonsEncontrados = new ArrayList<>();

        for (Pokemon p : pokemons){
            if (p.getNivel() > nivel){
                pokemonsEncontrados.add(p);
            }
        }
        return pokemonsEncontrados;
    }

    public Pokemon atualizarONivel(Long id,Pokemon pokemon){

        for (Pokemon p : pokemons){
            if (p.getId().equals(id)){
                p.setNivel(pokemon.getNivel());
                return p;
            }
        }
        return null;
    }

    public Pokemon curarPokemon(Long id , Pokemon pokemon){

        if (id <= 0 ) {
            throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
        }

        for (Pokemon p : pokemons){
            if (p.getId().equals(id)){
                p.setVida(p.getVida()+ pokemon.getVida());

                return p;
            }
        }
        return null;
    }

    public Pokemon evouluirPokemon(Long id, Pokemon pokemon){

        if (id <= 0 ) {
            throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
        }

        for (Pokemon p : pokemons){
            if (p.getId().equals(id)){
                p.setEvolucao(pokemon.getEvolucao());
                p.setNome(pokemon.getNome());

                return p;
            }
        }
        return null;
    }

    public Pokemon pokemonMaisForte() {

        int ataqueMaisforte = 0;
        Pokemon pokemonMaisforte = null;

        for (Pokemon p : pokemons){
            if (p.getAtaque() > ataqueMaisforte){

                pokemonMaisforte = p;
                ataqueMaisforte = p.getAtaque();
            }
        }
        return pokemonMaisforte;
    }

    public void adicionarPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    // Novos Métodos
}
