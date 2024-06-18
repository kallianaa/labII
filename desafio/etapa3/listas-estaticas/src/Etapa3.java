import java.util.Stack;
import java.util.Scanner;

public class Etapa3 {

    public boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> stack = new Stack<>();
        while (!s1.isEmpty()) {
            char ch = s1.pop();
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Etapa3 etapa3 = new Etapa3();
        Scanner scanner = new Scanner(System.in);

        // pedindo informações para o usuario atraves do teclado
        System.out.println("Insira uma expressão matemática:");
        String expressao = scanner.nextLine();

        // pilha
        Stack<Character> s1 = new Stack<>();
        for (int i = expressao.length() - 1; i >= 0; i--) {
            s1.push(expressao.charAt(i));
        }

        // aqui o metodo verifica os parênteses
        boolean valido = etapa3.checkBrackets(s1);
        System.out.println("A expressão é " + (valido ? "válida ;-)" : "inválida >:("));

        scanner.close();
    }
}
