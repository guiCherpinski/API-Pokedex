package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.Evolucao;

public class Pokemon {
    private Long id;
    private String nome;
    private String tipo;
    private int vida;
    private int nivel;
    private Evolucao evolucao;
    private int ataque;

    public Pokemon() {

    }

    public Pokemon(Long id, String nome, String tipo, int vida, int nivel, Evolucao evolucao, int ataque) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.nivel = nivel;
        this.evolucao = evolucao;
        this.ataque = ataque;
    }

    public Pokemon(String nome, String tipo, int vida, int nivel, Evolucao evolucao, int ataque) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.nivel = nivel;
        this.evolucao = evolucao;
        this.ataque = ataque;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Evolucao getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Evolucao evolucao) {
        this.evolucao = evolucao;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
