package com.pokedex.api_pokedex.entity;

import com.pokedex.api_pokedex.enums.*;
import jakarta.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String apelido;

    @Enumerated(EnumType.STRING)
    private Tipo tipo1;

    @Enumerated(EnumType.STRING)
    private Tipo tipo2;

    private int vida;
    private int nivel;

    @Enumerated(EnumType.STRING)
    private Evolucao evolucao;

    private int defesa;
    private int ataque;
    private int velocidade;

    @ManyToOne
    @JoinColumn(name = "treinador_id")
    private TreinadorPokemon treinador;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Pokemon () {

    }

    public Pokemon(Long id, String nome, String apelido, Tipo tipo1, Tipo tipo2 , int vida, int nivel, Evolucao evolucao,
                   int defesa, int ataque, int velocidade, TreinadorPokemon treinador, Status status) {
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

    public Pokemon(String nome, String apelido, Tipo tipo1, Tipo tipo2, int vida, int nivel, Evolucao evolucao,
                   int defesa, int ataque, int velocidade, TreinadorPokemon treinador, Status status) {
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

    public TreinadorPokemon getTreinador() {
        return treinador;
    }

    public void setTreinador(TreinadorPokemon treinador) {
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

    public String usarItem(String nomePocao,String nomePokemon, int vida){

        return nomePocao + " foi usada no pokemon " + nomePokemon + " adicionado " + vida + " de vida";
    }

    public String evoluir(String nomePokemon, Evolucao evolucao, String evo) {
        return nomePokemon + " evoluiu para sua " + evolucao + " e virou " + evo;
    }

    public String subirNivel (String nome, int level) {
        return nome + " subiu para o LV " + level;
    }

    public String movimentar(String nome , Direcao direcao){
        return "O pokemon " + nome + " se movimentou para " + direcao;
    }
}