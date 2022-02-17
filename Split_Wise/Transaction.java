import java.util.ArrayList;

public class Transaction {
    String reason;
    String name;
    int amo;
    int amount_id;
    int id;
    int ind;
    static ArrayList<Transaction> details=new ArrayList<>();
    Transaction(String reason,String name,int amo,int id,int ind,int amount_id){
        this.reason=reason;
        this.name=name;
        this.amo=amo;
        this.amount_id=amount_id;
        this.id=id;
        this.ind=ind;
    }

}
