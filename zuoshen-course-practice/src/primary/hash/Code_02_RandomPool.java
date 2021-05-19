package primary.hash;

import java.util.HashMap;
import java.util.Map;

public class Code_02_RandomPool {
    /**
     * 设计RandomPool结构
     * 【 题目】 设计一种结构， 在该结构中有如下三个功能：
     * insert(key)： 将某个key加入到该结构， 做到不重复加入。
     * delete(key)： 将原本在结构中的某个key移除。
     * getRandom()：等概率随机返回结构中的任何一个key。
     * 【 要求】 Insert、 delete和getRandom方法的时间复杂度都是O(1)
     */

    public static class Pool<T>{
        private HashMap<T, Integer> keyIndexMap;
        private HashMap<Integer, T> indexKeyMap;
        private int size;

        public Pool(){
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(T key){
            if (!keyIndexMap.containsKey(key)){
                keyIndexMap.put(key, this.size);
                indexKeyMap.put(this.size++, key);
            }
        }

        public void delete(T key){
            if (this.keyIndexMap.containsKey(key)){
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                T lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }

        }

        public T getRandom(){
            if (!keyIndexMap.isEmpty()){
                int randomIndex = (int) (Math.random() * this.size);
                T key = this.indexKeyMap.get(randomIndex);
                return key;
            }
            return null;
        }
    }
    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

        Map<String, Integer> map = new HashMap<>();
        map.put("z",10);
        map.put("z",11);
        System.out.println(map.get("z"));

    }
}
