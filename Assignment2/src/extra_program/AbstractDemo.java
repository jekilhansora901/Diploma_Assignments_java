
package extra_program;
abstract class A {
abstract void callme();
void callmetoo() {
System.out.println("This is a Local method in Class A.");
}
}
class B extends A {
void callme() {
System.out.println("B's implementation of callme.");
}
}
class AbstractDemo {
public static void main(String args[]) {
B b = new B();
b.callme();
b.callmetoo();
}
}