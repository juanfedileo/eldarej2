package com.eldartest.eldar.model;

import com.eldartest.eldar.exceptions.InvalidAmountException;

import java.util.Calendar;
import java.util.Date;

public class TarjetaNara extends Tarjeta{

    public TarjetaNara() {
    }
    @Override
    public double operacion(int mount) throws InvalidAmountException {
        if (operacionValida(mount)){
            Date hoy = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(hoy);
            return mount*calendar.get(Calendar.DAY_OF_MONTH)*0.5;
        }else{
            throw new InvalidAmountException("Operación no válida con el monto ingresado.");
        }
    }
}
