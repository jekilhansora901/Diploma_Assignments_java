abstract class shape
{
	abstract void area();
}
class tri extends shape
{
	int p,v;
	tri(int a,int b)
	{
		p=a;
		v=b;
	}
	void area()
	{
		System.out.println("Area Of Triangle : "+((p*v)/2));
	}
}
class rect extends shape
{
	int l,w;
	rect(int a,int b)
	{
		l=a;
		w=b;
	}
	void area()
	{
		System.out.println("Area Of Rectangle : "+(l*w));
	}
}
class cir extends shape
{
	int r;
	cir(int a)
	{
		r=a;
	}
	void area()
	{
		System.out.println("Area Of Circle : "+(3.14*r*r));
	}
}	
class testi
{
	public static void main(String d[])
	{
		shape s;
		tri t=new tri(10,20);
		rect r=new rect(20,30);
		cir c=new cir(10);
		s=t;
		s.area();
		s=r;
		s.area();
		s=c;
		s.area();
	}
}
	