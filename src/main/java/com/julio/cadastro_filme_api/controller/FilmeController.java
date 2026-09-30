package com.julio.cadastro_filme_api.controller;

import com.julio.cadastro_filme_api.Service.FilmeService;
import com.julio.cadastro_filme_api.model.Filme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
        Filme response = service.criar(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> consultar() {
        List<Filme> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> consultarId(@PathVariable Long id) {
        Filme filme = service.buscarPorId(id);
        return ResponseEntity.ok(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(
            @PathVariable Long id,
            @RequestBody Filme filme
    ) {
        Filme response = service.atualizar(id, filme);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}