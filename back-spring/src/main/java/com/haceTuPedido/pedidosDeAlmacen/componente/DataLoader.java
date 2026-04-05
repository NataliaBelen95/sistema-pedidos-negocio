package com.haceTuPedido.pedidosDeAlmacen.componente;

import com.haceTuPedido.pedidosDeAlmacen.enums.EnumCategoria;
import com.haceTuPedido.pedidosDeAlmacen.model.Categoria;
import com.haceTuPedido.pedidosDeAlmacen.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    public DataLoader(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        if (categoriaRepository.count() == 0) {
            for (EnumCategoria cat : EnumCategoria.values()) {
                categoriaRepository.save(new Categoria(null, cat));
            }
        }
    }
}
