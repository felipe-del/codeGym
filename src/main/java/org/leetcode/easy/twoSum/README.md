# Two Sum - Easy

## Descripción del problema
Dado un array de enteros `nums` y un entero `target`, retorna los **índices de los dos números** que sumen `target`.  
Cada entrada tiene exactamente **una solución**, y no puedes usar el mismo elemento dos veces.

### Ejemplos

```text
Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Input: nums = [3,2,4], target = 6
Output: [1,2]

Input: nums = [3,3], target = 6
Output: [0,1]
```

### Restricciones
- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Solo existe **una solución válida**

---

## Soluciones implementadas

### Solution1 - Brute-force (O(n²))
- Doble bucle para probar todas las combinaciones posibles.
- Fácil de entender, pero lento para arrays grandes.

### Solution2 - Optimizada (O(n))
- Usa un **HashMap** para almacenar números y sus índices.
- Recorre el array una sola vez y verifica si el complemento (`target - nums[i]`) ya está en el mapa.

---

## Tests
Tests unitarios con JUnit 5 para ambas soluciones, cubriendo:

- Casos normales
- Casos borde (edge cases), como arrays mínimos, negativos, repetidos y extremos

---

### Notas
- Parte del proyecto **LeetCode exercises**
- Estructura lista para agregar nuevos ejercicios fácilmente.