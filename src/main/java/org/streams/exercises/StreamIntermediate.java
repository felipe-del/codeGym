package org.streams.exercises;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamIntermediate {

    /*
     _______  _______  _        _        _______  _______ _________ _______  _______  _______
    (  ____ \(  ___  )( \      ( \      (  ____ \(  ____ \\__   __/(  ___  )(  ____ )(  ____ \
    | (    \/| (   ) || (      | (      | (    \/| (    \/   ) (   | (   ) || (    )|| (    \/
    | |      | |   | || |      | |      | (__    | |         | |   | |   | || (____)|| (_____
    | |      | |   | || |      | |      |  __)   | |         | |   | |   | ||     __)(_____  )
    | |      | |   | || |      | |      | (      | |         | |   | |   | || (\ (         ) |
    | (____/\| (___) || (____/\| (____/\| (____/\| (____/\   | |   | (___) || ) \ \__/\____) |
    (_______/(_______)(_______/(_______/(_______/(_______/   )_(   (_______)|/   \__/\_______)

    Collectors es una herramienta de Java Streams que acumula los elementos
    de un stream en una colección, un Map, un resumen o cualquier estructura
    de datos que quieras, usando funciones que indican cómo agrupar o
    transformar cada elemento.

     */

    // Convertir la lista en un Set (Elimina repetidos, sin orden)
    public Set<Integer> toSetCollector(List<Integer> numbers) {
        // return numbers.stream().collect(Collectors.toSet());
        return new HashSet<>(numbers);
    }

    // Convertir la lista en Map (índice -> Valor)
    public Map<Integer, Integer> toIndexMap(List<Integer> numbers) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            map.put(i, numbers.get(i));
        }
        return map;*/
        return IntStream.range(0, numbers.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        //i -> numbers.get(i)
                        numbers::get
                ));
    }

    // Concatenar todos los números en un string separados por comas
    public String joinNumbersComma(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    // Obtener la suma de todos los números usando Collectors.summingInt
    public int sumWithCollector(List<Integer> numbers) {
        // return numbers.stream().mapToInt(Integer::intValue).sum();
        return numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
    }

    // Obtener el promedio de todos los números
    public double averageWithCollector(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
    }

    // Obtener la suma de cuadrados usando Collectors.summingInt
    public int sumSquaresCollector(List<Integer> numbers) {
        // return numbers.stream().mapToInt(n -> (n * n)).sum();
        return numbers.stream()
                .collect(Collectors.summingInt(n -> (n * n)));
    }

    // Contar los elementos con Collectors.counting
    public long countWithCollector(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.counting());
    }

    // Encontrar el número máximo con Collectors.minBy
    public Optional<Integer> maxWithCollector(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
    }

    // Encontrar el número mínimo con Collectors.minBy
    public Optional<Integer> minWithCollector(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
    }

    // Crear una lista filtrada de números pares usando Collectors.toList
    public List<Integer> collectEvenNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }




    public static void main(String[] args) {
        System.out.println("Ahora le subimos el nivel a los streams :)");
        StreamIntermediate si = new StreamIntermediate();
        // Listas de prueba
        List<Integer> list = Arrays.asList(-150, -110, -50, -10, -7, -3, -1,
                0, 1, 2, 2, 3, 4, 5, 7, 10, 14, 20, 21, 30, 42, 49,
                50, 75, 99, 100, 101, 151, 2, 3, 7, 14, 20, 17, 32, 87);

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(-10, -20)
        );

        System.out.println(si.collectEvenNumber(list));

    }
}
