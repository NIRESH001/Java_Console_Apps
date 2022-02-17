import java.util.*;
public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("*******A.T.M*******");
        while(true){
            System.out.println("1 -> Admin"+"\n"+"2 -> user"+"\n"+"3 -> Exit"+"\n");
            System.out.println("Enter your's correct option :");
            String choise=sc.nextLine();
            if(choise.equals("1")){
                System.out.println("-----Welcome Admin-----");
                Admin.adminLogin();
            }
            else if(choise.equals("2")){
                System.out.println("-----Welcome User-----");
                User.Login();
            }
            else if(choise.equals("3")){
                System.out.print("!!!Thank You!!!!");
                break;
            }
            else{
                System.out.println("!!!Don't Allow More Then Three Options!!!");
            
            }
        }

    }
}
