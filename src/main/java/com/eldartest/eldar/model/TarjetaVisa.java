package com.eldartest.eldar.model;

import com.eldartest.eldar.exceptions.InvalidAmountException;

import java.util.Calendar;
import java.util.Date;

public class TarjetaVisa extends Tarjeta{

    public TarjetaVisa() {
    }
    @Override
    public double operacion(int mount) throws InvalidAmountException {
        if (operacionValida(mount)) {
            Date hoy = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(hoy);
            return ((double) (mount * (calendar.get(Calendar.YEAR) % 100)) / (calendar.get(Calendar.MONTH) + 1));
        }else {
            throw new InvalidAmountException("Operación no válida con el monto ingresado.");
        }
    }
}
