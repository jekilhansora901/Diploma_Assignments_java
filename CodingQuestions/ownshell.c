#include<stdio.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<sys/wait.h>
#include<fcntl.h>
#include<string.h>

int main(int argc,char *argv[])
{
    int ampr=0;
    int fd,rid;
    int fds[2];
    int status;
    //char arr[2]="&";
   printf("\n%s  %s %s\n",argv[1],argv[2],argv[3]);
   printf("\n%d\n",argc);
   if(strcmp(argv[4],"&")==0)
    {   printf("Starting In if &\n");
        ampr=1;
    }
    
    if(fork()==0)
        {
            if(argv[2]==">")
            {
                fd=creat(argv[3],0777);
                close(stdout);
                dup(fd);
                close(fd);
            }
             if(argv[2]=="<")
            {
                fd=creat(argv[3],0777);
                close(stdin);
                dup(fd);
                close(fd);
            }
            if(argv[2]=="|")
            {
            
                pipe(fds);
                if(fork()==0)
                {
                    close(stdout);
                    dup(fds[1]);
                    close(fds[1]);
                    close(fds[0]);
                    execlp(argv[3],argv[3],(char*)0);
                }
                  close(stdin);
                    dup(fds[0]);
                    close(fds[0]);
                    close(fds[1]);
           
            }
            
          
            execlp(argv[1],argv[1],argv[2],(char*)0);
        }
 //       if(ampr==0)
   //     {
     //       printf("no &\n");         
       //     rid=wait(&status);
         //    printf("after wait\n");
        //}
        //if(ampr==1)
        //{
          //  printf("with &\n");
            //exit(0);
        //}
        
return 0;
}
