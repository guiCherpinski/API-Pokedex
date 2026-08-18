package com.pokedex.api_pokedex.service;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.enums.*;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ArenaService {

    PokemonService pokemonService = new PokemonService();
    Random gerador = new Random();
    static Pokemon pokemon2 = new Pokemon(67L,"Rayquaza","Verdão", Tipo.DRAGAO
            ,Tipo.VOADOR,230,70, Evolucao.MEGA_EVOLUCAO,80,110,370, Treinador.BROCK, Status.BATALHANDO);

    public String atacar(Long p1){

        int danoDado = 0;
        int danoRecebido = 0;
        Pokemon pokemon1 = null;

        for (Pokemon p : pokemonService.listarPokemons()) {
            if (p1.equals(p.getId())) {
                pokemon1 = p;
                break;
            }
        }

        pokemon1.setStatus(Status.BATALHANDO);

        if (pokemon1.getVida() <= 0) {
            throw new RuntimeException("ERRO - POKEMON ESTÁ DESMAIADO E NÃO PODE ATACAR!");
        }
        if (pokemon2 == null) {
            throw new RuntimeException("ERRO - DEVE HAVER UM POKEMON PARA EXECUTAR O ATAQUE");
        }
        if (pokemon2.getVida() <= 0){
            throw new RuntimeException("ERRO - NÃO É POSSIVEL ATACAR UM POKEMON DESMAIADO");
        }

        if (pokemon1.getVelocidade() > pokemon2.getVelocidade()) {
            danoDado = pokemon1.atacar();
            pokemon2.setVida(pokemon2.getVida() - danoDado);

            if (pokemon2.getVida() <= 0) {
                return pokemon2.desmaiar(pokemon1.getNome(),pokemon2.getNome());
            }

            danoRecebido = pokemon2.atacar();
            pokemon1.setVida(pokemon1.getVida() - danoRecebido);

            if (pokemon1.getVida() <= 0) {
                return pokemon1.desmaiar(pokemon2.getNome(),pokemon1.getNome());
            }

            return pokemon1.getNome()+" atacou primeiro causando "+danoDado+" de dano em "+pokemon2.getNome()+" restando "+pokemon2.getVida();
        } else {
            danoDado = pokemon2.atacar();
            pokemon1.setVida(pokemon1.getVida() - danoDado);

            if (pokemon1.getVida() <= 0) {
                return pokemon2.desmaiar(pokemon2.getNome(),pokemon1.getNome());
            }

            danoRecebido = pokemon1.atacar();
            pokemon2.setVida(pokemon2.getVida() - danoRecebido);

            if (pokemon2.getVida() <= 0){
                return pokemon1.desmaiar(pokemon1.getNome(),pokemon2.getNome());
            }

            return pokemon2.getNome()+" atacou primeiro causando "+danoDado+" de dano em "+pokemon1.getNome()+" restando "+pokemon1.getVida();
        }
    }

    public String fugir(Long id){

        try {
            int x = gerador.nextInt(0,100);

            for (Pokemon p : pokemonService.listarPokemons()){
                if (id.equals(p.getId())){


                    if (p.getStatus().equals(Status.FORA_DE_BATALHA)){
                        throw new RuntimeException("ERRO - O pokemon que foi selecionado não está em uma batalha");
                    }
                    if (p.getVida() <= 0){
                        throw new RuntimeException("ERRO - O pokemon está desmaiado não consegue fugir");
                    }

                    return p.fugir(x);
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    public String esquivar (Long id) {

        int x = gerador.nextInt(100);
        int danoOponente = 0;

        for (Pokemon p : pokemonService.listarPokemons()) {
            if (id.equals(p.getId())) {
                if (p.getStatus().equals(Status.FORA_DE_BATALHA)){
                    throw new RuntimeException("ERRO - O pokemon que foi selecionado não está em uma batalha");
                }
                if (p.getVida() <= 0){
                    throw new RuntimeException("ERRO - O pokemon está desmaiado não consegue esquivar");
                }
                if (x > 50) {
                    return p.esquivar(x);
                }else {
                    danoOponente = pokemon2.getAtaque();
                    p.setVida(p.getVida() - danoOponente);
                    return p.esquivar(x);
                }
            }
        }

        return null;
    }

    public String usarItem(Long id, Item item){

        for (Pokemon p : pokemonService.listarPokemons()) {
            if (id.equals(p.getId())){

                if (item == Item.POCAO){
                    p.setVida(p.getVida() + 20);
                    return p.usarItem("POÇÃO",p.getNome(),20);
                }
                if (item == Item.SUPER_POCAO){
                    p.setVida(p.getVida() + 40);
                    return p.usarItem("SUPER_POÇÃO",p.getNome(),40);
                }
                if (item == Item.HIPER_POCAO){
                    p.setVida(p.getVida() + 60);
                    return p.usarItem("SUPER_POÇÃO",p.getNome(),60);
                }
            }
        }
        return null;
    }

    public String evoluirPokemon (Long id, Pokemon pokemon) {

        String nome = "";

        for (Pokemon p : pokemonService.listarPokemons()) {
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

                    return nome + " evoluiu para " + pokemon.getNome();
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

                    return nome + " evoluiu para " + pokemon.getNome();
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

                    return nome + " evoluiu para " + pokemon.getNome();
                }
            }
        }

        return null;
    }
}
