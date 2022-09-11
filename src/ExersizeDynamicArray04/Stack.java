package ExersizeDynamicArray04;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 11:54
 */
public class Stack {
    // Указатель на вершину стека
    private Node head;
    // Узел
    private Node node;


    public Stack() {
    }

    // значение в обёртке
    private class Node {
        private int value; // сам элемент
        private Node prev; // ссылка на элемент, ниже в стеке

        public Node(int value, Node prev) {
            this.value = value;
            this.prev = prev;
        }

    }

    // метод добавления элемента в стек
    public void push(int value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            node = new Node(value, head);
            head = node;

        }
    }

    // метод съёма элемента со стека
    public int pop() {
        if (head == null) return -1;
        else {
            int value = head.value;
            head = head.prev;
            return value;
        }


    }

    // метод вывода стека на экран
    public void printme() {
        if (head == null) System.out.println("EMPTY");
        else {
            node = head;

            while (node != null) {
                System.out.print(node.value);
                if (node.prev != null) {
                    System.out.print(" -> ");
                }

                node = node.prev;

            }
            System.out.println();
        }

    }

}

