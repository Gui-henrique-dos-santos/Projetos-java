package sptech.atividadeguilhermehenrique.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Carro {
    @Id  // do javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarro;
    @NotBlank(message = "Precisamos do modelo do carro")
    @Size(min = 2, max = 12)
    private String modelo;
    @NotBlank(message = "Necessario o fabricante do carro")
    @Size(min = 2, max = 10)
    private String fabricante;
    @PastOrPresent
    private LocalDate dataFabricacao;
    @NotNull(message = "Forneça o ano do carro")
    @Min(1960)
    @Max(2021)
    private Integer anoFabricacao;
    @NotNull(message = "Insira a potencia do seu carro")
    @DecimalMin("0.2")
    @DecimalMax("7.0")
    private Double potenciaMotor;

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(Double potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }
}
