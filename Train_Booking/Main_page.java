import java.util.*;
public class Main_page {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        boolean flag=true;
        while(flag){
            System.out.println("^^^^^^^^ Welcome ^^^^^^^^^");
            System.out.println("""
            1 -> User Login
            2 -> exit""");
            int select=sc.nextInt();
            sc.nextLine();
            switch(select){
                case 1:
                    User_page.ulogin();
                    
                    break;
                case 2:
                    System.out.println("!!!!Thanks for visiting!!!!");
                    flag=false;
                    break;
                default:
                    System.out.println("invalid");
                    break;
            }
        }
    }
}
