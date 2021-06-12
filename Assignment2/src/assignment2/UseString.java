package assignment2;
class UseString
{
    public static void main(String args[])
    {
        String s1 = "Computer";
        String s2 = " Engineer";
        char character='o';
        int pos = s1.indexOf(character);
        System.out.println("String s1 : "+s1);
        System.out.println("String s2 :"+s2);
        System.out.println("Length of the String 1 : "+s1.length());
        System.out.println("Is s1 is equal to s2 : "+(s1.equals(s2)));               //Compare()
        System.out.println("Concatenation of s1 and s2 is : "+(s1.concat(s2)));     //Concat()
        System.out.println("Character at num 5 pos in s1 : "+s1.charAt(5));                       //charAt()
        System.out.println("The 'o' is  : "+ pos +" character index position  in "+s1);                      //indexOf()
        System.out.println("New String from string1("+s1+") with 'C' replacesd by 'K' is : "+s1.replace('C', 'K'));      //Replace()
        System.out.println("Converting "+s1+" to lowercase : "+s1.toLowerCase());                    //toUpper()
        System.out.println("Converting "+s2+" to Uppercase : "+s2.toUpperCase());             //toLower()
	}
}
