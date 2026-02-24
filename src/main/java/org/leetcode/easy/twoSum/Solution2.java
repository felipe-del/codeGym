package org.leetcode.easy.twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];                       // Número actual
            int complement = target - num;           // Número que necesitamos

            if (map.containsKey(complement)) {       // Si ya vimos el complemento
                return new int[]{map.get(complement), i}; // Devolvemos los índices
            }

            map.put(num, i);                         // Guardamos el número actual
        }

        return new int[0]; // Nunca debería ocurrir por restricción
    }
}
