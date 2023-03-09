package sptech.atividadeguilhermehenrique.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.atividadeguilhermehenrique.dominio.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
