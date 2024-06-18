import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStack<Integer> stack = new LinkedStack<>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println("Digite os números para a pilha e fila (digite -1 para parar):");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            stack.push(num);
            queue.enqueue(num);
        }

        // teste da pilha
        System.out.println("***********PILHA*********************");
        System.out.println("Topo da pilha: " + stack.top());
        System.out.println("Elementos na pilha: " + stack.numElements());
        System.out.println("Desempilhando: " + stack.pop());
        System.out.println("Topo da pilha: " + stack.top());
        System.out.println("*************************************");
        System.out.println("                                     ");

        // teste da fila
        System.out.println("*************FILA********************");
        System.out.println("Primeiro na fila: " + queue.front());
        System.out.println("Último na fila: " + queue.back());
        System.out.println("Elementos na fila: " + queue.numElements());
        System.out.println("Desenfileirando: " + queue.dequeue());
        System.out.println("Primeiro na fila: " + queue.front());
        System.out.println("*************************************");

        scanner.close();
    }
}
