package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.enums.Direcao;
import com.pokedex.api_pokedex.enums.Loja;
import com.pokedex.api_pokedex.enums.Time;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TreinadorPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String regiao;

    @OneToMany(mappedBy = "treinador")
    private List<Pokemon> pokemons;

    @Enumerated(EnumType.STRING)
    private Time time;

    private int moedas;

    @Enumerated(EnumType.STRING)
    private Loja loja;

    public TreinadorPokemon() {
    }

    public TreinadorPokemon(Long id, String nome, String regiao, List<Pokemon> pokemons, Time time, int moedas, Loja loja) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.pokemons = pokemons;
        this.time = time;
        this.moedas = moedas;
        this.loja = loja;
    }

    public TreinadorPokemon(String nome, String regiao, List<Pokemon> pokemons, Time time, int moedas, Loja loja) {
        this.nome = nome;
        this.regiao = regiao;
        this.pokemons = pokemons;
        this.time = time;
        this.moedas = moedas;
        this.loja = loja;
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

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String movimentar(String nome, Direcao direcao) {
        return nome + " se moveu para " + direcao;
    }

    public String timeTreinador(String nomeTreinador, Time time) {
        return "Agora " + nomeTreinador + " pertence ao time " + time;
    }

    public String capturarPokemon(String nomePokemon, int chance) {
        if (chance > 50) {
            return nomePokemon + " foi capturado com sucesso!";
        } else {
            return nomePokemon + " escapou da pokebola";
        }
    }
}