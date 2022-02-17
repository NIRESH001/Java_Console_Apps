import java.util.*;
public class Main_split {
    static Scanner sc=new Scanner(System.in);
    public static void main(String [] args){
        boolean flag=true;
        while(flag){ 
            System.out.print("""
            ------ Welcome ------
            1 -> User Login
            2 -> Exit
            """);
            System.out.println("enter 1 or 2 :");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                User__page.User_Login();
            }
            else if(choice==2){
                System.out.println("Thank You");
                flag=false;
            }
            else{
                System.out.println("enter correct option");
            }
        }

    }
    
}
