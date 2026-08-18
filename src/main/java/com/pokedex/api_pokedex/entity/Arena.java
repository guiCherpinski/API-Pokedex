package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.enums.Tipo;
import com.pokedex.api_pokedex.enums.Treinador;

import java.util.ArrayList;

public class Arena {
    private int id;
    private String nome;
    private Tipo tipoArena;
    private Treinador lider;
    private Treinador treinador;
    private ArrayList<Pokemon> pokemons;

    public Arena(int id, String nome, Tipo tipoArena, Treinador lider, Treinador treinador, ArrayList<Pokemon> pokemons) {
        this.id = id;
        this.nome = nome;
        this.tipoArena = tipoArena;
        this.lider = lider;
        this.treinador = treinador;
        this.pokemons = pokemons;
    }

    public Arena(String nome, Tipo tipoArena, Treinador lider, Treinador treinador, ArrayList<Pokemon> pokemons) {
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

    public Treinador getLider() {
        return lider;
    }

    public void setLider(Treinador lider) {
        this.lider = lider;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
