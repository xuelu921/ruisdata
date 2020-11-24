package exam.algorithm;

class Trie {
    //根节点
    private TrieNode root;

    public Trie() {
        //初始化根节点
        root = new TrieNode();
    }

    /**
     * 前缀树中插入单词
     *
     * @param word word
     */
    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    /**
     * 在前缀树中查询单词
     *
     * @param word word
     * @return boolean
     */
    public boolean search(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        //匹配完整性
        return node.item.equals(word);
    }

    /**
     * 在前缀树中查询单词前缀，存在返回true，否则false
     *
     * @param prefix prefix
     * @return boolean
     */
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;

    }

    //前缀树节点结构
    class TrieNode {
        //孩子节点，分别记录26个字母
        TrieNode[] children = new TrieNode[26];
        //叶子结点对应的单词，中间默认为空字符串
        String item = "";
    }
}
