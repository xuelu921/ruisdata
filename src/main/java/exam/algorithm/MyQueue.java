package exam.algorithm;

import java.util.LinkedList;

/**
 * @author Administrator
 */
public class MyQueue {
    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    //入队列时全部入堆栈1
    public void push(int node) {
        stack1.push(node);
    }

    //出队列时将不为空的堆栈1全部弹出入堆栈2；再弹出堆栈2
    public int pop() {
        if(stack2.isEmpty()){
            if (stack1.isEmpty()) {
                throw new IndexOutOfBoundsException("queue has no element!");
            }
            while(stack1.size() != 0){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }
    }

    public int peek() {
        if(stack2.isEmpty()){
            if (stack1.isEmpty()) {
                throw new IndexOutOfBoundsException("queue has no element!");
            }
            while(stack1.size() != 0){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }else{
            return stack2.peek();
        }
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
