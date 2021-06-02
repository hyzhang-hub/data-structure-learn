package advanced.class01;

import java.util.HashMap;
import java.util.HashSet;

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
        public HashMap<T, Integer> keyIndexMap;
        public HashMap<Integer, T> indexKeyMap;
        public int size;

        public Pool(){
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(T key){
            if (!keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }

        public void delete(T key){
            if (this.keyIndexMap.containsKey(key)){
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --this.size;
                T lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        public T getRandom(){
            if (this.size == 0){
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size);
            return indexKeyMap.get(randomIndex);
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

        }
    }

}
