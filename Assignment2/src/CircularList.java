// a single node of the list
class Node {
private int value;
private Node next;
// Node constructor
public Node(int i) {
value = i; // initialize value
next = null; // no next node
}
// print value stored in this node
public void print() {
System.out.println(value);
}
// get handle to next node
public Node next() {
return next;
}
// set the next node
public void setNext(Node n) {
next = n;
}
}
// define the circular list in Figure 1-12
class CircularList {
public static void main(String argv[]) {
Node a; // declare nodes
Node b;
Node c;
a = new Node(1); // allocate nodes
b = new Node(2);
c = new Node(3);
a.setNext(b); // create circular list
b.setNext(c);
c.setNext(a);
Node i;
i = a;
while (i != null) { // print circular list
i.print(); // print value in node i
i = i.next(); // set i to next node
}
}
}