import java.applet.*;
import java.awt.*;
// rebuilt Mondrian with objects
public class Mondrian extends Applet {
static final int NUM_RECTS = 9;
DancingRect r[]; // array of dancing rectangles
public void init() {
System.out.println(">> init <<");
setBackground(Color.black);
initRectangles();
}
public void initRectangles() {
// allocate dancing rectangles
// now the data is encapsulated by the objects!
r = new DancingRect[NUM_RECTS];r[0] = new DancingRect(0,0,90,90,Color.yellow);
r[1] = new DancingRect(250,0,40,190,Color.yellow);
r[2] = new DancingRect(200,55,60,135,Color.yellow);
r[3] = new DancingRect(80,200,220,90,Color.blue);
r[4] = new DancingRect(100,10,90,80,Color.blue);
r[5] = new DancingRect(80,100,110,90,Color.lightGray);
r[6] = new DancingRect(200,0,45,45,Color.red);
r[7] = new DancingRect(0,100,70,200,Color.red);
r[8] = new DancingRect(200,55,60,135,Color.magenta);
}
public void start() {
System.out.println(">> start <<");
}
public void paint(Graphics g) {
for (int i=0; i<NUM_RECTS; i++) {
r[i].paint(g); // paint each rectangle
}
}
public void stop() {
System.out.println(">> stop <<");
}
}