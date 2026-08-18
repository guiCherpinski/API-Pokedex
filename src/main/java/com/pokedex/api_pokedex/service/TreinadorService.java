package com.pokedex.api_pokedex.service;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.entity.TreinadorPokemon;
import com.pokedex.api_pokedex.enums.Direcao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TreinadorService {

    private ArrayList<TreinadorPokemon> treinadores = new ArrayList<>();
    static Long proximoId = 1L;

    public TreinadorService() {
        treinadores.add(new TreinadorPokemon(proximoId++,"ASH","Pallet",null,null,"Fire"));
        treinadores.add(new TreinadorPokemon(proximoId++,"BROCK","Kanto",null,null,"Blue"));
        treinadores.add(new TreinadorPokemon(proximoId++,"SERENA","Hoenn",null,null,"Yellow"));
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
}
