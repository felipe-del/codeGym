package org.streams.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamBasic {
    /*
     _______ _________ _    _________ _______  _______
    (  ____ \\__   __/( \   \__   __/(  ____ \(  ____ )
    | (    \/   ) (   | (      ) (   | (    \/| (    )|
    | (__       | |   | |      | |   | (__    | (____)|
    |  __)      | |   | |      | |   |  __)   |     __)
    | (         | |   | |      | |   | (      | (\ (
    | )      ___) (___| (____/\| |   | (____/\| ) \ \__
    |/       \_______/(_______/)_(   (_______/|/   \__/

    filter es una operación intermedia de Stream que selecciona
    únicamente los elementos que cumplen una condición (Predicate)
    y descarta los demás.

    */

    // Retornar solo números pares
    public List<Integer> getEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
    }

    // Retornar solo números impares
    public List<Integer> getOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();
    }

    //Retorna números mayores a 10
    public List<Integer> getGreaterThanTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 10)
                .toList();
    }

    // Retornar números menores o iguales a 0
    public List<Integer> getLessOrEqualZero(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n <= 0)
                .toList();
    }

    // Retornar números divisibles entre 3
    public List<Integer> getDivisibleByThree(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 3 == 0)
                .toList();
    }

    // Retorna número múltiplo de 5 pero no de 10
    public List<Integer> getMultiplesOfFiveNotTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 5 == 0 && n % 10 != 0)
                .toList();
    }

    // Retornar números entre 20 y 50 (inclusive)
    public List<Integer> getBetweenTwentyAndFifty(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n >= 20 && n <= 50)
                .toList();
    }

    //Retornar números negativos
    public List<Integer> getNegativeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n < 0)
                .toList();
    }

    //Retornar números positivos
    public List<Integer> getPositiveNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 0)
                .toList();
    }

    // Retornar números que terminen en 7
    public List<Integer> getEndingInSeven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> Math.abs(n) % 10 == 7)
                .toList();
    }

    /*
     _______  _______  _______
    (       )(  ___  )(  ____ )
    | () () || (   ) || (    )|
    | || || || (___) || (____)|
    | |(_)| ||  ___  ||  _____)
    | |   | || (   ) || (
    | )   ( || )   ( || )
    |/     \||/     \||/

    Map es una operación intermedia de Stream que transforma cada
    elemento en otro valor aplicando una función, manteniendo la
    misma cantidad de elementos en el flujo.

     */

    // Multiplicar cada número por 2
    public List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * 2)
                .toList();
    }

    // Elevar cada número al cuadrado
    public List<Integer> squareNumbers(List<Integer> numbs) {
        return numbs.stream()
                .map(n -> n * n)
                .toList();
    }

    // Convertir cada número en su valor absoluto
    public List<Integer> absoluteValues(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n < 0 ? -n : n)
                .toList();
    }

    // Convertir cada número en su string equivalente
    public List<String> convertToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }

    // Sumar 10 a cada número
    public List<Integer> addTenToEach(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n + 10)
                .toList();
    }

    // Convertir números a boolean (true si es par, false si es impar)
    public List<Boolean> mapToEvenBoolean(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n % 2 == 0)
                .toList();
    }

    // Obtener el residuo de cada número dividido entre 3
    public List<Integer> getRemainderByThree(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n % 3)
                .toList();
    }

    // Negar cada número
    public List<Integer> negateNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> -n)
                .toList();
    }

    /*
     _______  _______  _______ _________            ______  _________ _______ __________________ _        _______ _________            _       _________ _______ __________________            _______  _       _________ _______
    (  ____ \(  ___  )(  ____ )\__   __/       /\  (  __  \ \__   __/(  ____ \\__   __/\__   __/( (    /|(  ____ \\__   __/       /\  ( \      \__   __/(       )\__   __/\__   __/       /\  (  ____ \| \    /\\__   __/(  ____ )
    | (    \/| (   ) || (    )|   ) (         / /  | (  \  )   ) (   | (    \/   ) (      ) (   |  \  ( || (    \/   ) (         / /  | (         ) (   | () () |   ) (      ) (         / /  | (    \/|  \  / /   ) (   | (    )|
    | (_____ | |   | || (____)|   | |        / /   | |   ) |   | |   | (_____    | |      | |   |   \ | || |         | |        / /   | |         | |   | || || |   | |      | |        / /   | (_____ |  (_/ /    | |   | (____)|
    (_____  )| |   | ||     __)   | |       / /    | |   | |   | |   (_____  )   | |      | |   | (\ \) || |         | |       / /    | |         | |   | |(_)| |   | |      | |       / /    (_____  )|   _ (     | |   |  _____)
          ) || |   | || (\ (      | |      / /     | |   ) |   | |         ) |   | |      | |   | | \   || |         | |      / /     | |         | |   | |   | |   | |      | |      / /           ) ||  ( \ \    | |   | (
    /\____) || (___) || ) \ \__   | |     / /      | (__/  )___) (___/\____) |   | |   ___) (___| )  \  || (____/\   | |     / /      | (____/\___) (___| )   ( |___) (___   | |     / /      /\____) ||  /  \ \___) (___| )
    \_______)(_______)|/   \__/   )_(     \/       (______/ \_______/\_______)   )_(   \_______/|/    )_)(_______/   )_(     \/       (_______/\_______/|/     \|\_______/   )_(     \/       \_______)|_/    \/\_______/|/

     Sort/sorted ordena los elementos del stream de forma ascendente o
     según un comparador
     Distinct elimina duplicados, dejando solo elementos únicos
     Limit(n) toma dolo los primeros n elementos del Stream
     Skip(n) Omite los primeros n elementos del stream y procesa el reste

     */

    // Ordenar números ascendentemente
    public List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted() // Por defecto usa Comparator.naturalOrder()
                .toList();
    }

    // Ordenar números descendientemente
    public List<Integer> sortDescending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // Eliminar duplicados
    public List<Integer> removeDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList();
    }

    // Obtener los 5 números más grandes
    public List<Integer> getTopFive(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .toList();
    }

    // Obtener los 5 números más pequeños
    public List<Integer> getBottomFive(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .limit(5)
                .toList();
    }

    // Saltar los primeros 3 números
    public List<Integer> skipFirstThree(List<Integer> numbers) {
        return numbers.stream()
                .skip(3)
                .toList();
    }

    // Obtener los primeros 4 números pares
    public List<Integer> getFirstFourEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .limit(4)
                .toList();
    }

    // Ordenar y luego eliminar duplicados
    public List<Integer> sortAndDistinct(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .distinct()
                .toList();
    }

    // Obtener el segundo número más grande
    public Optional<Integer> getSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    // Obtener el tercer número más pequeño
    public Optional<Integer> getThirdSmallest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .skip(2)
                .findFirst();
    }

    /*
     _______  _______ _________ _______             _______  _______  _______  _______  _______ __________________ _______  _        _______
    (       )(  ___  )\__   __/(  ____ \|\     /|  (  ___  )(  ____ )(  ____ \(  ____ )(  ___  )\__   __/\__   __/(  ___  )( (    /|(  ____ \
    | () () || (   ) |   ) (   | (    \/| )   ( |  | (   ) || (    )|| (    \/| (    )|| (   ) |   ) (      ) (   | (   ) ||  \  ( || (    \/
    | || || || (___) |   | |   | |      | (___) |  | |   | || (____)|| (__    | (____)|| (___) |   | |      | |   | |   | ||   \ | || (_____
    | |(_)| ||  ___  |   | |   | |      |  ___  |  | |   | ||  _____)|  __)   |     __)|  ___  |   | |      | |   | |   | || (\ \) |(_____  )
    | |   | || (   ) |   | |   | |      | (   ) |  | |   | || (      | (      | (\ (   | (   ) |   | |      | |   | |   | || | \   |      ) |
    | )   ( || )   ( |   | |   | (____/\| )   ( |  | (___) || )      | (____/\| ) \ \__| )   ( |   | |   ___) (___| (___) || )  \  |/\____) |
    |/     \||/     \|   )_(   (_______/|/     \|  (_______)|/       (_______/|/   \__/|/     \|   )_(   \_______/(_______)|/    )_)\_______)

     allMatch es una operación terminal de Stream que devuelve
     true si todos los elementos cumplen una condición dada.

     */

    // Verifica si todos los números son positivos
    public boolean areAllPositive(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(n -> n > 0);
    }

    // Verifica si todos son pares
    public boolean areAllEven(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(n -> n % 2 == 0);
    }

    // Verifica si existe al menos un número negativo
    public boolean hasAnyNegative(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n < 0);
    }

    // Verifica si existe al menos un número mayor a 100
    public boolean hasAnyGreaterThanHundred(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n > 100);
    }

    // Verifica que ninguno sea cero
    public boolean noneZero(List<Integer> numbers) {
        return numbers.stream()
                .noneMatch(n -> n == 0);
    }

    // Verifica que ninguno sea negativo
    public boolean noneNegative(List<Integer> numbers) {
        return numbers.stream()
                .noneMatch(n -> n < 0);
    }


    /*
     _______ _________ _        ______
    (  ____ \\__   __/( (    /|(  __  \
    | (    \/   ) (   |  \  ( || (  \  )
    | (__       | |   |   \ | || |   ) |
    |  __)      | |   | (\ \) || |   | |
    | (         | |   | | \   || |   ) |
    | )      ___) (___| )  \  || (__/  )
    |/       \_______/|/    )_)(______/

    find es una operación terminal de Stream que devuelve un
    Optional con el primer elemento que cumple una condición o
    que aparece en el flujo.

     */

    // Obtener el primer número par
    public Optional<Integer> findFirstEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
    }

    // Obtener el primer número mayor a 50
    public Optional<Integer> findFirstGreaterThanFifty(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 50)
                .findFirst();
    }

    // Obtener cualquier número negativo
    public Optional<Integer> findAnyNegative(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n < 0)
                .findAny();
    }

    // Obtener el primer número divisible entre 7
    public Optional<Integer> findFirstDivisibleBySeven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 7 == 0)
                .findFirst();
    }

    /*
     _______  _______           _       _________
    (  ____ \(  ___  )|\     /|( (    /|\__   __/
    | (    \/| (   ) || )   ( ||  \  ( |   ) (
    | |      | |   | || |   | ||   \ | |   | |
    | |      | |   | || |   | || (\ \) |   | |
    | |      | |   | || |   | || | \   |   | |
    | (____/\| (___) || (___) || )  \  |   | |
    (_______/(_______)(_______)|/    )_)   )_(

    count es una operación terminal de Stream que devuelve la
    cantidad de elementos que hay en el flujo como un long.

     */

    // Contar cuántos números son pares
    public long countEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
    }

    // Contar cúantos son mayores a 10
    public long countGreaterThanTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 10)
                .count();
    }

    // Contar cuántos son negativos
    public long countNegative(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n < 0)
                .count();
    }

    // Contar cuántos son únicos
    public long countDistinct(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }


    /*
     _______  _______  ______            _______  _______
    (  ____ )(  ____ \(  __  \ |\     /|(  ____ \(  ____ \
    | (    )|| (    \/| (  \  )| )   ( || (    \/| (    \/
    | (____)|| (__    | |   ) || |   | || |      | (__
    |     __)|  __)   | |   | || |   | || |      |  __)
    | (\ (   | (      | |   ) || |   | || |      | (
    | ) \ \__| (____/\| (__/  )| (___) || (____/\| (____/\
    |/   \__/(_______/(______/ (_______)(_______/(_______/

    reduce es una operación terminal de Stream que combina todos
    los elementos del flujo en un solo resultado aplicando
    una función acumuladora.

    Example 1 : reduce((a, b) -> a + b);
    aquí el acumulado es el mismo a y b es el siguiente elemento
    y devuelve un Optional porque puede estar vacío

    Example 2 : reduce(0, (a, b) -> a + b);
    aquí se utiliza un acumulador explícito (primera entrada)
    y devuelve el tipo del acumulador (int)

     */

    // Sumer todos los números
    public int sumAll(List<Integer> numbers) {
        return numbers.stream()
                // .reduce(0, (a, b) -> a + b) es la misma cosa :)
                .reduce(0, Integer::sum);
    }

    // Multiplicar todos los números
    public int multiplyAll(List<Integer> numbers) {
        return numbers.stream() // Aquí se muestra que el primer a
                                // es el acumulador ( 1*b = n > 0 )
                .reduce(1, (a, b) -> a * b);
    }

    // Obtener el número más grande usando reduce
    public Optional<Integer> maxUsingReduce(List<Integer> numbers) {
        return numbers.stream()
                // .reduce(Integer::max)
                .reduce((a, b) -> a > b ? a : b);
    }

    // Obtener el número más pequeño usando reduce
    public Optional<Integer> minUsingReduce(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a < b ? a : b);
    }

    // Sumar solo los números pares
    public int sumEven(List<Integer> numbers) {
        return numbers.stream() // Normalmente primero se filtran los Even Numbers
                                // Pero la idea es usar solo reduce
                .reduce(0, (a, b) -> b % 2 == 0 ? a + b : a);
    }

    // Restar todos los números en orden
    public Optional<Integer> subtractAll(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a - b);
    }

    // Calcular la suma acumulada empezando en 100
    public int sumStartingAtHundred(List<Integer> numbers) {
        return numbers.stream()
                // .reduce(100, (a, b) -> a + b)
                .reduce(100, Integer::sum);
    }




    public static void main(String[] args) {
        StreamBasic sb = new StreamBasic();
        List<Integer> numbers = Arrays.asList(
                -150, -100, -50, -10, -7, -3, -1,
                0,
                1, 2, 3, 4, 5, 7, 10, 14, 20, 21, 30, 42, 49,
                50, 75, 99, 100, 101, 150,
                2, 3, 7, 14, 20, 17, 32, 87
        );
        System.out.println(

                sb.sumAll(numbers)

        );
    }
}
