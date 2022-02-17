import java.util.*;
public class User_page {
    String username;
    int userpass;
    int amount;
    int id;
    static int Id=100;
    static Scanner sc=new Scanner(System.in);
    static ArrayList<User_page> List=new ArrayList<>(); 
    User_page(String username,int userpass,int amount,int id){
        this.username=username;
        this.userpass=userpass;
        this.amount=amount;
        this.id=id;
    }
    User_page(){}
    static void ulogin(){
        System.out.println("""
        1 -> new user
        2 -> existing user
        3 -> exit
        """);
        System.out.println("enter choice :");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            newuser();
        }
        else if(choice==2){
            existing();
        }
        else if(choice==3){
            System.out.println("Thank You");
            return;
        }
        else{
            System.out.println("Invalid input");
        }
    }
    static void newuser(){
        System.out.println("enter user name :");
        String username=sc.nextLine();
        System.out.println("enter user password :");
        int userpass=sc.nextInt();
        System.out.println("deposit wallet :");
        int amount=sc.nextInt();
        List.add(new User_page(username,userpass,amount,++Id));
        ulogin();
    }
    static void existing(){
        System.out.println("enter your user name :");
        String username=sc.nextLine();
        System.out.println("user password :");
        int userpass=sc.nextInt();
        int a=-1;
        for(int i=0;i<List.size();i++){
            if(List.get(i).username.equals(username) && List.get(i).userpass==userpass){
                a=i;
            }
        }
        if(a==-1){
            System.out.println("!!oops user name password not avalible\n pleas go to create an account");
            ulogin();
        }
        else{
            Bookingpage.Page(a,List.get(a).id);
        }
    }
    
}
