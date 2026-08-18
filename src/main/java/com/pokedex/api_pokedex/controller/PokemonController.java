package com.pokedex.api_pokedex.controller;


import com.pokedex.api_pokedex.entity.Pokemon;
import com.pokedex.api_pokedex.enums.Evolucao;
import com.pokedex.api_pokedex.enums.Tipo;
import com.pokedex.api_pokedex.enums.Treinador;
import com.pokedex.api_pokedex.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Tag(
        name = "Pokedex",
        description = "Endpoints para cadastro, consulta, atualização e exclusão de pokemons"
)

/**
 * Controller responsável pelos endpoints relacionados aos pokemons
 *
 * <p>Esta classe disponibiliza operações HTTP para listar, consultar, cadastrar, atualizar e remover produtos</p>
 *
 * @author Guilherme e Luigi
 * @since 1.0*/

@RestController
@RequestMapping("/v1/pokemons")
public class PokemonController {

    PokemonService service = new PokemonService();

    public PokemonController(PokemonService service) {
        this.service = service;
    }
    /**
     * Lista de pokemons
     *
     * <p>Todos os pokemons que estão cadastrados
     * seram exibidos em uma lista </p>
     *
     * @return resposta HTTP contendo a lista de pokemons
     **/

    @Operation(
            summary = "Listar pokemons",
            description = "Retorna todos os pokemons cadastrados na lista"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Produtos encontrados"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Dados inválidos"
    )
    @GetMapping()
    public ArrayList<Pokemon> listarPokemons() {
        return service.listarPokemons();
    }

    /**
     * Buscar o pokemon que deseja pelo ID
     *
     * <p>Será exibido o pokemon que no qual o usuario solicitou
     * por um ID</p>
     *
     * @param id id utilizado para buscar o pokemon solicitado'
     * @return irá retornar o pokemon que foi solicitado
     **/
    @Operation(
            summary = "Buscar pokemon pelo ID",
            description = "Busca o pokemon pelo ID e o retorna para visualização"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Pokemon encontrado com sucesso"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Pokemon não encontrado"
    )
    @GetMapping("/{id}")
    public Pokemon buscarPokemonId(@PathVariable Long id) {
        return service.buscarPokemonId(id);
    }

    /**
     * Cadastrar um novo Pokemon
     *
     * <p>Será criado um novo pokemon , a partir de todos os dados informados
     * pelo usuario</p>
     *
     * @return irá retornar um novo pokemon para a lista
     **/
    @Operation(
            summary = "Cadastrar pokemon",
            description = "Cadastra o pokemon na pokedex"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao cadastrar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao cadastrar"
    )
    @PostMapping()
    public Pokemon cadastrarPokemon(@RequestBody Pokemon pokemon){
        return service.cadastrarPokemon(pokemon);
    }

    /**
     * Atualiza todos os dados do pokemon
     *
     * <p>O pokemon que o usuario solicitar , poderá ter todos os
     * seus dados alterados se for do seu agrado</p>
     *
     * @param id id utilizado para atualizar o pokemon solicitado'
     * @return irá retornar um pokemon atualizado para a lista
     **/
    @Operation(
            summary = "Atualiza o pokemon",
            description = "Atualiza os dados do pokemon"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao atualizar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao atualizar"
    )
    @PutMapping("/{id}")
    public Pokemon atualizarDados(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return service.atualizarDados(id,pokemon);
    }

    /**
     * Deleta um pokemon
     *
     * <p>O pokemon que o usuario selecionar , será ser deletado</p>
     *
     * @param id id utilizado para deletar o pokemon solicitado'
     * @return irá retornar um pokemon deletado
     **/
    @Operation(
            summary = "Deleta pokemon",
            description = "Deleta o pokemon da pokedex"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao deletar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao deletar"
    )
    @DeleteMapping("/{id}")
    public Pokemon deletarPokemon (@PathVariable Long id) {
        return service.deletarPokemon(id);
    }

    /**
     * Listar os pokemons por um tipo
     *
     * <p>Todos os pokemons que estão relacionados com o tipo selecionado
     * seram exibidos em uma lista</p>
     *
     * @param tipo tipo utilizado para buscar os pokemons que estão relacionados'
     * @return irá retornar os pokemons relacionados em uma lista
     **/
    @Operation(
            summary = "Lista pokemons por tipo",
            description = "Lista os pokemons pelo tipo determinado"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao listar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao listar"
    )
    @GetMapping("/tipo")
    public ArrayList<Pokemon> listarPokemonsTipo (@RequestParam String tipo) {
        return service.listarPokemonsTipo(tipo);
    }

