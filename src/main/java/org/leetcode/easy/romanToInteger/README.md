# Roman to Integer - Easy

## Descripción del Problema

Los números romanos están representados por siete símbolos diferentes:  
`I`, `V`, `X`, `L`, `C`, `D` y `M`.

| Símbolo | Valor |
|---------|-------|
| I       | 1     |
| V       | 5     |
| X       | 10    |
| L       | 50    |
| C       | 100   |
| D       | 500   |
| M       | 1000  |

Por ejemplo:

- 2 se escribe como `II` (1 + 1)
- 12 se escribe como `XII` (10 + 1 + 1)
- 27 se escribe como `XXVII` (10 + 10 + 5 + 1 + 1)

Normalmente, los números romanos se escriben de mayor a menor de izquierda a derecha.

Sin embargo, hay casos especiales donde se utiliza **sustracción** en lugar de suma.

---

## Casos de Sustracción

Existen seis combinaciones donde se resta:

- `I` antes de `V` (5) y `X` (10) → 4 (`IV`) y 9 (`IX`)
- `X` antes de `L` (50) y `C` (100) → 40 (`XL`) y 90 (`XC`)
- `C` antes de `D` (500) y `M` (1000) → 400 (`CD`) y 900 (`CM`)

---

## Objetivo

Dado un número romano representado como un string `s`, convertirlo a su equivalente entero.

---

## Ejemplos

### Example 1

```
Input: s = "III"
Output: 3
Explanation: III = 1 + 1 + 1 = 3
```

### Example 2

```
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V = 5, III = 3
Total = 50 + 5 + 3 = 58
```

### Example 3

```
Input: s = "MCMXCIV"
Output: 1994
Explanation:
M = 1000
CM = 900
XC = 90
IV = 4
Total = 1994
```

---

## Restricciones

- `1 <= s.length <= 15`
- `s` contiene únicamente los caracteres:
  ```
  ('I', 'V', 'X', 'L', 'C', 'D', 'M')
  ```
- Se garantiza que `s` es un número romano válido en el rango:
  ```
  [1, 3999]
  ```

---

## Notas

- El string siempre será válido.
- No necesitas validar combinaciones inválidas.
- El enfoque típico usa un `Map<Character, Integer>` y recorre el string comparando el valor actual con el siguiente.

---

## Complejidad Esperada

- Tiempo: **O(n)**
- Espacio: **O(1)** (solo 7 símbolos posibles)