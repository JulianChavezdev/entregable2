import classes.Concierto;
import classes.Entrada;
import classes.Usuario;
import exceptions.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concierto concierto1 = new Concierto("Guns and Roses", "Miami", 110, 40000, new ArrayList<>(), true);
        Concierto concierto2 = new Concierto("Michael Jackson", "Medellin", 90, 440000, new ArrayList<>(), false);
        Concierto concierto3 = new Concierto("Bad Bunny", "Oslo", 24, 560000,  new ArrayList<>(), true);
        Concierto concierto4 = new Concierto("Maluma", "lima", 60.0, 1, new ArrayList<>(), true);


        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Manuel");
        usuario1.setEdad(25);
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Alberto");
        usuario2.setEdad(19);
        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Natalia");
        usuario3.setEdad(50);


        System.out.println("CeroEntradasException");
        try {
            concierto2.calcularPrecioMedio();
        } catch (CeroEntradasException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("ConciertoInactivoException");
        try {
            usuario1.comprarEntrada(concierto2, Entrada.Tipo.VIP);
        } catch(ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e) {
            System.out.println(e.getMessage());
        }

        try {
            usuario2.comprarEntrada(concierto2, Entrada.Tipo.GRADA);
        } catch(ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e){
            System.out.println(e.getMessage());
        }


        System.out.println("ConciertoYaAsistidoException");

        try {
            usuario1.comprarEntrada(concierto1, Entrada.Tipo.GRADA);
        } catch(ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e){
            System.out.println(e.getMessage());
        }

        try {
            usuario2.comprarEntrada(concierto1, Entrada.Tipo.VIP);
        } catch(ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e){
            System.out.println(e.getMessage());
        }

        try{
            usuario3.comprarEntrada(concierto1, Entrada.Tipo.PISTA);
        } catch(ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e){
            System.out.println(e.getMessage());
        }

        try{
            usuario3.comprarEntrada(concierto3, Entrada.Tipo.VIP);
        } catch(ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e){
            System.out.println(e.getMessage());
        }


        try {
            usuario1.comprarEntrada(concierto1, Entrada.Tipo.PISTA);
        } catch(ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("AforoCompletoException");
        try {
            usuario1.comprarEntrada(concierto4, Entrada.Tipo.PISTA);
            usuario2.comprarEntrada(concierto4, Entrada.Tipo.PISTA);
        } catch (ConciertoInactivoException | ConciertoYaAsistidoException | AforoCompletoException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("ConciertoNoAsistidoException");

        try {
            usuario1.valorar(concierto3, 8);
        } catch (ConciertoNoAsistidoException e) {
            System.out.println(e.getMessage());
        } catch (ValoracionIncorrecta e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Valoración incorrecta");
        try {
            usuario3.valorar(concierto1, 15);
        } catch (ConciertoNoAsistidoException e) {
            System.out.println(e.getMessage());
        } catch (ValoracionIncorrecta e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Información entradas");

        int totalEntradas = 0;
        int totalPista = 0;
        int totalGrada = 0;
        int totalVip = 0;
        double recaudacionTotal = 0;
        Concierto menor = concierto1;
        Concierto mayor = concierto1;
        ArrayList<Concierto> cs = new ArrayList<>();
        cs.add(concierto1);
        cs.add(concierto2);
        cs.add(concierto3);
        for (Concierto concierto : cs) {
            totalEntradas += concierto.getEntradasVendidas().size();
            for (Entrada e :  concierto.getEntradasVendidas()) {
                if (e.getTipo() == Entrada.Tipo.PISTA) {
                    totalPista++;
                } else if (e.getTipo() == Entrada.Tipo.GRADA) {
                    totalGrada++;
                } else {
                    totalVip++;
                }
            }
            recaudacionTotal += concierto.calcularRecaudacion();
            if (concierto.getEntradasVendidas().size() > mayor.getEntradasVendidas().size()) {
                mayor = concierto;
            }
            if (concierto.getEntradasVendidas().size() < menor.getEntradasVendidas().size()) {
                menor = concierto;
            }
        }
        System.out.println("Total entradas: " + totalEntradas);

        System.out.println("Recaudación total: " + recaudacionTotal);

        System.out.println("Pista total: " + totalPista);

        System.out.println("Grada total: " + totalGrada);

        System.out.println("VIP total: " + totalVip);

        System.out.println("Precio medio: " + (recaudacionTotal / totalEntradas));

        System.out.println("Concierto con más entradas: " + mayor + " (" + mayor.getEntradasVendidas().size() + ")");

        System.out.println("Concierto con menos entradas: " + menor + " (" + menor.getEntradasVendidas().size() + ")");
    }
}
