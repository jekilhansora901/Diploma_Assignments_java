public class exception{

    public static void main(String Args[]){
        int[] array = new int[3];

       try{           

          for(int i=2;i>=0;i--){

                array[i] = i;
                System.out.println("Division :- "+(2/array[i]));

           }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Oops, we went to far, better go back to 0!");
        }
        catch(ArithmeticException e){

            System.out.println("Cannot Divide by Zero!");

            //method call to continue program

        }

        finally{

            System.out.println("array");

            //method call to continue program  

        }

    }

}
