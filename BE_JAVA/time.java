class time
{
	int hour,minut,second;
	time()
	{
		hour=minut=second=0;
	}
	time(int h,int m,int s)
	{
		hour=h;
		minut=m;
		second=s;
	}
	time sum(time t2)
	{
		time t3=new time();
		int s,m,h;
		s=second+t2.second;
		t3.second=s%60;
		s=s/60;
		m=minut+t2.minut+s;
		t3.minut=m%60;
		m=m/60;
		h=hour+t2.hour+m;
		t3.hour=h%60;
		return t3;
	}
	void showTime()
	{
		System.out.println(" "+hour+" : "+minut+" : "+second);
	}
	public static void main(String s[])
	{
		time t1=new time(1,55,55);
		time t2=new time(2,15,15);
		time t3=new time();
		t3=t1.sum(t2);
		t3.showTime();
	}
}
		
		