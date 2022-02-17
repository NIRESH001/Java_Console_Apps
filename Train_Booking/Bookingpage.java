
public class Bookingpage {
    static int [][] ticket=new int[10][6];
    static int [][] WaitingList=new int[5][3];
    static{
        WaitingList[0][0]=1;
        WaitingList[0][1]=6;
        WaitingList[0][2]=99;
    }
    static void Page(int a,int id){
        System.out.println("""
        1 -> booking
        2 -> cancel
        3 -> show balance
        4 -> show seat arrangement
        5 -> deposit wallet amount
        6 -> exit
        """);
        System.out.println("enter choice :");
        int choice=User_page.sc.nextInt();
        if(choice==1){
            booking(a,id);
        }
        else if(choice==2){
           cancel(a,id); 
        }
        else if(choice==3){
            show_balance(a,id);
        }
        else if(choice==4){
            show_seats(a,id);
        }
        else if(choice==6){
            System.out.println("Thank You Sir");
            User_page.ulogin();
        }
        else if(choice==5){
            deposit(a,id);
        }
        else{
            System.out.println("Invalid");
            Page(a, id);
        }
    }
    static void booking(int a,int id){
        System.out.println("city(1) city(2) city(3) city(4) city(5) city(6)");
        System.out.println("enter your From city :");
        int from=User_page.sc.nextInt();
        for(int i=from;i<6;i++){
            System.out.print("city"+"("+(i+1)+") ");
        }
        System.out.println();
        System.out.println("enter your To city :");
        int to=User_page.sc.nextInt();
        int count=0;
        for(int i=0;i<10;i++){
            for(int j=from;j<to;j++){
                if(ticket[i][j]==0){
                    count++;
                }
            }
            if((to-from)==count){
                for(int k=from;k<to;k++){
                    ticket[i][k]=id;
                }
                System.out.println("your seat number is "+(i+1));
                break;
            }
        }
        if(count==0){
            System.out.println("train ticket is full\nyou are a waiting list");
            waiting(a,id,from,to);
        }
        if((to-from)+1==6){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=300;
                System.out.println("booking successfully\nThank You for your visiting");
            }
        }
        else if((to-from)+1==5){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=250;
                System.out.println("booking successfully\nThank You for your visiting");
            }
        }
        else if((to-from)+1==4){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=200;
                System.out.println("booking successfully\nThank You for your visiting");
            }
        }
        else if((to-from)+1==3){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=150;
                System.out.println("booking successfully\nThank You for your visiting");
            }
        }
        else if((to-from)+1==2){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=100;
                System.out.println("booking successfully\nThank You for your visiting");
            }
        }
        else{
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=50;
                System.out.println("booking successfully\nThank You for your visiting");
            }
        }
        Page(a, id);
    }
    static void cancel(int a,int id){
        System.out.println("enter seat number :");
        int seat=Main_page.sc.nextInt();
        seat=seat-1;
        int count=0;
        for(int i=0;i<6;i++){
            if(ticket[seat][i]==id){
                ticket[seat][i]=0;
                count++;
            }
        }
        if(count+1==6){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount+=350;
                System.out.println("refund successfully");
                allocate(seat,id,a);
            }
        }
        else if(count+1==5){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount+=300;
                System.out.println("refund successfully");
                allocate(seat,id,a);
            }
        }
        else if(count+1==4){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount+=250;
                System.out.println("refund successfully");
                allocate(seat,id,a);
            }
        }
        else if(count+1==3){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount+=200;
                System.out.println("refund successfully");
                allocate(seat,id,a);
            }
        }
        else if(count+1==2){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount+=150;
                System.out.println("refund successfully");
                allocate(seat,id,a);
            }
        }
        else{
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount+=100;
                System.out.println("refund successfully");
                allocate(seat,id,a);
            }
        }
    } 
    static void show_balance(int a,int id){
        for(int i=0;i<User_page.List.size();i++){
            if(User_page.List.get(i).id==id){
                System.out.println("total amount in your wallet : "+User_page.List.get(i).amount);
                System.out.println("press enter to continue");
                Main_page.sc.nextLine();
                Page(a, id);
            }
        }
    }
    static void show_seats(int a,int id){
        System.out.println("~~~~~ seating arrangement ~~~~~");
        for(int i=0;i<10;i++){
            for(int j=0;j<6;j++){
                System.out.print(ticket[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("~~~~~~ waiting list ~~~~~~");
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                System.out.print(WaitingList[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("press enter to continue");
        Main_page.sc.nextLine();
        Page(a, id);
    }
    static void deposit(int a,int id){
        // for(int i=0;i<User_page.List.size();i++){
            System.out.println("enter deposit amount");
            int amo=User_page.sc.nextInt();
            User_page.List.get(a).amount+=amo;
            System.out.println("deposit successfully");
            System.out.println("press enter to continue");
            Main_page.sc.nextLine();
        // }
        Page(a, id);
    }
    static void waiting(int a,int id,int from,int to){
        int c=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                if(WaitingList[i][j]==0){
                    c++;
                }
            }
            if(c==3){
                // for(int j=0;j<3;j++){
                WaitingList[i][0]=from;
                WaitingList[i][1]=to;
                WaitingList[i][2]=id;

                // }
            }
        }
        if(c==0){
            System.out.println("waiting list also full!!!!!!\nThanks for visiting");
            return;
        }
        Page(a, id);
    }
    static void allocate(int seat,int id,int a){
        int count=0;
        int i;
        for ( i= 0; i < WaitingList.length; i++) {
            for (int j = WaitingList[i][0]; j < WaitingList[i][1]; j++) {
                if(ticket[i][j]==0){
                    count++;
                }
                
            }
            if((WaitingList[i][1]-WaitingList[i][0]==count)){
                for(int j=WaitingList[i][0];j<WaitingList[i][1];j++){
                    ticket[i][j]=WaitingList[i][2];
                }
                for(int k=0;k<3;k++){
                    WaitingList[i][k]=0;
                }
                break;
            }
        }
        if((WaitingList[i][1]-WaitingList[i][0])+1==6){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=300;            }
        }
        else if((WaitingList[i][1]-WaitingList[i][0])+1==5){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=250;            }
        }
        else if((WaitingList[i][1]-WaitingList[i][0])+1==4){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=200;
            }
        }
        else if((WaitingList[i][1]-WaitingList[i][0])+1==3){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=150;
            }
        }
        else if((WaitingList[i][1]-WaitingList[i][0])+1==2){
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=100;
            }
        }
        else{
            if(id==User_page.List.get(a).id){
                User_page.List.get(a).amount-=50;
            }
        }
        Page(a, id);
    }
}
