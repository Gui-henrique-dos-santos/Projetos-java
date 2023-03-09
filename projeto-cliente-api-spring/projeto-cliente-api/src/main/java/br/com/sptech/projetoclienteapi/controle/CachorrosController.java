package br.com.sptech.projetoclienteapi.controle;

import br.com.sptech.projetoclienteapi.integracao.ClienteCachorrosApi;
import br.com.sptech.projetoclienteapi.modelo.Cachorro;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dogs")
public class CachorrosController {

    @Autowired
    private ClienteCachorrosApi cachorrosApi;

    @GetMapping
    public ResponseEntity getDogs() {
        return ResponseEntity.status(200).body(cachorrosApi.get());
    }

    @GetMapping("/for-kids")
    public ResponseEntity getDogsParaCriancas() {
        List<Cachorro> cachorros = cachorrosApi.get();

        List<Cachorro> cachorrosParaCriancas =
                cachorros.stream()
                .filter(cachorro -> cachorro.getIndicadoCriancas())
                .collect(Collectors.toList());

        /* o código com stream acima substituiu este comentado aqui:
        List<Cachorro> cachorrosParaCriancas = new ArrayList<>();
        for (Cachorro cachorro : cachorros) {
            if (cachorro.getIndicadoCriancas()) {
                cachorrosParaCriancas.add(cachorro);
            }
        }*/

        if (cachorrosParaCriancas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(cachorrosParaCriancas);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDog(@PathVariable int id) {
        try {
            Cachorro cachorro = cachorrosApi.get(id);
            return ResponseEntity.status(200).body(cachorro);
        } catch (FeignException fe) {
            if (fe.status() == 404) { // .status() -> devolve o status HTTP da resposta da API
                return ResponseEntity.status(404).body("Cachorro de id "+id+" não existe");
            } else {
                return ResponseEntity.status(500).body(fe.getMessage());
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putCachorro(@PathVariable int id, @RequestBody Cachorro cachorro) {
        try {
            cachorrosApi.put(cachorro, id);
            return ResponseEntity.status(200).build();
        } catch (FeignException fe) {
            if (fe.status() == 404) {
                return ResponseEntity.status(404).body("Cachorro não encontrado");
            } else {
                return ResponseEntity.status(500).body(fe.getMessage());
            }
        }
    }

}
