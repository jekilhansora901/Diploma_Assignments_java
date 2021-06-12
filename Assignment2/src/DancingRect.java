import java.applet.*;
import java.awt.*;
class DancingRect {
// instance variables:
int locx, locy; // (locx,locy) are coordinates of upper
// left corner of rectangle
int width, height; // width and height of rectangle
Color myColor; // color of rectangle
/////////////////////////////////////////////////////////////////
// constructor
public DancingRect(int locx,int locy,int width,int height,Color myColor) {
this.locx = locx;
this.locy = locy;
this.width = width;
this.height = height;
this.myColor = myColor;
}
// methods:
public void danceStep() {
// does nothing
}public void paint(Graphics g) {
g.setColor(myColor);
g.fillRect(locx,locy,width,height);
}
}