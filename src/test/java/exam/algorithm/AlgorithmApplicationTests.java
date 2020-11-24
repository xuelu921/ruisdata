package exam.algorithm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlgorithmApplicationTests {

    @Test
    void testMyQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println("队列是否为空： " + myQueue.empty());
        System.out.println("队列首位元素： " + myQueue.peek());
        System.out.println("队列首位元素并已移除： " + myQueue.pop());
        System.out.println("此时队列首位元素为： " + myQueue.peek());
    }

    @Test
    void testTrie() {
        Trie trie = new Trie();
        trie.insert("apple");

        System.out.println("搜索单词apple是否存在的结果为： " + trie.search("apple"));
        System.out.println("搜索单词app是否存在的结果为： " + trie.search("app"));
        System.out.println("搜索单词前缀app是否存在的结果为： " + trie.startsWith("app"));
    }

}
