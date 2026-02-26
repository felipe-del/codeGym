package org.leetcode.easy.palindrome;

public class Solution2 {
    public boolean isPalindrome(int x) {
        // Casos base: números negativos y números que terminan en 0 (excepto el 0 mismo)
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverted = 0;
        while (x > reverted) {
            // Construye el número revertido a partir de los dígitos de x
            // Ejemplo: si x = 123, en la primera iteración reverted = 3 y x = 12
            // En la segunda iteración reverted = 32 y x = 1, ahora x no es mayor que reverted, así que salimos
            // Al final, reverted tendrá la mitad de los dígitos de x (o un dígito más si x tiene un número impar de dígitos)
            //
            reverted = reverted * 10 + x % 10; // Agrega el último dígito de x a reverted
            x /= 10; // Elimina el último dígito de x
        }
        return x == reverted || x == reverted / 10; // Compara la parte no revertida con la parte revertida (ajustando para números impares)
    }
}
