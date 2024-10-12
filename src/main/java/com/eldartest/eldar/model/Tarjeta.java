package com.eldartest.eldar.model;

import com.eldartest.eldar.exceptions.InvalidAmountException;
import lombok.Data;

import java.util.Date;

@Data
public abstract class Tarjeta {
    private int number;
    private String name;
    private String lastname;
    private Date duedate;

    public Tarjeta() {
    }
    public boolean esValida() {
        Date hoy = new Date();
        return duedate.after(hoy);
    }

    public boolean operacionValida(int mount){
        return mount <= 1000 && mount>0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj== null || getClass() != obj.getClass()){
            return false;
        }
        Tarjeta tarjeta = (Tarjeta) obj;
        return number == tarjeta.number;
    }

    public abstract double operacion(int monto) throws InvalidAmountException;

    @Override
    public String toString() {
        return "org.example.Tarjeta{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", duedate=" + duedate +
                '}';
    }
}
