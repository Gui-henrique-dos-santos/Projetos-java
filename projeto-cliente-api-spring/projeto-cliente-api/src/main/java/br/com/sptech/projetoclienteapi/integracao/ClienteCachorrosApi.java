package br.com.sptech.projetoclienteapi.integracao;

import br.com.sptech.projetoclienteapi.modelo.Cachorro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* A @FeignClient indica que a interface possui a programação de acesso a 1 ou mais EndPoints da API
 Atributo 'name': Indica o nome interno (nome para o projeto aqui, em Spring Boot). OBRIGATÓRIO.
 Atributo 'url': É a URL base da API que será consumida
 */
@FeignClient(name = "cachorrosApi", url = "https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/")
public interface ClienteCachorrosApi {

    // cada método aqui é um EndPoint mapeado na API (API de cachorros, no caso)
    // criamos os métodos quase 100% como faríamos em nossas Controllers
    // a diferença é que não usamos o ResponseEntity como resposta e sim o tipo direto que queremos
    @GetMapping("/cachorros")
    List<Cachorro> get();

    @GetMapping("/cachorros/{id}")
    Cachorro get(@PathVariable int id);

    @DeleteMapping("/cachorros/{id}")
    void delete(@PathVariable int id);
    /* podemos definir um método de chamada a EndPoint como void quando:
        - Caso o EndPoint não devolve nada no corpo da resposta
        - Caso o EndPoint devolva algo no corpo da resposta porém esse corpo não nos interessa
     */

    @PostMapping("/cachorros")
    void post(@RequestBody Cachorro novoCachorro);

    @PutMapping("/cachorros/{id}")
    void put(@RequestBody Cachorro novoCachorro, @PathVariable int id);

}