    /**
     * Listar um pokemon por um nome
     *
     * <p>O pokemon que está relacionado com o nome selecionado
     * será exibido</p>
     *
     * @param nome nome utilizado para buscar o pokemon que está relacionado'
     * @return irá retornar um pokemon relacionado com o nome
     **/
    @Operation(
            summary = "Lista pokemons pelo nome",
            description = "Lista os pokemons pelo nome determinado"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao listar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao listar"
    )
    @GetMapping("/nome")
    public Pokemon listarPokemonsNome(@RequestParam String nome){
        return service.listarPokemonsNome(nome);
    }

    /**
     * Listar um pokemon por um nivel
     *
     * <p>Todos os pokemons que estão relacionados com o nivel selecionado
     * serão exibido em uma lista</p>
     *
     * @param nivel nivel utilizado para buscar o pokemon que está relacionado'
     * @return irá retornar um pokemon relacionado com o nivel
     **/
    @Operation(
            summary = "Lista pokemons por nivel",
            description = "Lista o pokemon apartir do nivel determinado"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao listar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao listar"
    )
    @GetMapping("/nivel")
    public ArrayList<Pokemon> listarPorNivel(@RequestParam int nivel){
        return service.listarPorNivel(nivel);
    }

    /**
     * Atualiza o nivel do pokemon
     *
     * <p>O pokemon que o usuario solicitar , poderá ter o seu nivel
     * alterado se for do seu agrado</p>
     *
     * @param id id utilizado para atualizar o pokemon solicitado'
     * @return irá retornar um pokemon atualizado para a lista
     **/
    @Operation(
            summary = "Atualiza o nivel do pokemon",
            description = "Este método altera o nivel do pokemon para o nivel determinado"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao atualizar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao atualizar"
    )
    @PatchMapping("{id}/nivel")
    public Pokemon atualizarONivel(@PathVariable Long id, @RequestBody Pokemon pokemon){
        return service.atualizarONivel(id, pokemon);
    }

    /**
     * Atualiza a vida do pokemon
     *
     * <p>O pokemon que o usuario solicitar , poderá ter o sua vida
     * aumentada se for do seu agrado</p>
     *
     * @param id id utilizado para atualizar o pokemon solicitado'
     * @return irá retornar um pokemon atualizado para a lista
     **/
    @Operation(
            summary = "Cura pokemons",
            description = "Cura os pokemons adicionando a vida solicitada"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso ao curar"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro ao curar"
    )
    @PostMapping("{id}/curar")
    public Pokemon curarPokemon (@PathVariable Long id, @RequestBody Pokemon pokemon){
        return service.curarPokemon(id, pokemon);
    }

    /**
     * Atualiza a evolução do pokemon
     *
     * <p>O pokemon que o usuario solicitar , poderá ter o sua evolução
     * alterada se for do seu agrado</p>
     *
     * @param id id utilizado para atualizar o pokemon solicitado'
     * @return irá retornar um pokemon atualizado para a lista
     **/
    @Operation(
            summary = "Evoluir pokemons",
            description = "Evolui o pokemon de acordo com a fase determinada"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Sucesso ao evoluir"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro ao evoluir"
            )
    })
    @PostMapping("{id}/evoluir")
    public Pokemon evouluirPokemon (@PathVariable Long id, @RequestBody Pokemon pokemon){
        return service.evouluirPokemon(id, pokemon);
    }

    /**
     * Pokemon mais forte
     *
     * <p>O pokemon que tiver o maior ataque de todos , será
     * exibido para o usuario</p>
     *
     * @return irá retornar o pokemon mais forte da lista
     **/
    @Operation(
            summary = "Pokemon mais forte",
            description = "Listar e ver qual é o pokemon mais forte"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Sucesso ao buscar pelo mais forte"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro ao buscar"
            )
    })
    @GetMapping("/mais-forte")
    public Pokemon pokemonMaisForte() {
        return service.pokemonMaisForte();
    }
}


