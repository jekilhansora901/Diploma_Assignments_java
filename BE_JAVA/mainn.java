abstract class shape
{
	double area;
	abstract void calc_area();
	abstract void displayy();
}
class rect extends shape
{
	int w,d;
	rect(int a,int b)
	{
		w=a;
		d=b;
	}
	void calc_area()
	{
		area=w*d;
	}
	void displayy()
	{
		System.out.println("Area of Rectangle : "+area);
	}
}
class tri extends shape
{
	int b,v;
	tri(int a,int d)
	{
		b=a;
		v=d;
	}
	void calc_area()
	{
		area=(b*v)/2;
	}
	void displayy()
	{
		System.out.println("Area of Triangle : "+area);
	}
}
class circle extends shape
{
	int r;
	circle(int a)
	{
		r=a;
	}
	void calc_area()
	{
		area=r*r*3.14;
	}
	void displayy()
	{
		System.out.println("Area of Circle : "+area);
	}
}
class mainn
{
	public static void main(String [] ar)
	{
		shape s;
		rect r=new rect(10,10);
		tri t=new tri(10,10);
		circle c=new circle(10);
		s=r;
		s.calc_area();
		s.displayy();
		s=t;
		s.calc_area();
		s.displayy();
		s=c;
		s.calc_area();
		s.displayy();
	}
}
	