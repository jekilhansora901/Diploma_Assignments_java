
class rectangle
{
	int length,width,p,a;
	rectangle()
	{
		length=width=1;
	}
	rectangle(int s,int d)
	{
		length=s;
		width=d;
	}
	void perimeter()
	{
		p=2*length*width;
		System.out.println("Perimeter : "+p);
	}
	void area()
	{
		a=length*width;
		System.out.println("Area : "+p);
	}
	void setLength(int aa)
	{
		length=aa;
	}
	void setWidth(int aa)
	{
		width=aa;
	}
	int getLength()
	{
		return length;
	}
	int getWidth()
	{
		return width;
	}
	public static void main(String sd[])
	{
		rectangle r=new rectangle();
		r.setLength(50);
		r.perimeter();
		r.area();
		int w=r.getWidth();
		System.out.println("Width : "+w);
		rectangle rr=new rectangle(10,10);
		rr.perimeter();
		rr.area();
	}
}