import java.util.*;
public class Admin {
    // public static String adminName="niresh";
    // static String adminPin="123"; \
    static ATMMechine ATM=new ATMMechine(); 
    static Scanner sc=new Scanner(System.in);
    static void userName_password(){

    }
    static void adminLogin(){
        System.out.println("user name :");
        String user_name=sc.nextLine();
        System.out.print("password :");
        String password=sc.nextLine();
        // Admin s=new Admin();
        // while(true){
        if(user_name.equals("admin") && password.equals("12345")){
            adminpage();
        }
        else{
            System.out.print("Wrong user name password");
        // }break;
    }
    }
    static void adminpage(){
        System.out.println("1.add money"+"\n"+"2.show balance"+"\n"+"3.exit");
            int click=sc.nextInt();
            sc.nextLine();
            switch(click){
                case 1:
                    ATM.add();
                    break;
                case 2:
                    ATM.ShowBalence();
                    break;
                case 3:
                    System.out.println("!!!Thank You!!!");
                    break;
                default:
                    System.out.println("invalid");
            }
    }
}
