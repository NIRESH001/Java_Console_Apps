import java.util.Scanner;
public class First{
    static Scanner sc=new Scanner(System.in);
	static Seller sel;
    static admin ad;
    // static user us;
    public static void main(String[] args){
        boolean flag=true;
        while(flag){
            System.out.println("^^^^^^^^ Welcome to amazon ^^^^^^^^^");
            System.out.println("1 -> Seller"+"\n"+"2 -> Admin"+"\n"+"3 -> User"+"\n"+"4 -> Exit" );
            int select=sc.nextInt();
            sc.nextLine();
            switch(select){
                case 2:
                    System.out.println("----- Welcome Admin -----");
                    // ad=new admin();
                    admin.adminlogin();
                    break;
                case 1:
					sel=new Seller();
					sel.seller();
                    
                    break;
                case 3:
                    System.out.println("-----Welcome User-----");
                    UserLogin.Login();
                    break;
                case 4:
                    System.out.println("!!!!Thanks for visiting!!!!");
                    flag=false;
                    break;
                default:
                    System.out.println("invalid");
                    break;
                }
                // break; 
            }
    } 
}
