import java.util.*;
public class User{
    static Scanner sc=new Scanner(System.in);
    static String[] username={"A","B","C","D"};
    static String[] userpass={"1","2","3","4"};
    static Character[] bank={'W','X','X','Z'};
    static int[] useramount={30000,20000,40000,25000}; 
    static int attempt=0;
    static void Login(){
        System.out.println("user_name");
        String user_name=sc.nextLine();
        System.out.println("user_password");
        String user_pass=sc.nextLine();
            int ind=-1,au=-1;
            for(int i=0;i<username.length;i++){
                if(user_name.equals(username[i])){
                    ind=i;
                    if(user_pass.equals(userpass[i])){
                        au=i;break;
                    }
                }
            }
            if(ind==-1 || au==-1){
                if(attempt>=2){
                    System.out.println("Maximum limit of Attempts reached ! \n Try after 24 Hrs");
                    userpass[ind]="Invalid";
                    return;
                }
                System.out.println("Invalid Username Or Password");attempt++;
            }
            else{
               attempt=0;
               userpage(useramount[au],au);
            }
    }
    static void userpage(int useramount, int i){
        System.out.println("1 -> withdraw"+"\n"+"2 -> deposit"+"\n"+"3 -> show balance"+"\n"+"4 -> change pin"+"\n5->Transfer\n"+"6 -> exit");
        int click=sc.nextInt();
        sc.nextLine();
        switch(click){
            case 1:
                ATMMechine.withdraw(i);
                break;
            case 2:
                ATMMechine.deposite(i);
                break;
            case 3:
                ATMMechine.show_Balence(useramount);
                break;
            case 4:
                System.out.println("Enter new Password : ");
                String p=sc.nextLine();
                userpass[i]=p;
                System.out.println("Password Updated Successfully");
                Login();
                break;
            case 5:
                ATMMechine.transfer(i);
            case 6:
                return;
            default:
                System.out.println("Invalid Input");
        }
    }
    
}
