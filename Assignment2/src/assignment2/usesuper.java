package assignment2;
class Boxx {
    double width,height,depth,volume;
    Boxx(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
    void calcdisp()
    {
        volume= width * height * depth;
        System.out.println("Width : "+width+" Height : "+height+" Depth : "+depth);
        System.out.println("Volume : "+volume);
    }
}
public class usesuper extends Boxx{
    
        usesuper(double a , double b , double c)
        {
            super(a,b,c);
        }
    public static void main(String[] args) {
        usesuper a = new usesuper(10,10,20);
        a.calcdisp();
    }
}
