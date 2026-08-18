package com.pokedex.api_pokedex.controller;

import com.pokedex.api_pokedex.enums.Direcao;
import com.pokedex.api_pokedex.service.ArenaService;
import com.pokedex.api_pokedex.service.TreinadorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinador")
public class TreinadorController {

    TreinadorService treinadorService = new TreinadorService();

    public TreinadorController(TreinadorService treinadorService) {
        this.treinadorService = treinadorService;
    }

    @PutMapping("/movimentar/{id}")
    public String movimentarTreinador(@PathVariable Long id, @RequestBody Direcao direcao){
        return treinadorService.movimentar(id,direcao);
    }
}
