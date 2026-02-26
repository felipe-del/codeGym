package org.streams.exercises;

import java.util.Arrays;
import java.util.List;

public class StreamBasic {
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


    public static void main(String[] args) {
        StreamBasic sb = new StreamBasic();
        List<Integer> numbers = Arrays.asList(
                -150, -100, -50, -10, -7, -3, -1,
                0,
                1, 2, 3, 4, 5, 7, 10, 14, 20, 21, 30, 42, 49,
                50, 75, 99, 100, 101, 150,
                2, 3, 7, 14, 20
        );
        System.out.println(sb.getMultiplesOfFiveNotTen(numbers));
    }
}
