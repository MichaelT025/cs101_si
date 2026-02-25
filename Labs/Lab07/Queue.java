// Simple queue implementation storing Object
public class Queue {
    private Object[] data;
    private int front;
    private int rear;
    private int size;
    public Queue() {
        data = new Object[100];
        front = 0;
        rear = 0;
        size = 0;
    }
    public void enqueue(Object obj) {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(front + i) % data.length];
            }
            data = newData;
            front = 0;
            rear = size;
        }
        data[rear] = obj;
        rear = (rear + 1) % data.length;
        size++;
    }
    public Object dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        Object obj = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return obj;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
