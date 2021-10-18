import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BT {
    Node head = null;
    
    public void insert(int value) {
        if (head == null) {
            head = new Node(value, null, null);
            return;
        }
        Node i = head;
        while ((i.left != null && i.value > value) || (i.right != null && i.value < value)) {
            if (i.value > value) i = i.left;
            else i = i.right;
        }
        if (i.value > value) i.left = new Node(value, null, null);
            else i.right = new Node(value, null, null);
    }

    public void print(Node i) {
        if (i == null) return;
        print(i.left);
        System.out.print(i.value + " ");
        print(i.right);
    }

    public void show() {
        print(head);
    }

    public static void main(String[] args) {
        BT a = new BT();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++)
            a.insert(sc.nextInt());
        sc.close();
        
        a.show();
    }
}