package DIP;


class SaveToDB{

    public void saveDB(String s){
        System.out.println("Saving to " + s+" DB but not following DIP");
    }

}

class SaveToFile{
    public void saveFile(String s){
        System.out.println("Saving to " + s+" File but not following DIP");
    }
}

class User{
/*
Why it is breaking DIP

kya jarurat mere high level module ko ye jann ne ki konsi classes hai
yaha bas 1 object hona chayih jo function call kare
aur hum bas correct obj pass karenge jiss se sahi class call ho

Adv: agar kal koi new class banani pade to bas new class banai padegi
OCP break karke user me koi change nhi;
 */

    // better practice to make final
    private final SaveToDB obj= new SaveToDB();
    private  final SaveToFile obj2 = new SaveToFile();

    public  void savingToDB(String s){
        obj.saveDB(s);
    }
    public  void savingToFile(String s){
        obj2.saveFile(s);
    }
}

public class DIPNotFollowed{
    public static void main (String args[]){
        User obj = new User();
        obj.savingToDB("Sakshi");
        obj.savingToFile("Saraswat");
    }
}