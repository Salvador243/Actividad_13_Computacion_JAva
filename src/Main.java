import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

interface AnonClass {
    public void anonMethod();
}

interface MathOperation {
    ArrayList<String> make(ArrayList<String> a);
}

class Arithmetica {
    static ArrayList<String> longitud(ArrayList<String> lst) {
        Collections.sort(lst, (a, b)->Integer.compare(a.length(), b.length()));
        return lst;
    }

    static ArrayList<String> letras(ArrayList<String> lst) {
        Collections.sort(lst, (a, b)->a.compareToIgnoreCase(b));
        return lst;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Cadena no 1");
        lista.add("Poo el guerrero dragon");
        lista.add("Kakashi peleo con meliodas");
        lista.add("Podio para checo perez");
        lista.add("Pole position para max");
        lista.add("Safety car en esta vuelta");
        lista.add("Lluvia de estrellas");
        lista.add("Instalando en el servidor ");
        lista.add("Que comiencen los juegos del hambre");
        lista.add("Iniciar ordenamiento");

        //clase anonima
        AnonClass anonima = new AnonClass() {
            public void anonMethod() {
                System.out.println("Ordenado por longitud clase anonima\n");
                Collections.sort(lista, Comparator.comparing(String::length));
                lista.forEach(System.out::println);

                System.out.println("\nOrdenado por Alfabetico clase anonima\n");
                lista.sort(String::compareToIgnoreCase);
                lista.forEach(System.out::println);
            }
        };

        anonima.anonMethod();

        //expresiones lambda
        System.out.println("\nOrdenado por longitud empresiones lambda \n");
        Collections.sort(lista, (a, b)->Integer.compare(a.length(), b.length()));

        lista.forEach(System.out::println);

        System.out.println("\nOrdenado por orden alfabetico empresiones lambda \n");
        lista.sort((p1, p2) -> p1.compareToIgnoreCase(p2));
        lista.forEach(System.out::println);


        //por longitud del metodo de referencia
        MathOperation lon = Arithmetica::longitud;
        System.out.println("Referencia Orden Longitud " + lon.make(lista));

        MathOperation alf = Arithmetica::letras;
        System.out.println("Referencia Orden Alfabetico " + alf.make(lista));


    }
}