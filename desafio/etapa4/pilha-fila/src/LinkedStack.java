public class LinkedStack<E> implements Stack<E> {
    private Node T;
    private int size;

    public LinkedStack() {
        T = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return T == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(T);
        T = newNode;
        size++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Stack is empty.");
        }
        Object data = T.getData();
        T = T.getNext();
        size--;
        return (E) data;
    }

    @Override
    public Object top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Stack is empty.");
        }
        return T.getData();
    }
}