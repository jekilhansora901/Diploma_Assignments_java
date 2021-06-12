import java.util.*;
import java.lang.*;
class ceaser_cipher
{
	public static void main(String arg[])
	{
		Scanner s=new Scanner(System.in);
		String plain,cipher;
		int k;
		System.out.println("Enter Plain Text : ");
		plain=s.next();
		System.out.println("Enter Key : ");
		k=s.nextInt();
		cipher="";
		for(int i=0;i<plain.length();i++)
		{
			int ch=plain.charAt(i);
			if(ch>=65 && ch<=90)
			{
				ch+=k;
				if(ch>90)
				{
						int r=ch-90;
						ch=64+r;
				}
			}
			else if(ch>96)
			{
					ch+=k;
					if(ch>122)
					{
							int r=ch-122;
							ch=96+r;
					}
			}
			cipher=cipher+(char)ch;
		}
		System.out.println("Cipher Text : "+cipher);
		plain="";
		for(int i=0;i<cipher.length();i++)
		{
			int ch=cipher.charAt(i);
			if(ch>64 && ch<91)
			{
				ch-=k;
				if(ch<65)
				{
					int r=65-ch;
					ch=90-r;
				}
			}
			else if(ch>96)
			{
				ch-=k;
				if(ch<97)
				{
					int r=97-ch;
					ch=122-r;
				}
			}
			plain+=(char)ch;
		}
		System.out.println("Plain Text : "+plain);
	}
}