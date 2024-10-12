package com.eldartest.eldar.service;
import com.eldartest.eldar.exceptions.InvalidAmountException;
import com.eldartest.eldar.model.Tarjeta;
import com.eldartest.eldar.model.TarjetaAmex;
import com.eldartest.eldar.model.TarjetaNara;
import com.eldartest.eldar.model.TarjetaVisa;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TarjetaService {

    private final Map<String, Tarjeta> tarjetasEnMemoria;

    public TarjetaService() {
        tarjetasEnMemoria = new HashMap<>();
        tarjetasEnMemoria.put("VISA", new TarjetaVisa());
        tarjetasEnMemoria.put("NARA", new TarjetaNara());
        tarjetasEnMemoria.put("AMEX", new TarjetaAmex());
    }
    public double calcularTasa(String marca, int importe) throws InvalidAmountException {
        Tarjeta tarjeta = tarjetasEnMemoria.get(marca.toUpperCase());
        if (tarjeta == null) {
            throw new IllegalArgumentException("Marca de tarjeta no reconocida");
        }
        return tarjeta.operacion(importe);
    }
}
