import java.util.*;
public class Seller {
    static ArrayList<String> List=new ArrayList<>();
    static ArrayList<String> List1=new ArrayList<>();
    static ArrayList<String> List2=new ArrayList<>();
    static ArrayList<Integer> Id=new ArrayList<>();
  
    static product po;
    static int id=1000;
    static Scanner sc=new Scanner(System.in);
    void seller(){
        while(true){
        System.out.println("-----Welcome Seller-----");
        System.out.println("""
        1 -> new seller
        2 -> Existing
        3 -> Exit""");
        System.out.println("enter your's choice :");
        int choice=sc.nextInt();
        sc.nextLine();
        String username;
        String userpassword;
        switch(choice){
            case 1:
                System.out.println("enter your new username :");
                username=sc.nextLine();
                System.out.println("enter your new password :");
                userpassword=sc.nextLine();
                // if(List.toString().contains(username)){
                //     System.out.println("user already excist");
                // }
                // else{
                List.add(username);
                List1.add(userpassword);
                List2.add("Pending");
                Id.add(++id);
                // }
                System.out.println("````waiting for admin approve`````");
                break;
            case 2:
                System.out.println("-----Hay User----");
                System.out.println("user name :");
                username=sc.nextLine();
                System.out.println("user password :");
                userpassword=sc.nextLine();
                checkuser(username,userpassword);
            break;
            case 3:
                System.out.println("!!!Thank You");
                return;
                

        }
    }
    }
    static void  sellerlogin(int id){
       System.out.println("Seller Login");
       System.out.println("""
       -------List-----
       1 -> add product
       2 -> edit product
       3 -> remove product
       4 -> show product list
       5 -> compare
       6 -> exit
       """);
       System.out.println("enter your choice :");
       int choice=sc.nextInt();
       sc.nextLine();
       if(choice==1){
           addproduct(id);
       }
       else if(choice==2){
            edit(id);
       }
       else if(choice==3){
            remove(id);
       }
       else if(choice==4){
            showproduct(id);
       }
       else if(choice==5){
            compare(id);
       }
       else if(choice==6){
           System.out.println("Thank you");
           return;
       }
       else{
           System.out.println("pls enter valid options??");
       }

       

   }
   static void checkuser(String username,String userpassword)
   {
    for(int i=0;i<List.size();i++){
        if(List.get(i).equals(username)&&List1.get(i).equals(userpassword)){
            if(List2.get(i).equals("approved")){
                System.out.println("Seller Login Successfully");
                sellerlogin(Id.get(i));
                return;
            }
            else if(List2.get(i).equals("reject")){
                System.out.println("reject your requests");
                return;
            }
            else if(List2.get(i).equals("banned")){
                System.out.println("your ID was banner");
                return;
            }
            else if(List2.get(i).equals("Pending")){
                System.out.println("your requiest is pending");
                return;
            }
        }
    }
    System.out.println("user name does not existing/invalid");
    }
    static void addproduct(int id){
        System.out.println("enter product name :");
        String name=sc.nextLine();
        System.out.println("enter product quantity :");
        int quantity=sc.nextInt();
        System.out.println("enter product price :");
        int price=sc.nextInt();
        sc.nextLine();
        System.out.println("enter product details :");
        String details=sc.nextLine();
        // System.out.println("enter product rating :");
        // int rating=sc.nextInt();
        // sc.nextLine();
        System.out.println("enter product warranty :");
        String warranty=sc.nextLine();
        System.out.println("enter product returnperiod :");
        String returnperiod=sc.nextLine();
        // System.out.println("enter product no_of_buyers :");
        // int no_of_buyers=sc.nextInt();
        product.List.add(new product(name,quantity,price,details,warranty,returnperiod,id)); 
        System.out.println("product added successfully");
        sellerlogin(id);
        return;
    }
     static void edit(int id){
        System.out.println("enter you have a editing product name :");
        String editingProduct=sc.nextLine();
        for(int i=0;i<product.List.size();i++){
            if(product.List.get(i).id==id && product.List.get(i).name.equals(editingProduct)){
                change(id,i);
            }   
        }

    }
    static void change(int id,int i){
        System.out.println("""
        ....What you want to edit ?....
        1 -> quantity
        2 -> price
        3 -> details
        4 -> warranty
        5 -> returnperiod""");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            System.out.println("update quantity :");
            int qu=sc.nextInt();
            sc.nextLine();
            product.List.get(i).quantity+=qu;
            System.out.println("updated successfully");
            sellerlogin(id);
        }
        else if(choice==2){
            System.out.println("update price :");
            int pr=sc.nextInt();
            sc.nextLine();
            product.List.get(i).price=pr;
            System.out.println("updated successfully");
            sellerlogin(id);
        }
        else if(choice==3){
            System.out.println("update details :");
            String de=sc.nextLine();
            product.List.get(i).details=de;
            System.out.println("updated successfully");
            sellerlogin(id);
        }
        else if(choice==4){
            System.out.println("update warranty :");
            String w=sc.nextLine();
            product.List.get(i).warranty=w;
            System.out.println("updated successfully");
            sellerlogin(id);
        }
        else if(choice==5){
            System.out.println("update  returnperiod :");
            String re=sc.nextLine();
            product.List.get(i).returnperiod=re;
            System.out.println("updated successfully");
            sellerlogin(id);
        }

    }
    static void remove(int id){
        System.out.println("enter removing product name :");
        String name=sc.nextLine();
        for(int i=0;i<product.List.size();i++){
            if(product.List.get(i).id==id && product.List.get(i).name.equals(name)){
                product.List.remove(i);
                System.out.println("removed successfully");
                sellerlogin(id);
            }
        }
        System.out.println("that product not avalible in your list");
        
        
    }
    static void showproduct(int id){
        System.out.println("| Seller Id | Name | Quantity | price | Details | Warranty | Return Period |");
        System.out.println(" ");
        System.out.println(" ");
        for(int i=0;i<product.List.size();i++){
            if(product.List.get(i).id==id){
                System.out.println("| "+id+"     | "+product.List.get(i).name+"    | "+product.List.get(i).quantity+"     | "+product.List.get(i).price+"   | "+product.List.get(i).details+"    | "+product.List.get(i).warranty+"     | "+product.List.get(i).returnperiod+" |");
                System.out.println();
                sellerlogin(id);
            }
        }

    }
    static void compare(int id){
        System.out.println("enter comparing product name :");
        String pname=sc.nextLine();
        System.out.println("| Seller Id | Name | Quantity | price | Details | Warranty | Return Period |");
        for(int i=0;i<product.List.size();i++){
            if(product.List.get(i).name.equals(pname)){
                if(product.List.get(i).id==id){
                    System.out.print("*");
                }
                System.out.println("|  "+product.List.get(i).id+"     | "+product.List.get(i).name+"    | "+product.List.get(i).quantity+"     | "+product.List.get(i).price+"   | "+product.List.get(i).details+"    | "+product.List.get(i).warranty+"     | "+product.List.get(i).returnperiod+" |");
                System.out.println();
            }

        }
        sellerlogin(id);
    }
}

