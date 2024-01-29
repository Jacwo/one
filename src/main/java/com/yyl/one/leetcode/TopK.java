package com.yyl.one.leetcode;

/**
 * @Author yangyuanliang
 * @Date 2024/1/29 16:00
 * @Version 2.0
 **/
public class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 根据 value 进行排序
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (a, b) -> {
            return b.getValue() - a.getValue();
        });

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
