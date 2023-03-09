package br.com.sptech.projetoclienteapi.modelo;

public class Cachorro {

    private Integer id;
    private String raca;
    private Double precoMedio;
    private Boolean indicadoCriancas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Double getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(Double precoMedio) {
        this.precoMedio = precoMedio;
    }

    public Boolean getIndicadoCriancas() {
        return indicadoCriancas;
    }

    public void setIndicadoCriancas(Boolean indicadoCriancas) {
        this.indicadoCriancas = indicadoCriancas;
    }
}
