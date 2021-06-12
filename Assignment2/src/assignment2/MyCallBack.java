package assignment2;
interface Callback {
    void callback(int param);
}
class Client implements Callback {
    public void callback(int p) {
        System.out.println("callback called with " + p);
    }
}
class AnotherClient implements Callback {
    public void callback(int p) {
        System.out.println("Another version of callback");
        System.out.println("The Squre of "+p+" is " + (p*p));
    }
}
class MyCallBack {
    public static void main(String args[]) {
        Callback c = new Client();
        AnotherClient ob = new AnotherClient();
        c.callback(10);
        c = ob;
        c.callback(25);
    }
}