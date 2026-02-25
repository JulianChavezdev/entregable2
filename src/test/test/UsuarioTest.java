package test.test;
import classes.Concierto;
import classes.Entrada;
import classes.Usuario;
import exceptions.ConciertoNoAsistidoException;
import exceptions.ValoracionIncorrecta;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void valorar() throws Exception {
        Concierto concierto = new Concierto("Michael Jackson","Medellin", 90, 440000, new ArrayList<>(), true);
        Usuario usuario = new Usuario();

        usuario.comprarEntrada(concierto, Entrada.Tipo.GRADA);
        usuario.valorar(concierto, 8);
        assertEquals(8, usuario.getValoraciones().get(concierto));

        Usuario usuario2 = new Usuario();
        assertThrows(ConciertoNoAsistidoException.class, () -> usuario2.valorar(concierto,8));

    }
}