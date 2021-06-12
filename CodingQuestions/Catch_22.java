import java.util.Scanner;

public class Catch_22 {

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int N,F,B,T,FD,BD,step=0,time=0,sd,nstep=0,pos;
        N = sc.nextInt();
        while(N-- != 0){
            F = Integer.parseInt(sc.next());
            B = Integer.parseInt(sc.next());
            T = Integer.parseInt(sc.next());
            FD = Integer.parseInt(sc.next());
            BD = Integer.parseInt(sc.next());
            step = F - B;
            if(FD <= F){
                System.out.println(FD*T+" F");
                continue;
            }
            if(BD <= B){
                System.out.println(BD*T+" B");
                continue;
            }
            if(step == 0 ){
                System.out.println("No Ditch");
                continue;
            }
            nstep = time = pos = 0;
            if(step > 0){
                while ((pos + F) < FD){
                    pos += step;
                    nstep++;
                }
                    time = nstep * ((F+B)*T);
                    time += (FD-pos)*T;
                System.out.println(time + " F");
            }
            else{
                step = (-step);
                nstep = BD / step;
                if(BD % step == 0){
                    time = nstep * (F+B)*T;
                }
                else{
                    time = nstep * (F+B)*T + (2*F + BD%step)*T;
                }
                System.out.println(time + " B");
            }

        }
    }
}
