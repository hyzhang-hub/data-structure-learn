package primary.trieTree;

public class Code_01_TrieTree {
    public static class TrieNode {
        public int path;  //有多少字符串到达
        public int end;   //有多少字符串以该字符结尾
        public TrieNode[] nexts;  //有多少条路可以走

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        //插入字符串
        public void insert(String word){
            if (word == null){
                return;
            }

            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        //删除字符串
        public void delete(String word){
            if (search(word) != 0){
                char[] chars = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    System.out.println(index);
                    if (--node.nexts[index].path == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }

        }

        public int search(String word){
            if (word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre){
            if (pre == null){
                return 0;
            }

            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }




    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }
}
