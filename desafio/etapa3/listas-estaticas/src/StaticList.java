import java.util.Scanner;

public class StaticList<E> implements List<E> {
    private E[] elements;
    private int size;
    private int capacity;

    public StaticList(int capacity) {
        this.capacity = capacity;
        this.elements = (E[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public void insert(E element, int pos) {
        if (pos < 0 || pos > size || isFull()) {
            throw new IndexOutOfBoundsException("Posição inválida ou a lista está completamente cheia :/");
        }
        for (int i = size; i > pos; i--) {
            elements[i] = elements[i - 1];
        }
        elements[pos] = element;
        size++;
    }

    @Override
    public E remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida :(");
        }
        E removedElement = elements[pos];
        for (int i = pos; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removedElement;
    }

    @Override
    public E get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida :(");
        }
        return elements[pos];
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int contaElementos(E el) {
        return contaElementosRec(el, 0);
    }

    private int contaElementosRec(E el, int index) {
        if (index == size) {
            return 0;
        }
        int count = elements[index].equals(el) ? 1 : 0;
        return count + contaElementosRec(el, index + 1);
    }

    public static void main(String[] args) {
        StaticList<Integer> list = new StaticList<>(10);
        Scanner scanner = new Scanner(System.in);

        // recebendo numeros para a lista
        System.out.println("Insira 5 elementos na lista:");
        for (int i = 0; i < 5; i++) {
            int element = scanner.nextInt();
            list.insert(element, i);
        }

        // recebendo os elementos para contagem
        System.out.println("Insira um elemento para contar suas ocorrências:");
        int el = scanner.nextInt();

        // contagem de elementos
        int count = list.contaElementos(el);
        System.out.println("O elemento " + el + " aparece " + count + " vezes na lista.");

        scanner.close();
    }
}
