# Ejercicios Lógicos - Java

Este proyecto contiene ejercicios resueltos de LeetCode y librerias de Java, organizados por **dificultad** y con **tests unitarios
** para cada ejercicio.

---

## Estructura del proyecto

```txt
leetcode-exercises/
├─ src/
│  ├─ main/java/org/leetcode/easy/       # Ejercicios fáciles
│  ├─ main/java/org/leetcode/medium/     # Ejercicios medios
│  ├─ main/java/org/leetcode/hard/       # Ejercicios difíciles
│  └─ test/java/org/leetcode/...         # Tests unitarios JUnit 5
├─ pom.xml                               # Configuración Maven y dependencias
└─ README.md                             # Este archivo
```

---

## Índice de ejercicios

### Easy

- [Two Sum](src/main/java/org/leetcode/easy/twoSum/README.md) - Encuentra dos números que sumen un target.
- (Agregar más ejercicios aquí)

### Medium

- (Agregar ejercicios medios aquí)

### Hard

- (Agregar ejercicios difíciles aquí)

---

## Cómo compilar y ejecutar tests

1. Compilar:
   ```bash
   mvn compile
   ```

2. Ejecutar tests:
   ```bash
   mvn test
   ```

Todos los tests están en `src/test/java/org/leetcode/...` organizados por dificultad y nombre del ejercicio.

---

## Notas

- Cada ejercicio tiene **solución y test separados**.
- Puedes agregar nuevos ejercicios siguiendo la misma estructura.
- Los tests incluyen **edge cases** y casos normales para validar todas las soluciones.

---

_Isaac Brenes_