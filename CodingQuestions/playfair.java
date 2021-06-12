import java.lang.*;
import java.util.*;
class playfair
{
	public static void main(String []args)
	{
		String key,plaintext;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Key : ");
		key=sc.next();
		int klen,i,j,index,flag=0,asc,ff,fd=0,ij=0;
		char mat[][]=new char[5][5];
		klen=key.length();
		for(asc=97,index=0,i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
			{
				flag=0;
				while(flag==0)
				{
					if(index<klen)
					{
						if(key.charAt(index)=='i' || key.charAt(index)=='j')
						{
							if(ij==0)
							{
								mat[i][j]='i';
								index++;
								flag=1;
								ij=1;
							}
							else
							{
								index++;
								continue;
							}							
						}
						else
						{
							mat[i][j]=key.charAt(index);
							index++;
							flag=1;
						}
					}
					else
					{
						fd=0;
						for(ff=0;ff<klen;ff++)
						{
							if(key.charAt(ff)==(char)asc)
							{
								fd=0;
								break;
							}
							else
							{
								fd=1;
							//	continue;
							}
						}
						if(fd==0)
						{
							asc++;
							continue;
						}
						else 
						{
							if((char)asc=='i' || (char)asc=='j')
							{
								if(ij==0)
								{
									mat[i][j]='i';
									asc++;
									flag=1;
									ij=1;
									continue;
								}
								else
								{
									asc++;
									continue;
								}
							}
							else
							{

								mat[i][j]=(char)asc;
								asc++;
								flag=1;
							}
						}
					}
				}
				System.out.print(" "+mat[i][j]);
			}
			System.out.println("");
		}
		System.out.println("Matrix will be : ");
		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.println("");
		}
		System.out.println("Enter Plain Text : ");
		plaintext=sc.next();
		String pt;
		int nchar;
		char ch;
		klen=plaintext.length();
		System.out.println("Length : "+klen);
		if(klen%2==1)
		{
			klen--;
			ch=plaintext.charAt(klen);
			if(ch=='x')
				nchar=122;
			else
				nchar=120;
			pt=plaintext+(char)nchar;
//			plaintext[++klen]=(char)nchar;
		}
		else
			pt=plaintext;
		klen=pt.length();
		char nst[]=new char[klen+10];
		for(i=0,j=0;i<klen;i=i+2)
		{
			nst[j]=pt.charAt(i);
			if(pt.charAt(i)==pt.charAt(i+1))
			{
				j++;
				nst[j]='x';
				i--;
			}
			j++;
			//nst[j]=pt.charAt(i+1);
		}
				
		System.out.println("   "+nst);
		//for(i=0;i<)
	}
}