// Simple stack implementation storing Object
public class Stack {
    private Object[] data;
    private int top;
    public Stack() {
        data = new Object[100];
        top = -1;
    }
    public void push(Object obj) {
        if (top == data.length - 1) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[++top] = obj;
    }
    public Object pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        Object obj = data[top];
        data[top--] = null;
        return obj;
    }
    public Object peek() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return data[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
}
