package com.pokedex.api_pokedex.controller;

import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.service.ArenaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pokedex")
public class ArenaController {

    ArenaService arenaService = new ArenaService();

    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @GetMapping("/atacar-pokemon/{id}")
    public String atacarPokemon(@PathVariable Long id){
        return arenaService.atacar(id);
    }

    @GetMapping("/fugir/{id}")
    public String fugir(@PathVariable Long id) {
        return arenaService.fugir(id);
    }

    @GetMapping("/esquivar/{id}")
    public String esquivar(@PathVariable Long id) {
        return arenaService.esquivar(id);
    }

    @PatchMapping("/usar-item/{id}")
    public int usarItem(@RequestBody Pokemon pokemon , @PathVariable Long id) {
        return arenaService.usarItem(pokemon,id);
    }
}
