package com.pokedex.api_pokedex.enums;

public enum Loja {
    OVO_DA_SORTE(20),
    INCUBADORAS(30),
    POKEBOLAS(40),
    POÇÃO(50),
    BOLSA(70);

    private final int preco;

    Loja(int preco) {
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }
}
