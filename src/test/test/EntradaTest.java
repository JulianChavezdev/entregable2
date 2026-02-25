package test.test;
import classes.Concierto;
import classes.Entrada;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class EntradaTest {

    @Test
    void getPrecioTotal() {
        Concierto concierto = new Concierto("Maluma", "Lima", 60.0, 1, new ArrayList<>(), true);

        Entrada entradaGrada = new Entrada(concierto, Entrada.Tipo.GRADA);
        assertEquals(60.0, entradaGrada.getPrecioTotal());

        Entrada entradaVip = new Entrada(concierto, Entrada.Tipo.VIP);
        assertEquals(72.0, entradaVip.getPrecioTotal());

    }
}