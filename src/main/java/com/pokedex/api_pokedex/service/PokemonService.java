package com.pokedex.api_pokedex.service;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.enums.*;
import com.pokedex.api_pokedex.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> listarPokemons(){
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> buscarPokemonId(Long id){

        try {

            if (id <= 0 ) {
                throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
            }

            return pokemonRepository.findById(id);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Pokemon cadastrarPokemon(Pokemon pokemon){

        try {

            if (pokemon == null) {
                throw new RuntimeException("ERRO - FALTA DADOS PARA CRIAR O POKEMON");
            }

            return pokemonRepository.save(pokemon);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Pokemon atualizarDados(Long id,Pokemon pokemon){

        try {

            if (id <= 0 ) {
                throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
            }

            Pokemon p = pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("ERRO - POKEMON NÃO ENCONTRADO"));
            p.setNome(pokemon.getNome());
            p.setApelido(pokemon.getApelido());
            p.setTipo1(pokemon.getTipo1());
            p.setTipo2(pokemon.getTipo2());
            p.setVida(pokemon.getVida());
            p.setNivel(pokemon.getNivel());
            p.setEvolucao(pokemon.getEvolucao());
            p.setDefesa(pokemon.getDefesa());
            p.setAtaque(pokemon.getAtaque());
            p.setVelocidade(pokemon.getVelocidade());
            p.setTreinador(pokemon.getTreinador());
            p.setStatus(pokemon.getStatus());

            return pokemonRepository.save(p);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
//
    public String deletarPokemon(Long id){

        try {
            if (id <= 0 ) {
                throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
            }

            if (!pokemonRepository.existsById(id)) {
                throw new RuntimeException("ERRO - POKEMON NÃO EXISTE!");
            }

            pokemonRepository.deleteById(id);

            return "POKEMON EXCLUIDO COM SUCESSO!";

        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public List<Pokemon> listarPokemonsTipo(String tipo){

        try {

            if (tipo.isBlank() || tipo.isEmpty()){
                throw new RuntimeException("ERRO - O tipo não pode ser nulo");
            }

            Tipo tipoEncontrado= Tipo.valueOf(tipo.trim().toUpperCase());

            List<Pokemon> pokemonsEncontrados = pokemonRepository.findByTipo(tipoEncontrado);

            if (pokemonsEncontrados.isEmpty()) {
                throw new RuntimeException("ERRO - NENHUM POKEMON FOI ENCONTRADO!");
            }

            return pokemonsEncontrados;

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pokemon> listarPokemonsNome(String nome){

        try {

            if (nome.isBlank() || nome.isEmpty()){
                throw new RuntimeException("ERRO - O tipo não pode ser nulo");
            }

            List<Pokemon> pokemonsEncontrados = pokemonRepository.findByNome(nome);

            if (pokemonsEncontrados.isEmpty()) {
                throw new RuntimeException("ERRO - NENHUM POKEMON FOI ENCONTRADO!");
            }

            return pokemonsEncontrados;

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pokemon> listarPorNivel(int nivel){

        try {
            if (nivel <= 0){
                throw new RuntimeException("ERRO - O nivel do pokemon não pode ser igual ou menor que 0");
            }

            List<Pokemon> pokemonsEncontrados = pokemonRepository.findByNivel(nivel);

            if (pokemonsEncontrados.isEmpty()) {
                throw new RuntimeException("ERRO - NENHUM POKEMON FOI ENCONTRADO!");
            }

            return pokemonsEncontrados;

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Pokemon curarPokemon(Long id , Pokemon pokemon){

        try {
            if (id <= 0 ) {
                throw new RuntimeException("ERRO - ID não pode ser igual a 0 e nem menor");
            }

            Pokemon p = pokemonRepository.findById(id).orElseThrow(()
                    -> new RuntimeException("ERRO - POKEMON NÃO ENCONTRADO"));

            p.setVida(p.getVida() + pokemon.getVida());

            return p;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Pokemon pokemonMaisForte() {

        try {
            int ataqueMaisforte = 0;
            Pokemon pokemonMaisforte = null;
            List<Pokemon> poquemoins = pokemonRepository.findAll();

            if (poquemoins.isEmpty()) {
                throw new RuntimeException("ERRO - NENHUM POKEMON FOI ENCONTRADO");
            }

            for (Pokemon p : poquemoins) {
                if (p.getAtaque() > ataqueMaisforte) {

                    pokemonMaisforte = p;
                    ataqueMaisforte = p.getAtaque();
                }
            }
            return pokemonMaisforte;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String evoluirPokemon (Long id, Pokemon pokemon) {

        try {
            String nome = "";

            List<Pokemon> listarPokemons = pokemonRepository.findAll();

            if (listarPokemons.isEmpty()) {
                throw new RuntimeException("ERRO - NENHUM POKEMON FOI ENCONTRADO!");
            }

            for (Pokemon p : listarPokemons()) {
                if (id.equals(p.getId())) {

                    nome = p.getNome();

                    if (p.getEvolucao() == Evolucao.MEGA_EVOLUCAO) {
                        throw new RuntimeException("ERRO - IMPOSSIVEL EVOLUIR UMA MEGA EVOLUÇÃO");
                    }

                    if (p.getEvolucao() == Evolucao.BASE) {
                        p.setNome(pokemon.getNome());
                        p.setEvolucao(Evolucao.PRIMEIRA_EVOLUCAO);
                        p.setAtaque(pokemon.getAtaque());
                        p.setVida(pokemon.getVida());
                        p.setDefesa(pokemon.getDefesa());
                        p.setTipo2(pokemon.getTipo2());
                        p.setVelocidade(pokemon.getVelocidade());
                        p.setApelido(pokemon.getApelido());

                        pokemonRepository.save(p);

                        return p.evoluir(nome, p.getEvolucao(), p.getNome());
                    }

                    if (p.getEvolucao() == Evolucao.PRIMEIRA_EVOLUCAO) {
                        p.setNome(pokemon.getNome());
                        p.setEvolucao(Evolucao.PRIMEIRA_EVOLUCAO);
                        p.setAtaque(pokemon.getAtaque());
                        p.setVida(pokemon.getVida());
                        p.setDefesa(pokemon.getDefesa());
                        p.setTipo2(pokemon.getTipo2());
                        p.setVelocidade(pokemon.getVelocidade());
                        p.setApelido(pokemon.getApelido());

                        pokemonRepository.save(p);

                        return p.evoluir(nome, p.getEvolucao(), p.getNome());
                    }

                    if (p.getEvolucao() == Evolucao.SEGUNDA_EVOLUCAO) {
                        p.setNome(pokemon.getNome());
                        p.setEvolucao(Evolucao.PRIMEIRA_EVOLUCAO);
                        p.setAtaque(pokemon.getAtaque());
                        p.setVida(pokemon.getVida());
                        p.setDefesa(pokemon.getDefesa());
                        p.setTipo2(pokemon.getTipo2());
                        p.setVelocidade(pokemon.getVelocidade());
                        p.setApelido(pokemon.getApelido());

                        pokemonRepository.save(p);

                        return p.evoluir(nome, p.getEvolucao(), p.getNome());
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
//
    public String subirNivel (Long id , Candys candys) {
//
        try {

            List<Pokemon> listarPokemons = pokemonRepository.findAll();

            if (listarPokemons.isEmpty()) {
                throw new RuntimeException("ERRO - NÃO HÁ NENHUM POKEMON!");
            }
//
            for (Pokemon p : listarPokemons()) {
                if (id.equals(p.getId())) {
//
                    if (p.getNivel() >= 100) {
                        throw new RuntimeException("ERRO - LEVEL MAXIMO JA ATINGIDO!");
                    }
//
                    if (candys == Candys.DOCE_PEQUENO) {
                        p.setNivel(p.getNivel() + 2);
                    }
//
                    if (candys == Candys.DOCE_MEDIO) {
                        p.setNivel(p.getNivel() + 4);
                    }
//
                    if (candys == Candys.DOCE_GRANDE) {
                        p.setNivel(p.getNivel() + 6);
                    }
//
                    if (candys == Candys.DOCE_EXTRA_GRANDE) {
                        p.setNivel(p.getNivel() + 8);
                    }
//
                    if (candys == Candys.DOCE_GIGA) {
                        p.setNivel(p.getNivel() + 10);
                    }
//
                    if (candys == Candys.RARE_CANDY) {
                        p.setNivel(p.getNivel() + 12);
                    }
//
                    if (p.getNivel() > 100) {
                        p.setNivel(100);
                    }
//
                    pokemonRepository.save(p);
                    return p.subirNivel(p.getNome(),p.getNivel());
                }
            }
        } catch (RuntimeException e) {
            return e.getMessage();
        }
//
        return null;
    }
//
    public String movimentarPokemon(Long id, Direcao direcao){

        try {

            Pokemon p = null;
            if (!pokemonRepository.existsById(id)) {
                throw new RuntimeException("ERRO - POKEMON NÃO ENCONTRADO!");
            } else {
                p = pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("ERRO - POKEMON NÃO ENCONTRADO"));
            }

            switch (direcao) {
                case DIREITA -> {
                    return p.movimentar(p.getNome(),Direcao.DIREITA);
                }
                case ESQUERDA -> {
                    return p.movimentar(p.getNome(),Direcao.ESQUERDA);
                }
                case FRENTE -> {
                    return p.movimentar(p.getNome(),Direcao.FRENTE);
                }
                case BAIXO -> {
                    return p.movimentar(p.getNome(),Direcao.BAIXO);
                }
            }
        } catch (RuntimeException e){
            return e.getMessage();
        }

        return null;
    }


}//
//