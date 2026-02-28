package org.streams.exercises;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamIntermediate {

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

    public static void main(String[] args) {
        System.out.println("Ahora le subimos el nivel a los streams :)");
        StreamIntermediate si = new StreamIntermediate();
        // Listas de prueba
        List<Integer> list = Arrays.asList(-150, -110, -50, -10, -7, -3, -1,
                0, 1, 2, 2, 3, 4, 5, 7, 10, 14, 20, 21, 30, 42, 49,
                50, 75, 99, 100, 101, 150, 2, 3, 7, 14, 20, 17, 32, 87);

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(-10, -20)
        );

        System.out.println(si.toSetCollector(list));

    }
}
