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

    /*

     _______  _______  _______           _______ _________ _        _______      __      _______  _______  _______ ____________________________________ _______  _       _________ _        _______
    (  ____ \(  ____ )(  ___  )|\     /|(  ____ )\__   __/( (    /|(  ____ \    /__\    (  ____ )(  ___  )(  ____ )\__   __/\__   __/\__   __/\__   __/(  ___  )( (    /|\__   __/( (    /|(  ____ \
    | (    \/| (    )|| (   ) || )   ( || (    )|   ) (   |  \  ( || (    \/   ( \/ )   | (    )|| (   ) || (    )|   ) (      ) (      ) (      ) (   | (   ) ||  \  ( |   ) (   |  \  ( || (    \/
    | |      | (____)|| |   | || |   | || (____)|   | |   |   \ | || |          \  /    | (____)|| (___) || (____)|   | |      | |      | |      | |   | |   | ||   \ | |   | |   |   \ | || |
    | | ____ |     __)| |   | || |   | ||  _____)   | |   | (\ \) || | ____     /  \/\  |  _____)|  ___  ||     __)   | |      | |      | |      | |   | |   | || (\ \) |   | |   | (\ \) || | ____
    | | \_  )| (\ (   | |   | || |   | || (         | |   | | \   || | \_  )   / /\  /  | (      | (   ) || (\ (      | |      | |      | |      | |   | |   | || | \   |   | |   | | \   || | \_  )
    | (___) || ) \ \__| (___) || (___) || )      ___) (___| )  \  || (___) |  (  \/  \  | )      | )   ( || ) \ \__   | |   ___) (___   | |   ___) (___| (___) || )  \  |___) (___| )  \  || (___) |
    (_______)|/   \__/(_______)(_______)|/       \_______/|/    )_)(_______)   \___/\/  |/       |/     \||/   \__/   )_(   \_______/   )_(   \_______/(_______)|/    )_)\_______/|/    )_)(_______)

    Grouping agrupa los elementos de un stream en un Map según una
    función que define la clave del grupo.

    Partitioning divide los elementos de un stream en dos
    grupos (true y false) según una condición.

     */

    // Agrupar los números por signo (positivo/negativo/0)
    public Map<String, List<Integer>> groupBySign(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> {
                    if (n > 0) return "POSITIVE";
                    if (n < 0) return "NEGATIVE";
                    return "ZERO";
                }));
    }

    // Agrupar los números por paridad
    public Map<String, List<Integer>> groupByParity(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n ->
                        n % 2 == 0 ? "Pares" : "Impares"
                ));
    }

    // Agrupar los números por rango: <10, 10-50,>50
    public Map<String, List<Integer>> groupByRange(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> {
                    if (n < 10) return "Menos de 10";
                    if (n >= 10 && n <= 50) return "Entre 10 y 50";
                    return "Mayor de 50";
                }));
    }

    // Contar cúantos números hay por signo
    public Map<String, Long> countBySign(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> {
                    if (n < 0) return "Negativos";
                    if (n > 0) return "Positivos";
                    return "Ceros";
                }, Collectors.counting()));
    }

    // Contar cúantos números hay por paridad
    public Map<String, Long> countByParity(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n ->
                        n % 2 == 0 ? "Pares" : "Impares", Collectors.counting()
                ));
    }

    // Particionar números positivos y no positivos
    public Map<Boolean, List<Integer>> partitionPositive(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n > 0));
    }

    // Particionar números mayores que 20 y menores o iguales
    public Map<Boolean, List<Integer>> partitionGreaterThan20(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n > 20));
    }

    // Agrugar números por residuo módulo 3
    public Map<Integer, List<Integer>> groupByModulo3(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 3));
    }

    // Obtener máximo número por grupo de signo
    public Map<String, Optional<Integer>> maxBySign(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> {
                    if (n > 0) return "Positivo mayor";
                    if (n < 0) return "Negativo mayor";
                    return "Cero";
                }, Collectors.maxBy(Comparator.naturalOrder())));
    }

    // Obtener mínimo número por grupo de paridad
    public Map<String, Optional<Integer>> minByParity(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> {
                    if (n % 2 == 0) return "Par mínimo";
                    return "Impar mínimo";
                }, Collectors.minBy(Comparator.naturalOrder())));
    }

    /*
     _______  _        _______ _________ _______  _______  _______             _        _______  _______ _________ _______  ______
    (  ____ \( \      (  ___  )\__   __/(       )(  ___  )(  ____ )       /\  ( (    /|(  ____ \(  ____ \\__   __/(  ____ \(  __  \
    | (    \/| (      | (   ) |   ) (   | () () || (   ) || (    )|      / /  |  \  ( || (    \/| (    \/   ) (   | (    \/| (  \  )
    | (__    | |      | (___) |   | |   | || || || (___) || (____)|     / /   |   \ | || (__    | (_____    | |   | (__    | |   ) |
    |  __)   | |      |  ___  |   | |   | |(_)| ||  ___  ||  _____)    / /    | (\ \) ||  __)   (_____  )   | |   |  __)   | |   | |
    | (      | |      | (   ) |   | |   | |   | || (   ) || (         / /     | | \   || (            ) |   | |   | (      | |   ) |
    | )      | (____/\| )   ( |   | |   | )   ( || )   ( || )        / /      | )  \  || (____/\/\____) |   | |   | (____/\| (__/  )
    |/       (_______/|/     \|   )_(   |/     \||/     \||/         \/       |/    )_)(_______/\_______)   )_(   (_______/(______/

    FlatMap es una operación que transforma cada elemento en otro stream y luego aplana todos
    los resultados en un único stream continuo

    Nested Structures son estructuras de datos que contienen otras estructuras dentro (por ejemplo
    List<List<T>> formando niveles o jerarquías internas

     */

    // Aplanar una lista de listas de números
    public List<Integer> flattenListOfLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                // .flatMap(list -> list.stream())
                .flatMap(List::stream)
                .toList();
    }

    // Obtener todos los números pares de una lista de listas
    public List<Integer> flattenEvenNumbers(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .filter(n -> n % 2 == 0)
                .toList();
    }

    // Obtener el producto de todos los números en lista de listas
    public Optional<Integer> flattenProductAll(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .reduce(Math::multiplyExact);
    }

    // Aplanar y eliminar duplicados
    public List<Integer> flattenAndDistinct(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    // Aplanar y ordenar todos los números
    public List<Integer> flattenAndSort(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .sorted()
                .toList();
    }

    // Obtener el número más cercano a cero de lista de listas
    public Optional<Integer> flattenClosetToZero(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .reduce((a, b) -> Math.abs(a) < Math.abs(b) ? a : b);
    }

    // Obtener la suma de cuadrados de positivos de lista de listas
    public Integer flattenSumSquaresPositive(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .filter(n -> n > 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Obtener el número máximo de cada sublista
    public List<Integer> maxPerSublist(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .map(sublist -> sublist.stream()
                        .max(Integer::compareTo)
                        .orElse(null))
                .toList();
    }

    // Obtener el número mínimo de cada sublista
    public Map<Integer, Optional<Integer>> minPerSublist(List<List<Integer>> listOfLists) {
        return IntStream.range(0, listOfLists.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        i -> listOfLists.get(i).stream()
                                .min(Integer::compareTo)
                ));
    }

    // Contar cúantos números impares hay en total
    public long countOddFlattened(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .filter(n -> n % 2 != 0)
                .count();
    }

    /*
     _______ _________ _______ __________________ _______ __________________ _______  _______
    (  ____ \\__   __/(  ___  )\__   __/\__   __/(  ____ \\__   __/\__   __/(  ____ \(  ____ \
    | (    \/   ) (   | (   ) |   ) (      ) (   | (    \/   ) (      ) (   | (    \/| (    \/
    | (_____    | |   | (___) |   | |      | |   | (_____    | |      | |   | |      | (_____
    (_____  )   | |   |  ___  |   | |      | |   (_____  )   | |      | |   | |      (_____  )
          ) |   | |   | (   ) |   | |      | |         ) |   | |      | |   | |            ) |
    /\____) |   | |   | )   ( |   | |   ___) (___/\____) |   | |   ___) (___| (____/\/\____) |
    \_______)   )_(   |/     \|   )_(   \_______/\_______)   )_(   \_______/(_______/\_______)

     IntSummaryStatistics es una clase de java que recopila estadísticas básicas
     (count, sum, min, max y average) de una conjunto de valores int en una sola
     operación.

     Se usa normalmente con IntStream.summaryStatistics() o Collectors.summarizingInt()
     para obtener todas esas métricas de forma eficiente sin recorrer la
     colección varias veces.

     */

    // Obtener estadísticas completa (count, sum, min, max, average)
    public IntSummaryStatistics statisticsAll(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue) // Crea un IntStream
                .summaryStatistics();
    }

    // Obtener promedio de números positivos
    public double averagePositive(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n > 0)
                .summaryStatistics()
                .getAverage();
    }

    // Obtener suma de números negativos
    public long sumNegative(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n < 0)
                .summaryStatistics()
                .getSum();
    }

    // Obtener número máximo absoluto
    public float maxAbsoluteValueStats(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                //.map(n -> Math.abs(n))
                .map(Math::abs)
                .summaryStatistics()
                .getMax();
    }

    // Obtener número mínimo absoluto
    public float minAbsoluteValueStats(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .map(Math::abs)
                .summaryStatistics()
                .getMin();
    }

    // Contar cuántos números terminan en 7
    public long countEndingInSevenStats(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> Math.abs(n) % 10 == 7)
                .count();
        // Otra forma increíble que devuelve int y sin usar count:
        //.mapToInt(n -> Math.abs(n) % 10 == 7 ? 1 : 0)
        //.sum();
    }

    // Obtener suma acumulada de cuadrados
    public int sumSquaresAllStats(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Obtener rango de números (max - min)
    public int rangeNumbers(List<Integer> numbers) {
        IntSummaryStatistics iss = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        return iss.getMax() - iss.getMin();
    }

    // Obtener números por residuo módulo 5
    public Map<Integer, Long> countByModulo5Stats(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        n -> n % 5, Collectors.counting()
                ));
    }

    // Agrupar números por residuo módulo 10
    public Map<Integer, List<Integer>> groupByModulo10Stats(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 10));
    }

    // ========================
    // Ejercicios más complejos
    // ========================

    // Sumar números positivos y negativos por separado
    public Map<String, Integer> sumPositiveNegative(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        n -> n < 0 ? "Suma Negativa" : "Suma Positiva",
                        Collectors.summingInt(n -> n) // Usa auto-unboxing
                        // (Integer::intValue) Más explícito
                        // (n -> n.intValue() Más verboso
                ));
    }

    // Producto de números pares mayores que 10
    public Optional<Integer> productEvenGraterThan10(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0 && n > 10)
                .reduce((a, b) -> a * b);
    }

    // Obtener suma acumulada de cuadrados de impares
    public Optional<Integer> sumSquaresOdd(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .reduce((a, b) -> a + b);
    }

    // Obtener número con segundo valor absoluto mayor
    public Optional<Integer> secondLargestByAbsStream(List<Integer> numbers) throws Exception {
        if (numbers.isEmpty()) throw new Exception();
        return numbers.stream()
                .map(n -> Math.abs(n))
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

    }

    // Encontrar primer número par mayor que 50
    public Optional<Integer> firstEvenGreater50(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0 && n > 50)
                .findFirst();
    }

    // Verificar si todos los números negativos tienen valor absoluto
    // menor a 100
    public boolean allNegativesAbsLess100(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n < 0)
                .map(Math::abs)
                .allMatch(n -> n < 100);
    }

    // Contar cuántos números únicos > 10
    public long countDistinctGreater10(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .filter(n -> n > 10)
                .count();
    }

    // Encontrar producto de números mayores que promedio
    public long productGreaterThanAverage(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        return numbers.stream()
                .filter(n -> n > average.getAsDouble())
                .reduce(1, (a, b) -> a * b);
    }

    // Obtener lista de números multiplicados por índice
    public List<Integer> multiplyByIndex(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> numbers.get(i) * i)
                .toList(); // Genera una lista nueva con el efecto aplicado
    }

    // Obtener lista de números en espejo (negativos -> positivos, positivos -> negativos)
    public List<Integer> negateAllNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * -1)
                .toList();
    }

    // =====================
    // Ejercicios de Strings
    // =====================

    // Convertir lista de strings a un Set -> toSetStrings
    public Set<String> toSetStrings(List<String> words) {
        return words.stream()
                .collect(Collectors.toSet());
    }

    // Concatenar todos los strings separados por comas
    public String joinStringsComma(List<String> words) {
        return words.stream()
                .collect(Collectors.joining(","));
    }

    // Concatenar todos los strings en mayúsculas
    public String joinUppercaseStrings(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
    }

    // Contar cuántos strings tienen longitud > 5
    public long countStringsLengthGreater5(List<String> words) {
        return words.stream()
                .filter(s -> s.length() > 5)
                .count();
    }

    // Encontrar el string más largo
    public Optional<String> longestString(List<String> words) {
        return words.stream()
                .max(Comparator.comparingInt(String::length));
    }

    // Encontrar el string más corto
    public Optional<String> shortestString(List<String> words) {
        return words.stream()
                .min(Comparator.comparingInt(String::length));
    }


    // Crear lista filtrando strings que contengan “a”
    public List<String> stringsContainingA(List<String> words) {
        return words.stream()
                .filter(word -> word.contains("a"))
                .toList();
    }


    // Convertir todos los strings a minúsculas
    public List<String> toLowercaseStrings(List<String> words) {
        return words.stream()
                .map(String::toLowerCase)
                .toList();
    }


    // Convertir todos los strings a mayúsculas → toUppercaseStrings
    public List<String> toUppercaseStrings(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .toList();
    }

    // Crear un Map de string → longitud
    public Map<Integer, List<String>> mapStringToLength(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // ===================================
    // GROUPING & PARTITIONING CON STRINGS
    // ===================================

    // Agrupar strings por su primera letra → groupByFirstChar
    // Agrupar strings por longitud → groupByLength
    // Contar strings por longitud → countByLength
    // Particionar strings que contienen “e” y los que no → partitionContainsE
    // Particionar strings con longitud par e impar → partitionEvenOddLength
    // Agrupar strings por su último carácter → groupByLastChar
    // Obtener string más largo por primer carácter → longestByFirstChar
    // Obtener string más corto por longitud → shortestByLength
    // Contar cuántos strings empiezan con vocal → countStartingVowel
    // Contar cuántos strings terminan en consonante → countEndingConsonant
    // Particionar strings que comienzan con vocal ??

    // =======================================
    // FLATMAP / NESTED STRUCTURES CON STRINGS
    // =======================================

    // Aplanar lista de listas de strings → flattenListOfStrings
    // Obtener todas las palabras de lista de frases → flattenWordsFromSentences
    // Obtener todas las palabras únicas → flattenDistinctWords
    // Convertir lista de listas a lista de longitudes → flattenLengths
    // Obtener todas las palabras en mayúsculas → flattenUppercaseWords
    // Filtrar palabras que contengan “ing” en lista de listas → flattenWordsContainingIng
    // Contar cuántas palabras tienen longitud > 3 → countWordsLengthGreater3
    // Obtener palabra más larga de cada sublista → longestWordPerSublist
    // Ordenar palabras de todas las sublistas → sortFlattenedWords
    // Concatenar palabras de todas las sublistas en un solo string → joinFlattenedWords

    // ==================================
    // ESTADÍSTICAS Y RESUMEN CON STRINGS
    // ==================================

    // Obtener estadística de longitudes (min, max, promedio) → stringLengthStatistics
    // Obtener palabra más repetida → mostFrequentString
    // Contar cuántas palabras empiezan con mayúscula → countStartingUppercase
    // Contar cuántas palabras son palíndromos → countPalindromes
    // Obtener lista de palabras únicas de longitud par → distinctEvenLengthWords
    // Obtener lista de palabras únicas de longitud impar → distinctOddLengthWords
    // Concatenar palabras separadas por guion → joinWordsWithDash
    // Contar palabras por primera letra → countByFirstChar
    // Contar palabras por última letra → countByLastChar
    // Verificar si todas las palabras tienen longitud > 2 → allWordsLengthGreater2

    // ==============================
    // REDUCE / COMBINADO CON STRINGS
    // ==============================

    // Concatenar todas las palabras en mayúsculas con espacio → reduceToUppercaseSentence
    // Obtener la palabra más larga usando reduce → reduceLongestWord
    // Obtener la palabra más corta usando reduce → reduceShortestWord
    // Contar total de caracteres de todas las palabras usando map + reduce → reduceTotalChars
    // Concatenar palabras que contengan “a” → reduceWordsContainingA
    // Obtener la palabra más repetida usando reduce → reduceMostFrequentWord
    // Concatenar palabras de longitud par separadas por coma → reduceEvenLengthWords
    // Obtener primer string que contenga “ing” → findFirstWordWithIng
    // Verificar si existe palabra de longitud mayor a 10 → anyWordLongerThan10
    // Concatenar todas las palabras en minúsculas y ordenadas → reduceSortedLowercaseWords



    public static void main(String[] args) {
        System.out.println("Ahora le subimos el nivel a los streams :)");
        StreamIntermediate si = new StreamIntermediate();

        // Listas de prueba de Integer
        List<Integer> list = Arrays.asList(-150, -110, -50, -10, -7, -3, -1,
                0, 1, 2, 2, 3, 4, 5, 7, 10, 14, 20, 21, 30, 42, 49,
                50, 75, 99, 100, 101, 151, 2, 3, 7, 14, 20, 17, 32, 87);

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6, 1),
                Arrays.asList(-10, -20)
        );

        // System.out.println(si.negateAllNumbers(list));

        // Listas de prueba de Strings
        List<String> words = List.of(
                "apple", "apple","banana","orange","kiwi","pear",
                "grape","melon","avocado","fig","mango",
                "testing","running","coding","level","radar"
        );

        List<String> sentences = List.of(
                "java streams are powerful",
                "functional programming is cool",
                "learning streams is interesting"
        );

        List<List<String>> nested = List.of(
                List.of("apple","banana","cherry"),
                List.of("dog","elephant","fox"),
                List.of("grape","melon","kiwi")
        );

        System.out.println(si.mapStringToLength(words));

    }
}
