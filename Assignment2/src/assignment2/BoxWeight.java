package assignment2;
class Box {
    double width,height,depth,volume;
    void getdata(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
    void calcdisp()    {
        volume= width * height * depth;
        System.out.println("Width : "+width+" Height : "+height+" Depth : "+depth);
        System.out.println("Volume : "+volume);
    }
}
class BoxWeight extends Box{

    public static void main(String[] args) {
        BoxWeight b = new BoxWeight();
        b.getdata(10, 20, 30);
        b.calcdisp();
    }
}
