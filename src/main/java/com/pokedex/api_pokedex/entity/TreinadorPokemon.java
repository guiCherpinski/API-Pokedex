package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.enums.Direcao;
import com.pokedex.api_pokedex.enums.Time;

import java.util.ArrayList;

public class TreinadorPokemon {

    private Long id;
    private String nome;
    private String regiao;
    private ArrayList<Pokemon> pokemons;
    private Time time;

    public TreinadorPokemon(Long id, String nome, String regiao, ArrayList<Pokemon> pokemons, Time time) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.pokemons = pokemons;
        this.time = time;
    }

    public TreinadorPokemon(String nome, String regiao, ArrayList<Pokemon> pokemons, Time time) {
        this.nome = nome;
        this.regiao = regiao;
        this.pokemons = pokemons;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public String movimentar(String nome , Direcao direcao) {
        return nome + " se moveu para " + direcao;
    }

    public String timeTreinador(String nomeTreinador , Time time){
        return "Agora "+ nomeTreinador + " pertence ao time " + time;
    }


}
