import java.util.*;
public class UserLogin {
    static ArrayList<String> username=new ArrayList<>();
    static ArrayList<String> userpass=new ArrayList<>(); 
    static ArrayList<Integer> wallet=new ArrayList<>();
    static ArrayList<String> cart=new ArrayList<>();
    static int amount=1000;
    static void Login(){
        System.out.println("""
        1 -> new user
        2 -> user Login
        3 -> exit""");
        int choice=First.sc.nextInt();
        First.sc.nextLine();
        if(choice==1){
            adduser();
        }
        else if(choice==2){
            userlogin();
        }
        else if(choice==3){
            System.out.println("Thank You da boy");
        }
        else{
            System.out.println("Invalid");
            return;
        }
    }
    static void adduser(){
        System.out.println("user name :");
        String newusername=First.sc.nextLine();
        System.out.println("user password :");
        String newuserpass=First.sc.nextLine();
        userpass.add(newuserpass);
        username.add(newusername);
        wallet.add(amount+=100);
        Login();
    }
    static void userlogin(){
        System.out.println("user name :");
        String name=First.sc.nextLine();
        System.out.println("user password :");
        String pass=First.sc.nextLine();
        int ind=-1;
        for(int i=0;i<username.size();i++){
            if(username.get(i).equals(name) && userpass.get(i).equals(pass)){
                ind=i;
            }
        }
        if(ind==-1){
            System.out.println("user name password invalid or not avalible");
        }
        else{
            userpage(ind);
        }
    }
    static void userpage(int ind){
        System.out.println("""
            ------user page-----
            1 -> Search product
            2 -> show cart
            3 -> show wallet balance
            4 -> exit """);
        System.out.println("enter choice :");
        int choice=First.sc.nextInt();
        First.sc.nextLine();
        if(choice==1){
            System.out.println("product search");
            String search=First.sc.nextLine();
            System.out.println("|  Seller Id  |  Name  |  Quantity  |  price  |  Details  |  Warranty  |  Return Period  |");
            int a=-1;
            for(int i=0;i<product.List.size();i++){
                if(product.List.get(i).name.equals(search)){
                   a=i;
                   System.out.println("| "+product.List.get(i).id+"     | "+product.List.get(i).name+"    | "+product.List.get(i).quantity+"     | "+product.List.get(i).price+"   | "+product.List.get(i).details+"    | "+product.List.get(i).warranty+"     | "+product.List.get(i).returnperiod+" |");

                }
            }
            if(a==-1){
                System.out.println("product not avalible");
                userpage(ind);
    
            }
            else{
                buyorcartpage(ind);
            }
        }
        else if(choice==2){
            for(int i=0;i<cart.size();i++){
                System.out.println(cart.get(i));
            }
        }
        else if(choice==3){
            System.out.println("your wallet balance");
            System.out.println(wallet.get(ind));
            userpage(ind);
        }
        else if(choice==4){
            System.out.println("Thank You");
            Login();
        }
    }
    static void buyorcartpage(int ind) {
        System.out.println("enter you need product relate seller id :");
        int sellerid=First.sc.nextInt();
        First.sc.nextLine();
        for(int i=0;i<product.List.size();i++){
            if(product.List.get(i).id==sellerid){
                buyorcart(i,ind);
            }
        }
    }
    static void buyorcart(int i,int ind){
        System.out.println("""
        1 -> buy
        2 -> add to cart
        3 -> exit
        """);
        System.out.println("enter you choice :");
        int choice=First.sc.nextInt();
        if(choice==1){
            System.out.println("quantity");
            int qu=First.sc.nextInt();
            if( product.List.get(i).price<=wallet.get(ind) && product.List.get(i).quantity>=qu){
                product.List.get(i).quantity-=qu;
                int b=wallet.get(ind)-product.List.get(i).price;
                wallet.set(ind,b);
                System.out.println("buy successfully");
                userpage(ind);
            }
            else{
                System.out.println("not avalible amount in your cart or enter quantity does not avalible");
                buyorcart(i, ind);
            }
        }
        else if(choice==2){
            cart.add(product.List.get(i).name);
            System.out.println("added successfully");
            userpage(ind);
        }
        else if(choice==3){
            System.out.println("Thank You");
            userpage(ind);
        }
    }
    
}
