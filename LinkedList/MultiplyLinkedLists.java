
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MultiplyLinkedLists {

    /*
        Converts linked list into number

        Example:
        1 -> 2 -> 3

        Number formed:
        123
    */
    public static long getNumber(Node head) {

        long num = 0;

        Node temp = head;

        while (temp != null) {

            /*
                Shift digits left
                and add current digit

                Example:
                12 becomes 120
            */
            num = (num * 10) + temp.data;

            temp = temp.next;
        }

        return num;
    }

    /*
        Multiplies two linked lists
    */
    public static long multiplyTwoLists(Node head1, Node head2) {

        /*
            Convert first linked list
            into number
        */
        long num1 = getNumber(head1);

        /*
            Convert second linked list
            into number
        */
        long num2 = getNumber(head2);

        /*
            Multiply numbers
        */
        return num1 * num2;
    }

    /*
        Main function
    */
    public static void main(String[] args) {

        /*
            First number:
            1 -> 0 -> 0

            Represents 100
        */
        Node head1 = new Node(1);

        head1.next = new Node(0);
        head1.next.next = new Node(0);

        /*
            Second number:
            1 -> 0

            Represents 10
        */
        Node head2 = new Node(1);

        head2.next = new Node(0);

        /*
            Multiply numbers
        */
        long result = multiplyTwoLists(head1, head2);

        System.out.println("Product = " + result);
    }
}