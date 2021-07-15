package com.jona.pizzaspatagonia.clases;

import java.io.Serializable;

public class Pizza implements Serializable {
    private int idPizza, valorPizza;
    private String nombrePizza, ingredientesPizza;

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getValorPizza() {
        return valorPizza;
    }

    public void setValorPizza(int valorPizza) {
        this.valorPizza = valorPizza;
    }

    public String getNombrePizza() {
        return nombrePizza;
    }

    public void setNombrePizza(String nombrePizza) {
        this.nombrePizza = nombrePizza;
    }

    public String getIngredientesPizza() {
        return ingredientesPizza;
    }

    public void setIngredientesPizza(String ingredientesPizza) {
        this.ingredientesPizza = ingredientesPizza;
    }
}
