import java.util.ArrayList;
import java.util.*;
public class User__page {
    String user_name;
    String user_pass;
    String tran="";
    int amount;
    int id;
    ArrayList<Integer> trans=new ArrayList<>();
    String status;
    static String gname;
    static int amo;
    static Scanner sc=new Scanner(System.in);
    static HashMap<String, List<User__page>> List = new HashMap<>();
    static List<User__page> tp = new ArrayList<>();
    static int Id = 100;
    static { 
        tp.add(new User__page("niresh", "123", 10000, ++Id, ""));
        tp.add(new User__page("hari", "123", 10000, ++Id, ""));
        tp.add(new User__page("sundar", "123", 10000, ++Id, ""));
        tp.add(new User__page("nithish", "123", 10000, ++Id, ""));
        List.put("1", tp);
    }
    
    User__page(String user_name, String user_pass, int amount, int id, String status) {
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.amount = amount;
        this.id = id;
        this.status=status;
        this.tran="";
    }
    // int user_id;
    // int a_id;
    // static ArrayList<User__page> pay=new ArrayList<>();
    // User__page(int user_id,int a_id){
    //     this.user_id=user_id;
    //     this.a_id=a_id;
    // }
    static void User_Login(){
        System.out.println("""
        1 -> new user
        2 -> exciting user
        3 -> exit
        """);
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            new_user();
        }
        else if(choice==2){
            ex_user();
        }
        else if(choice==3){
            System.out.println("Thank You");
            return;
        }
        else{
            System.out.println("pls enter correct options");
            User_Login();
        }
    }
    static void new_user(){
       System.out.println("""
       1 -> exciting group 
       2 -> new group
       3 -> exit
       """);
        int choice =sc.nextInt();
        sc.nextLine();
        if(choice==1){
            ex_group();
        }
        else if(choice==2){
            new_group();
        }
        else if(choice==3){
            User_Login();
        }
        else {
            System.out.println("pls enter correct options");
        }

    }
    static void ex_group(){
        int a=1;
        for(String i:List.keySet()){
            System.out.print(a+" "+i+" ");
            a++;
        }
        System.out.println();
        System.out.println("enter which group you want");
        gname=sc.nextLine();
        boolean flag=true;
        user(flag);
    }
    static void user(boolean flag){
        System.out.println("user name");
        String user_name=sc.nextLine();
        if(flag){
            for(int i=0;i<List.get(gname).size();i++){
                if(user_name.equals(List.get(gname).get(i).user_name)){
                    System.out.println("user name already exciting");
                    new_user();
                }
            }
        }
        System.out.println("user password");
        String user_pass=sc.nextLine();
        System.out.println("deposit wallet amount");
        int amount=sc.nextInt();
        sc.nextLine();
        String status="";
        tp.add(new User__page(user_name,user_pass,amount,++Id,status));
        List.put(gname,tp);
        System.out.println("login successfully");
        User_Login();
    }
    static void new_group(){
        boolean flag=false;
        System.out.println("enter new group name");
        gname=sc.nextLine();
        for(String i:List.keySet()){
            if(gname.equals(i)){
                System.out.println("group name already exciting");
                new_group();
            }
        }
        System.out.println("new group create successfully\nenter your details");

        user(flag);
    }
    static void ex_user(){
        System.out.println("user name");
        String user_name=sc.nextLine();
        System.out.println("user password");
        String user_pass=sc.nextLine();
        System.out.println("enter group name");
        gname=sc.nextLine();
        int a=-1;
        int i;
        for(i=0;i<List.get(gname).size();i++){
            if(user_name.equals(List.get(gname).get(i).user_name)&& user_pass.equals(List.get(gname).get(i).user_pass)){
                a=i;break;
            }
        }
        if(a==-1){
            System.out.println("user name password are invalid");
            User_Login();
        }
        else{
            Main_User(i,List.get(gname).get(i).id,gname);
        }
    }
    static void Main_User(int ind,int id,String gname){
        System.out.println("""
            1 -> add member
            2 -> pay amount
            3 -> show wallet amount
            4 -> deposit amount
            5 -> transaction details
            6 -> exit
            """);
        System.out.println("enter option :");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            add_member(ind,id,gname);
        }
        else if(choice==2){
            pay_amount(ind,id,gname);
        }
        else if(choice==3){
            Show_wallet(ind,id,gname);
        }
        else if(choice==4){
            dep_amount(ind,id,gname);
        }
        else if(choice==5){
            Tran(ind,id,gname);
        }
        else if(choice==6){
            User_Login();
        }
    }
    static void Show_wallet(int ind,int id,String gname){
        for(int i=0;i<List.get(gname).size();i++){
            if(List.get(gname).get(i).id==id){
                System.out.println("your wallet balance : "+List.get(gname).get(i).amount);
                Main_User(ind, id, gname);
            }
        }
    }
    static void dep_amount(int ind,int id,String gname){
        for(int i=0;i<List.get(gname).size();i++){
            if(List.get(gname).get(i).id==id){
                System.out.println("enter deposit amount");
                int amount=sc.nextInt();
                List.get(gname).get(i).amount+=amount;
                System.out.println("money added successfully");
                Main_User(ind, id, gname);
            }
        }
    }
    static void add_member(int ind,int id,String gname){
        System.out.println("user name");
        String user_name=sc.nextLine();
        for(int i=0;i<List.get(gname).size();i++){
            if(user_name.equals(List.get(gname).get(i).user_name)){
                System.out.println("user name already exciting");
                Main_User(ind, id, gname);

            }
        }
        System.out.println("user password");
        String user_pass=sc.nextLine();
        System.out.println("deposit wallet amount");
        int amount=sc.nextInt();
        sc.nextLine();
        String status="";
        tp.add(new User__page(user_name,user_pass,amount,++Id,status));
        List.put(gname,tp);
        System.out.println("member added successfully");
        Main_User(ind, id, gname);
    }
    static void pay_amount(int ind,int id,String gname){
        System.out.println("""
        1 -> add expense
        2 -> repay amount
        3 -> exit
        """);
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            ex_amount(ind,id,gname);
        }
        else if(choice==2){
            repay_amount(ind,id,gname);
        }
    }
    static int amount_id=1000;
    static void ex_amount(int ind,int id,String gname){
        System.out.println("what reason you want pay");
        String reason=sc.nextLine();
        System.out.println("enter paying amount");
        amo=sc.nextInt();
        sc.nextLine();
        if(List.get(gname).get(ind).amount>=amo){
            List.get(gname).get(ind).amount-=amo;
            List.get(gname).get(ind).status+="";
            for(int i=0;i<List.get(gname).size();i++){
                if(List.get(gname).get(i).id!=id){
                    List.get(gname).get(i).status="request";
                }
            }
            Transaction.details.add(new Transaction(reason,List.get(gname).get(ind).user_name, amo,id,ind,++amount_id));
            System.out.println("money payed and request successfully");
            Main_User(ind, id, gname);
        }
        else{
            System.out.println("you enter amount doesn't avalible");
            Main_User(ind, id, gname);
        }
        
    }
    static void repay_amount(int ind,int id,String gname){
        if(List.get(gname).get(ind).status.equals("request")){
            for(int i=0;i<Transaction.details.size();i++){
                if(Transaction.details.get(i).id!=id){
                    if(List.get(gname).get(ind).trans.size()==0){
                        System.out.println("Reason :"+Transaction.details.get(i).reason);
                        System.out.println("user name :"+Transaction.details.get(i).name);
                        System.out.println("spend amount :"+Transaction.details.get(i).amo);
                        System.out.println("------------------------------------------");
                        System.out.println("request amount :"+Transaction.details.get(i).amo/List.get(gname).size());
                        int t_amount=Transaction.details.get(i).amo/List.get(gname).size();
                        ch(ind,id,gname,i,t_amount);
                    }
                    else{
                        // for(int k=0;k<List.get(gname).get(ind).trans.size();k++){
                            if(!List.get(gname).get(ind).trans.contains(Transaction.details.get(i).amount_id)){
                                System.out.println("Reason :"+Transaction.details.get(i).reason);
                                System.out.println("user name :"+Transaction.details.get(i).name);
                                System.out.println("spend amount :"+Transaction.details.get(i).amo);
                                System.out.println("---------------------------------------");
                                System.out.println("request amount :"+Transaction.details.get(i).amo/List.get(gname).size());
                                int t_amount=Transaction.details.get(i).amo/List.get(gname).size();
                                ch(ind,id,gname,i,t_amount);
                            }
                            else{
                                continue;
                            }
                        // }
                    }    
                }
            }

            Main_User(ind, id, gname);
        }
        else{
            System.out.println("didn't any repayment pending");
            System.out.println(List.get(gname).get(ind).trans);
            System.out.println("press enter to continue");
            sc.nextLine();
            Main_User(ind, id, gname);
        }
    }
    static boolean check(int ind,int id,String gname){
        for(int i=0;i<List.get(gname).size();i++){
            if(List.get(gname).get(i).id==id){
                return true;
            }
        }
        return false;
    }
    static void ch(int ind,int id,String gname,int i,int t_amount){
        System.out.println("""
        1 -> pay
        2 -> pending
        """);
        System.out.println("enter 1 to pay 2 to pending");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            if(check(ind,id,gname)){
                List.get(gname).get(ind).amount-=t_amount;
                
                for(int j=0;j<List.get(gname).size();j++){
                    if(Transaction.details.get(i).id==List.get(gname).get(j).id){
                        List.get(gname).get(j).amount+=t_amount;
                        List.get(gname).get(ind).tran+=t_amount+" this amount is debited in your wallet to "+List.get(gname).get(ind).user_name+"\n";
                        List.get(gname).get(j).tran+=t_amount+" this amount is created in your wallet from "+List.get(gname).get(ind).user_name+"\n";
                        List.get(gname).get(ind).status="";
                    }
                }
                List.get(gname).get(ind).trans.add(Transaction.details.get(i).amount_id);
            }
            System.out.println(List.get(gname).get(ind).trans);
            System.out.println("payment successfully");
            System.out.println("press enter to continue");sc.nextLine();
        }
        else if(choice==2){
            List.get(gname).get(ind).status="request";
        }

    }
    static void Tran(int ind,int id,String gname){
        System.out.println(List.get(gname).get(ind).tran);
        System.out.println("press enter to continue");
        sc.nextLine();
        Main_User(ind, id, gname);
    }
}
