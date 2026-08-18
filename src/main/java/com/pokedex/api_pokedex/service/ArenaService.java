package com.pokedex.api_pokedex.service;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.enums.Evolucao;
import com.pokedex.api_pokedex.enums.Status;
import com.pokedex.api_pokedex.enums.Tipo;
import com.pokedex.api_pokedex.enums.Treinador;

import java.util.Random;

public class ArenaService {

    PokemonService pokemonService = new PokemonService();
    Random gerador = new Random();

    public String atacar(Long p1){

        //Long x = gerador.nextLong(p1 + 1,4);
        int danoCausado = 0;
        Pokemon pokemon1 = null;
        Pokemon pokemon2 = new Pokemon(67L,"Rayquaza","Verdão", Tipo.DRAGAO
                ,Tipo.VOADOR,230,70, Evolucao.MEGA_EVOLUCAO,80,110,370, Treinador.BROCK, Status.BATALHANDO);

        for (Pokemon p : pokemonService.listarPokemons()) {
            if (p1.equals(p.getId())) {
                pokemon1 = p;
                pokemon1.setStatus(Status.BATALHANDO);
            } else {
                throw new RuntimeException("Erro - pokemon inexistente");
            }
            if (pokemon1.getVida() <= 0) {
                throw new RuntimeException("ERRO - POKEMON ESTÁ DESMAIADO E NÃO PODE ATACAR!");
            }
            if (pokemon2 == null) {
                throw new RuntimeException("ERRO - DEVE HAVER UM POKEMON PARA EXECUTAR O ATAQUE");
            }
            if (pokemon2.getVida() <= 0){
                throw new RuntimeException("ERRO - NÃO É POSSIVEL ATACAR UM POKEMON DESMAIADO");
            }

            danoCausado = pokemon1.getAtaque();
            pokemon2.setVida(pokemon2.getVida() - danoCausado);
            return pokemon1.getNome()+" causou "+danoCausado+" de dano em "+pokemon2.getNome()+" e agora restou "+pokemon2.getVida();
        }

        return null;
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
                    if (x > 50) {
                        return p.getNome() + " fugiu ......";
                    }else {
                        return p.getNome() + " não conseguiu fugir";
                    }
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

}
