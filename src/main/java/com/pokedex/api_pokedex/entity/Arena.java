package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.enums.Tipo;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Arena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Tipo tipoArena;

    @OneToOne
    @JoinColumn(name = "treinador_lider_id")
    private TreinadorPokemon lider;

    @ManyToOne
    @JoinColumn(name = "treinador_id")
    private TreinadorPokemon treinador;

    @OneToMany
    @JoinColumn(name = "arena_id")
    private List<Pokemon> pokemons;

    public Arena() {
    }

    public Arena(int id, String nome, Tipo tipoArena, TreinadorPokemon lider, TreinadorPokemon treinador, List<Pokemon> pokemons) {
        this.id = id;
        this.nome = nome;
        this.tipoArena = tipoArena;
        this.lider = lider;
        this.treinador = treinador;
        this.pokemons = pokemons;
    }

    public Arena(String nome, Tipo tipoArena, TreinadorPokemon lider, TreinadorPokemon treinador, List<Pokemon> pokemons) {
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

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}