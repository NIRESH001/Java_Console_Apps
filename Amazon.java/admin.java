import java.util.*;
public class admin {
    static Scanner sc=new Scanner(System.in);
    static void adminlogin(){
        System.out.println("user name :");
        String username=sc.nextLine();
        System.out.println("user pass :");
        String userpass=sc.nextLine();
        if(username.equals("admin") && userpass.equals("123")){
           adminpage();
        }
        else{
            System.out.println("!!!oops,user name password invalid.......");
            System.out.println("press enter to continue.....");
            sc.nextLine();
            
        }
    }
    static void adminpage(){
        while(true){
        System.out.println("""
        1 -> approve/rejection
        2 -> add seller
        3 -> remove seller
        4 -> exit""");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            adminapprove();
        }
        else if(choice==2){
            addseller();

        }
        else if(choice==3){
            removeseller();
        }
        else if(choice==4){
            System.out.println("Thank You");
            return;
        }
        else{
            System.out.println("invalid input");
        }
    }
}
    static void adminapprove(){
        if(Seller.List.size()==0){
            System.out.println("didn't any approval pending");
            System.out.println("press enter to continue..");
            sc.nextLine();
            adminpage();

        }
        else{
        System.out.println("admin approve/rejection page");
        for(int i=0;i<Seller.List.size();i++){
            if(Seller.List2.get(i).equals("Pending")){
                System.out.println(Seller.List.get(i));
                System.out.println("1 -> approve\n2 -> reject");
                int app=sc.nextInt();
                if(app==1){
                    Seller.List2.set(i,"approved");
                    System.out.println("approved successfully");
                    // adminpage();
                    break;
                }
                else{
                    Seller.List2.set(i,"reject");
                    System.out.println("reject successfully");
                    adminpage();
                }

            }
            else{
                System.out.println("didn't any approvels");
                System.out.println("press enter to continue....");
                sc.nextInt();
            }
        }
        }
    }
    static void addseller(){
        
        System.out.println("enter add user name :");
        String username=sc.nextLine();
        System.out.println("enter add user password :");
        String userpass=sc.nextLine();
        Seller.List.add(username);
        Seller.List1.add(userpass);
        Seller.List2.add("approved");
        Seller.Id.add(++Seller.id);
    
    }
    static void removeseller(){
        System.out.println("enter remove user name :");
        String username=sc.nextLine(); 
        for(int i=0;i<Seller.List.size();i++){
            if(Seller.List.get(i).equals(username)){
                Seller.List2.set(i,"banned");
                System.out.println("banned successfully");
                return;
            }
        }
        System.out.println("not avalible this user Id");
        
        

    }
       
}


 