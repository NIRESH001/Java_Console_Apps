import java.util.ArrayList;

public class product {
    String name;
    int quantity;
    int price;
    String details;
    String warranty;
    String returnperiod;
    int id;
    static ArrayList<product> List=new ArrayList<>();
    product(String name,int quantity,int price,String details,String warranty,String returnperiod,int id){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.details=details;
        this.warranty=warranty;
        this.returnperiod=returnperiod;
        this.id=id;
    }
    
}
