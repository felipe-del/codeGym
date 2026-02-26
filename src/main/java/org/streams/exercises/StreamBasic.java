package org.streams.exercises;

import java.util.Arrays;
import java.util.List;

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
     */

    /*
     _______  _______  _______ _________            ______  _________ _______ __________________ _        _______ _________            _       _________ _______ __________________            _______  _       _________ _______
    (  ____ \(  ___  )(  ____ )\__   __/       /\  (  __  \ \__   __/(  ____ \\__   __/\__   __/( (    /|(  ____ \\__   __/       /\  ( \      \__   __/(       )\__   __/\__   __/       /\  (  ____ \| \    /\\__   __/(  ____ )
    | (    \/| (   ) || (    )|   ) (         / /  | (  \  )   ) (   | (    \/   ) (      ) (   |  \  ( || (    \/   ) (         / /  | (         ) (   | () () |   ) (      ) (         / /  | (    \/|  \  / /   ) (   | (    )|
    | (_____ | |   | || (____)|   | |        / /   | |   ) |   | |   | (_____    | |      | |   |   \ | || |         | |        / /   | |         | |   | || || |   | |      | |        / /   | (_____ |  (_/ /    | |   | (____)|
    (_____  )| |   | ||     __)   | |       / /    | |   | |   | |   (_____  )   | |      | |   | (\ \) || |         | |       / /    | |         | |   | |(_)| |   | |      | |       / /    (_____  )|   _ (     | |   |  _____)
          ) || |   | || (\ (      | |      / /     | |   ) |   | |         ) |   | |      | |   | | \   || |         | |      / /     | |         | |   | |   | |   | |      | |      / /           ) ||  ( \ \    | |   | (
    /\____) || (___) || ) \ \__   | |     / /      | (__/  )___) (___/\____) |   | |   ___) (___| )  \  || (____/\   | |     / /      | (____/\___) (___| )   ( |___) (___   | |     / /      /\____) ||  /  \ \___) (___| )
    \_______)(_______)|/   \__/   )_(     \/       (______/ \_______/\_______)   )_(   \_______/|/    )_)(_______/   )_(     \/       (_______/\_______/|/     \|\_______/   )_(     \/       \_______)|_/    \/\_______/|/
     */
    /*
     _______  _______ _________ _______             _______  _______  _______  _______  _______ __________________ _______  _        _______
    (       )(  ___  )\__   __/(  ____ \|\     /|  (  ___  )(  ____ )(  ____ \(  ____ )(  ___  )\__   __/\__   __/(  ___  )( (    /|(  ____ \
    | () () || (   ) |   ) (   | (    \/| )   ( |  | (   ) || (    )|| (    \/| (    )|| (   ) |   ) (      ) (   | (   ) ||  \  ( || (    \/
    | || || || (___) |   | |   | |      | (___) |  | |   | || (____)|| (__    | (____)|| (___) |   | |      | |   | |   | ||   \ | || (_____
    | |(_)| ||  ___  |   | |   | |      |  ___  |  | |   | ||  _____)|  __)   |     __)|  ___  |   | |      | |   | |   | || (\ \) |(_____  )
    | |   | || (   ) |   | |   | |      | (   ) |  | |   | || (      | (      | (\ (   | (   ) |   | |      | |   | |   | || | \   |      ) |
    | )   ( || )   ( |   | |   | (____/\| )   ( |  | (___) || )      | (____/\| ) \ \__| )   ( |   | |   ___) (___| (___) || )  \  |/\____) |
    |/     \||/     \|   )_(   (_______/|/     \|  (_______)|/       (_______/|/   \__/|/     \|   )_(   \_______/(_______)|/    )_)\_______)
     */
    /*
     _______ _________ _        ______
    (  ____ \\__   __/( (    /|(  __  \
    | (    \/   ) (   |  \  ( || (  \  )
    | (__       | |   |   \ | || |   ) |
    |  __)      | |   | (\ \) || |   | |
    | (         | |   | | \   || |   ) |
    | )      ___) (___| )  \  || (__/  )
    |/       \_______/|/    )_)(______/
     */
    /*
     _______  _______           _       _________
    (  ____ \(  ___  )|\     /|( (    /|\__   __/
    | (    \/| (   ) || )   ( ||  \  ( |   ) (
    | |      | |   | || |   | ||   \ | |   | |
    | |      | |   | || |   | || (\ \) |   | |
    | |      | |   | || |   | || | \   |   | |
    | (____/\| (___) || (___) || )  \  |   | |
    (_______/(_______)(_______)|/    )_)   )_(
     */
    /*
     _______  _______  ______            _______  _______
    (  ____ )(  ____ \(  __  \ |\     /|(  ____ \(  ____ \
    | (    )|| (    \/| (  \  )| )   ( || (    \/| (    \/
    | (____)|| (__    | |   ) || |   | || |      | (__
    |     __)|  __)   | |   | || |   | || |      |  __)
    | (\ (   | (      | |   ) || |   | || |      | (
    | ) \ \__| (____/\| (__/  )| (___) || (____/\| (____/\
    |/   \__/(_______/(______/ (_______)(_______/(_______/
     */


    public static void main(String[] args) {
        StreamBasic sb = new StreamBasic();
        List<Integer> numbers = Arrays.asList(
                -150, -100, -50, -10, -7, -3, -1,
                0,
                1, 2, 3, 4, 5, 7, 10, 14, 20, 21, 30, 42, 49,
                50, 75, 99, 100, 101, 150,
                2, 3, 7, 14, 20, 17, 32, 87
        );
        System.out.println(sb.getEndingInSeven(numbers));
    }
}
