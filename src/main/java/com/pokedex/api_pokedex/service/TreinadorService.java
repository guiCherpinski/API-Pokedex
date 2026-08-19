package com.pokedex.api_pokedex.service;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.entity.TreinadorPokemon;
import com.pokedex.api_pokedex.enums.Direcao;
import com.pokedex.api_pokedex.enums.Loja;
import com.pokedex.api_pokedex.enums.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class TreinadorService {

    private ArrayList<TreinadorPokemon> treinadores = new ArrayList<>();
    private PokemonService pokemonService = new PokemonService();


    private ArrayList<Pokemon> pokemoins = new ArrayList<>();


    private Random gerador = new Random();
    static Long proximoId = 1L;

    public TreinadorService() {
        treinadores.add(new TreinadorPokemon(proximoId++,"ASH","Pallet",null, Time.RED,50,null));
        treinadores.add(new TreinadorPokemon(proximoId++,"BROCK","Kanto",null,Time.BLUE,100,null));
        treinadores.add(new TreinadorPokemon(proximoId++,"SERENA","Hoenn",null,null,200,null));
    }

    public ArrayList<TreinadorPokemon> listarTreinadores() {
        return treinadores;
    }

    public String movimentar(Long id, Direcao direcao) {

        try {
            for (TreinadorPokemon p : listarTreinadores()){
                if (id.equals(p.getId())){

                    switch (direcao) {
                        case ESQUERDA -> {
                            return p.movimentar(p.getNome(),direcao);
                        }
                        case DIREITA -> {
                            return p.movimentar(p.getNome(),direcao);
                        }
                        case BAIXO -> {
                            return p.movimentar(p.getNome(),direcao);
                        }
                        case FRENTE -> {
                            return p.movimentar(p.getNome(),direcao);
                        }
                        case null -> {
                            return "DIREÇÃO NÃO ENCONTRADA";
                        }
                    }
                }
            }
        } catch (RuntimeException e){
            return e.getMessage();
        }

        return null;
    }

    public String time(Long id, Time time){

        try {

            for (TreinadorPokemon t : treinadores){
                if (id.equals(t.getId())){

                    if(t.getTime() != null){
                        throw new RuntimeException("ERRO - O treinador já possui um time");
                    }

                    if (t.getTime() == null){
                        switch (time){
                            case RED -> {
                                t.setTime(Time.RED);
                                return t.timeTreinador(t.getNome(),t.getTime());
                            }
                            case YELLOOW -> {
                                t.setTime(Time.YELLOOW);
                                return t.timeTreinador(t.getNome(),t.getTime());
                            }
                            case BLUE -> {
                                t.setTime(Time.BLUE);
                                return t.timeTreinador(t.getNome(),t.getTime());
                            }
                        }
                    }
                }
            }

        } catch (RuntimeException e){
            return e.getMessage();
        }
        return null;
    }
    public String capturarPokemon (Pokemon pokemon) {

        try {

            int x = gerador.nextInt(100);

            for (TreinadorPokemon t : treinadores) {
                if (x > 50) {
                    pokemoins.add(pokemon);
                    t.setPokemons(pokemoins);
                    pokemonService.cadastrarPokemon(pokemon);
                    return t.capturarPokemon(pokemon.getNome(),x);
                } else {
                    throw new RuntimeException(t.capturarPokemon(pokemon.getNome(), x));
                }
            }

        } catch (RuntimeException e) {
            return e.getMessage();
        }

        return null;
    }

    public String comprarItem(Long id , Loja loja){

        try{
            for (TreinadorPokemon t : treinadores){
                if (id.equals(t.getId())){

                    if (t.getMoedas() < loja.getPreco()){
                        throw new RuntimeException("ERRO - O treinador não tem moedas suficientes para comprar");
                    }

                }
            }



        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
