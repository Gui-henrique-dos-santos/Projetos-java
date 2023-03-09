package sptech.atividadeguilhermehenrique.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.atividadeguilhermehenrique.dominio.Carro;
import sptech.atividadeguilhermehenrique.repositorio.CarroRepository;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroRepository repository;
    @PostMapping
    public ResponseEntity<Carro> post(
            @RequestBody Carro novoCarro) {
        repository.save(novoCarro); // faz um insert ou update, dependendo de a chave primária existe ou não no banco
        return ResponseEntity.status(201).body(novoCarro);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> get() {
        List<Carro> lista = repository.findAll(); // faz um "select * from" da tabela
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> get(
            @PathVariable int id) {
/*
Se o findById() encontrar valor, ele será usado no corpo da resposta e o status da resposta será 200
Caso contrário, o status da resposta será 404 e não haverá corpo na resposta
 */
        return ResponseEntity.of(repository.findById(id));
    }


}

