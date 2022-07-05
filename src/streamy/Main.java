package streamy;

import java.security.PublicKey;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        // z kolekcji
        List<Integer> lista = new ArrayList<>(Arrays.asList(4, 1, 5, 3, 8, 3));
        lista.stream().forEach(i -> System.out.print(i + " "));

        // z tablicy
        int[] tablica = {1, 2, 3, 4, 5};
        Integer[] tablica1 = {4, 2, 5, 6, 8};

        IntStream intStream = Arrays.stream(tablica);
        Stream<Integer> stream = Arrays.stream(tablica1);

        // z typow prostych
        DoubleStream doubleStream = DoubleStream.of(4.5, 2.3, 1.1);
        IntStream ints = IntStream.range(4, 10);

        System.out.println();
        IntStream randoms = new Random().ints(5, 1, 11);

        // filter
        List<Integer> listaIntow = new ArrayList<>(Arrays.asList(4, 1, 5, 3, 8, 3));
        listaIntow.stream().filter(a -> a % 2 == 0).forEach(i -> System.out.print(i + " "));


        //map (dziala jak mapper dowolny typ, zwraca dowolny typ)

        // wyflitruj wyrazy dluzsze niz 5 a potem zwroc ich dlugosci powiekszone o 2
        System.out.println();
        List<String> listaString = new ArrayList<>(Arrays.asList("ALa", "Adam", "Tadeusz", "Karol"));

        listaString.stream().filter(str -> str.length() > 5).map(str -> str.length() + 2).forEach(i -> System.out.print(i + " "));

        // limit(i) ogranicza pierwszych i elementow

        // skip(i) przeskakuje pierwsze i elelemnt.

        // count() zwraca ilosc elementow

        // allMatch() true false w zaleznosci czy wszystkie elelenty spelniaja warunek

        // anyMatch() jw. ktorykolwiek

        // findFirst() zwraca pierwszy element ze streamu

        // min() max() najmniejszy lub najmniejszy

        // distinct() unikalne elementy.

        // collect() pozwala na utworzenie innego typu

        // toList() zwraca elementy do listy

        System.out.println();

        List<Integer> listaIntow2 = new ArrayList<>(Arrays.asList(4, null, 5, 3, 8, 3));
        System.out.println(iloscElementow(listaIntow2));

        System.out.println(sumaElementow(listaIntow2));
        System.out.println(sumaElementow2(listaIntow2));
    }

    // napisz metode która zwroci ilosc elementow na liscie Integerow
    public static long iloscElementow(List<Integer> lista) {
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .count();
    }

// napisz metode ktora liczy sume elementow listy integerow

    public static int sumaElementow(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                //.mapToInt(i -> i)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }
    public static int sumaElementow2(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    // napisz metode która zwroci liste liczb parzystych

    public static List<Integer> liczbyParzyste(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(i -> i % 2 == 0)
                .toList();
    }

    // napisz metode która policzy sume elementow nieparzystych ale uzyj method referecne

    public static int sumaNieparzystych(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(Predicate.not(Main::parzysta))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean parzysta(int i){
        return i % 2 == 0;
    }

    // napisz metode która policzy sume elementow nieparzystych
    public static int sumaNieparzystych2(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(i -> i % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

    }



    // napisz metode która policzy srednia listy intow
    // orElse() jesli wartosc jest obecna to ja zwraca a jesli nie to 0.0

    public static double sredniaInt(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum()
                .
    }


    // napisz metode która zwraca najmniejsza liczbe, jesli jej nie ma to rzuc wyjatkiem NoMinElementBro
    public static int najmniejszaLiczba(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .min(Comparator.comparingInt(Integer::intValue))
                .orElse
    }
    // napisz metode która zwraca najwieksza liczbe

    public static int najwiekszaLiczba(List<Integer> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

    }

    // napisz metode która znajduje najdluzszego Stringa z listy

    public static String najdluzszyString(List<String> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .max(Comparator.comparingInt(String::length))
                .get();
    }


    // napisz metode która znajduje wszystkie imiona męskie

    public static List<String> imionaZenskie(List<String> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(a -> a.endsWith("a"))
                .toList();
    }


    // napisz metode która znajduje wszystkie stringi które posiadaja podany char

    public static List<String> zawierajaZnak(List<String> lista, char znak){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .filter(a -> a.contains(String.valueOf(znak)))
                .toList();
    }


    // napisz metode ktora zwraca wszystkie wspolne elementy z dwoch list

    public static List<Integer> wspolneElementy(List<Integer> lista1, List<Integer> lista2){
        return Optional.ofNullable(lista1)
                .orElse(Collections.emptyList())
                .stream()
                .filter(lista2::contains)
                .toList();
    }

    // zwroc top 5 liczb z listy

    public static List<Integer> topN(List<Integer> lista, int n){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .sorted()
                .limit(n)
                .toList();
    }


    // policz ile jakich liter jest w slowach na liscie stringow

    public static Map<String, Integer> policzLitery(List<String> lista){
        return Optional.ofNullable(lista)
                .orElse(Collections.emptyList())
                .stream()
                .collect(ArrayList::new, List::addAll, List::addAll)
                .
    }
    // napisz metode która przyjmuje jako prametr Liste list intow a jako wynik
    // zwraca wszystkie inty zawarte w strutkurze

    public static List<Integer> intyLista(List<List<Integer>> listaList){
        return Optional.ofNullable(listaList)
                .orElse(Collections.emptyList())
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }


    // dowiedz sie jaka jest roznica miedzy orElse() i orElseGetem(), sprawdz czasy wykonan tych dwoch metod dla jakiegos konkrentegou przypadku
    // jakie wnioski?

    //orElse jak uzywamy parametru orElseGet jak uzywamy metody. W przypadku uzycia orElse i metody to metoda zostanie wywolana nawet jak nie zajdzie taka potrzeba
}
