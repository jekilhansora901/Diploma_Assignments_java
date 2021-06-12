import java.applet.*;
import java.awt.*;
/////////////////////////////////////////////////////////////////
public class MouseTest extends Applet {
public boolean mouseDown(Event e,int x,int y) {
System.out.println("mouseDown at (" + x + "," + y + ")" );
return true;
}
public boolean mouseUp(Event e,int x,int y) {
System.out.println("mouseUp at (" + x + "," + y + ")" );
return true;
}
public boolean mouseMove(Event e,int x,int y) {
System.out.println("mouseMove at (" + x + "," + y + ")" );return true;
}
public boolean mouseDrag(Event e,int x,int y) {
System.out.println("mouseDrag at (" + x + "," + y + ")" );
return true;
}
public boolean mouseEnter(Event e,int x,int y) {
System.out.println("mouseEnter at (" + x + "," + y + ")" );
return true;
}
public boolean mouseExit(Event e,int x,int y) {
System.out.println("mouseExit at (" + x + "," + y + ")" );
return true;
}
}