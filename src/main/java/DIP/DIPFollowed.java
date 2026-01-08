package DIP;


interface Databases{
    public void save(String s);
}

class SaveToSQLDB implements Databases{

    public void save(String s){
        System.out.println("Saving to " + s+" SQL but  following DIP");
    }

}

class SaveToMongoDB implements Databases{
    public void save(String s){
        System.out.println("Saving to " + s+" Mongo but  following DIP");
    }
}

class ClientUser{

    // better to make final ----> dependency injection [passing and  using object as a variable ]
    private final Databases obj;

    public ClientUser(Databases obj){
        this.obj=obj;
    }

    public  void saveToDBUsingDIP(String s){
        obj.save(s);
    }
}

public class DIPFollowed{
    public static void main (String args[]){
        SaveToSQLDB sql=new SaveToSQLDB();
        SaveToMongoDB mongo = new SaveToMongoDB();
        ClientUser obj = new ClientUser(sql);
        obj.saveToDBUsingDIP("Sakshi");

        ClientUser obj2 = new ClientUser(mongo);
        obj2.saveToDBUsingDIP("Saraswat");
/*
Advantage: abh yaha kitne hi add karle new classes
 */


    }
}