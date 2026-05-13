//Given a pointer to a node to be deleted, delete the node. Note that we don’t have a pointer to the head node.


class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteGivenNode {

    static void deleteNode(Node delNode) {

        /*
            Cannot delete if:
            1. Node is null
            2. Node is last node
        */
        if (delNode == null || delNode.next == null) {
            return;
        }

        /*
            Store next node
        */
        Node temp = delNode.next;

        /*
            Copy next node's data
            into current node
        */
        delNode.data = temp.data;

        /*
            Skip next node
        */
        delNode.next = temp.next;

        /*
            Disconnect deleted node
        */
        temp.next = null;
    }

    /*
        Print linked list
    */
    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    /*
        Main function
    */
    public static void main(String[] args) {

        /*
            Creating linked list:
            10 -> 20 -> 4 -> 30
        */
        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(4);
        head.next.next.next = new Node(30);

        System.out.println("Original Linked List:");
        printList(head);

        /*
            Node to delete = 20
        */
        Node delNode = head.next;

        deleteNode(delNode);

        System.out.println("\nLinked List After Deletion:");
        printList(head);
    }
}