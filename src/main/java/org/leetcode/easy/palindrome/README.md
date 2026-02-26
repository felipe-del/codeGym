# Palindrome Number - Easy

## Descripción del problema

Dado un número entero `x`, retorna **true** si `x` es un palíndromo y false en caso contrario.
Un palíndromo es un número que se lee igual de izquierda a derecha que de derecha a izquierda.

### Ejemplos

```text
Input: x = 121
Output: true
Explicación: 121 se lee igual de izquierda a derecha y de derecha a izquierda.

Input: x = -121
Output: false
Explicación: -121 se lee como 121- de derecha a izquierda. No es un palíndromo.

Input: x = 10
Output: false
Explicación: Se lee como 01 de derecha a izquierda. No es un palíndromo.
```

### Restricciones
- `-2^31 <= x <= 2^31 - 1`

### Mejoras
- ¿Se puede resolver sin convertir el número a string?

---

## Soluciones implementadas

### Solution1 - Conversión a String (O(n))
- Convierte el número a string y verifica si es igual a su reverso.
- Fácil de entender, pero utiliza espacio extra para el String reverso.

### Solution2 - Sin conversión (O(log10(n)))
- Invierte solo la mitad del número y compara con la otra mitad.
- Evita usar espacio extra y es más eficiente.
- Maneja números negativos y casos especiales como múltiplos de 10.

---

## Tests
Tests unitarios con JUnit 5 para ambas soluciones, cubriendo:
- Casos normales (palíndromos positivos)
- Casos borde (negativos, múltiplos de 10, números de un solo dígito)
- Casos grandes dentro del rango permitido