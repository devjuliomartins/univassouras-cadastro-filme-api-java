package com.julio.cadastro_filme_api.Service;

import com.julio.cadastro_filme_api.model.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FilmeService {

    private final List<Filme> banco = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    public Filme criar(Filme filme) {
        filme.setId(sequence.getAndIncrement());
        banco.add(filme);

        return filme;
    }

    public List<Filme> listar() {
        return banco;
    }

    public Filme buscarPorId(Long id) {

        Optional<Filme> optFilme = banco.stream()
                .filter(filme -> filme.getId().equals(id))
                .findFirst();

        if (optFilme.isEmpty()) {
            throw new RuntimeException("Filme não encontrado");
        }

        return optFilme.get();
    }

    public Filme atualizar(Long id, Filme filmeAtualizado) {

        Filme filme = buscarPorId(id);

        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());

        return filme;
    }

    public void excluir(Long id) {

        boolean removido = banco.removeIf(
                filme -> filme.getId().equals(id)
        );

        if (!removido) {
            throw new RuntimeException("Filme não encontrado");
        }
    }
}