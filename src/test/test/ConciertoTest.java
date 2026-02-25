package test.test;
import classes.Concierto;
import classes.Entrada;
import exceptions.CeroEntradasException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class ConciertoTest {

    @Test
    void calcularPrecioMedio() throws CeroEntradasException {

        Concierto concierto = new Concierto("Guns and Roses", "Miami", 110.0, 40000, new ArrayList<>(), true);
        Entrada e1 = new Entrada(concierto, Entrada.Tipo.PISTA);
        Entrada e2 = new Entrada(concierto, Entrada.Tipo.GRADA);

        concierto.getEntradasVendidas().add(e1);
        concierto.getEntradasVendidas().add(e2);


        Assertions.assertEquals(115.5, concierto.calcularPrecioMedio());


        Concierto conciertoVacio = new Concierto("Bad bunny", "Oslo", 24.0, 560000, new ArrayList<>(), true);
        assertThrows(CeroEntradasException.class, () -> conciertoVacio.calcularPrecioMedio());
    }
}