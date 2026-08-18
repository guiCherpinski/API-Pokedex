package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.enums.Tipo;

import java.util.ArrayList;

public class Arena {
    private int id;
    private String nome;
    private Tipo tipoArena;
    private TreinadorPokemon lider;
    private TreinadorPokemon treinador;
    private ArrayList<Pokemon> pokemons;

    public Arena(int id, String nome, Tipo tipoArena, TreinadorPokemon lider, TreinadorPokemon treinador, ArrayList<Pokemon> pokemons) {
        this.id = id;
        this.nome = nome;
        this.tipoArena = tipoArena;
        this.lider = lider;
        this.treinador = treinador;
        this.pokemons = pokemons;
    }

    public Arena(String nome, Tipo tipoArena, TreinadorPokemon lider, TreinadorPokemon treinador, ArrayList<Pokemon> pokemons) {
        this.nome = nome;
        this.tipoArena = tipoArena;
        this.lider = lider;
        this.treinador = treinador;
        this.pokemons = pokemons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipoArena;
    }

    public void setTipo(Tipo tipoArena) {
        this.tipoArena = tipoArena;
    }

    public TreinadorPokemon getLider() {
        return lider;
    }

    public void setLider(TreinadorPokemon lider) {
        this.lider = lider;
    }

    public TreinadorPokemon getTreinador() {
        return treinador;
    }

    public void setTreinador(TreinadorPokemon treinador) {
        this.treinador = treinador;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
