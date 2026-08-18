package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.enums.Evolucao;
import com.pokedex.api_pokedex.enums.Status;
import com.pokedex.api_pokedex.enums.Tipo;
import com.pokedex.api_pokedex.enums.Treinador;

import java.util.ArrayList;

public class Pokemon {
    private Long id;
    private String nome;
    private String apelido;
    private Tipo tipo1;
    private Tipo tipo2;
    private int vida;
    private int nivel;
    private Evolucao evolucao;
    private int defesa;
    private int ataque;
    private int velocidade;
    private Treinador treinador;
    private Status status;

    public Pokemon () {

    }

    public Pokemon(Long id, String nome, String apelido, Tipo tipo1, Tipo tipo2 , int vida, int nivel, Evolucao evolucao,
                   int defesa, int ataque, int velocidade, Treinador treinador, Status status) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.vida = vida;
        this.nivel = nivel;
        this.evolucao = evolucao;
        this.defesa = defesa;
        this.ataque = ataque;
        this.velocidade = velocidade;
        this.treinador = treinador;
        this.status = status;
    }

    public Pokemon(String nome, String apelido,Tipo tipo1,Tipo tipo2, int vida, int nivel, Evolucao evolucao,
                   int defesa, int ataque, int velocidade, Treinador treinador, Status status) {
        this.nome = nome;
        this.apelido = apelido;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.vida = vida;
        this.nivel = nivel;
        this.evolucao = evolucao;
        this.defesa = defesa;
        this.ataque = ataque;
        this.velocidade = velocidade;
        this.treinador = treinador;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
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

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public int atacar() {
        return ataque;
    }

    public String fugir(int chance) {
        if (chance > 50) {
            return "Fuga concluida com sucesso!";
        } else {
            return "O pokemon não conseguiu escapar da batalha";
        }
    }

    public String esquivar(int chance) {
        if (chance > 50) {
            return "Esquiva concluida com sucesso!";
        } else {
            return "O pokemon não conseguiu esquivar";
        }
    }

    public String desmaiar(String nomeBateu, String nomeDesmaiou){

        return nomeBateu + " desmaiou o " + nomeDesmaiou + " com seu ataque";
    }
}