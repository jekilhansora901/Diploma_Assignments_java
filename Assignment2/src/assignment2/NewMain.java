
package assignment2;
//CREATING A THREAD USING A THREAD CLASS
import java.lang.Thread;
import java.io.*;
class A extends Thread

{

public void run()
{
for(int i=1;i<=5;i++)
{
System.out.println("\t From thread A:"+i);
}
System.out.println("Exit from A");
}

}

class B extends Thread

{

public void run( )

{

for(int j=1;j<=5;j++)

{

System.out.println("\t From thread  b: j="+j);

}

System.out.println("Exit from B");

}

}

 

class C extends Thread

{

public void run( )

{

for(int k=1;k<=5;k++)

{

System.out.println("\t From thread C: k="+k);

}

System.out.println("Exit from c");

}

}

class threadTest

{

public static void main(String args[ ])

{

new A( ).start( );

new B( ).start( );

new C( ).start( );

}

} 