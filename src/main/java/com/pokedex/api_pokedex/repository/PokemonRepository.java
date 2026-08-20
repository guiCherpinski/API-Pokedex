package com.pokedex.api_pokedex.repository;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query("SELECT p FROM Pokemon p WHERE p.tipo1 = :tipo")
    List<Pokemon> findByTipo(@Param("tipo")Tipo tipo);

    List<Pokemon> findByNome(String nome);

    @Query("SELECT n FROM Pokemon n WHERE n.nivel = :nivel")
    List<Pokemon> findByNivel(@Param("nivel")int nivel);



}
