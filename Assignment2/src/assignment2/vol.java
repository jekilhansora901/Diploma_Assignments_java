package assignment2;
public class vol {
    double width;
    double height;
    double depth;
    vol(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
    vol() {
        width = height = depth = 1;
    }
    vol(double len) {
        width = height = depth = len;
    }
    double volume() {
        return (width * height * depth);
    }
    public static void main(String[] args) {
        vol a1 = new vol(10,20,15);
        vol a2 = new vol();
        vol a3 = new vol(7);
        System.out.println("Volume of A1 : "+a1.volume());
        System.out.println("Volume of A2 : "+a2.volume());
        System.out.println("Volume of A3 : "+a3.volume());
    }
}
