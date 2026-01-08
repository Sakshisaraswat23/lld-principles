package LSP;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

interface Account{
    public void withdraw(int amount);
    public void deposit(int amount);
}
class Savingacc implements Account{
    private  int balance;

    @Override
    public void withdraw(int a){
        balance-=a;
        System.out.println("Saving Account: Withdrawing the amount and balance = "+ balance);
    }

    @Override
    public void deposit(int a){
        balance+=a;
        System.out.println("Saving Account: Deposit the amount and balance = "+ balance);

    }
}

class FixedAcc implements Account{
    private  int balance;

    @Override
//    public void withdraw(int a){
//        balance-=a;
//        System.out.println("Withdrawing the amount and balance = "+ balance);
//    }
    public void withdraw(int a){

        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account!");

    }

    @Override
    public void deposit(int a){
        balance+=a;
        System.out.println("Deposit the amount and balance = "+ balance);

    }

}
class Client{
    List<Account>userAccounts;

    public Client( List<Account> ua ){
        this.userAccounts = ua;
    }
    /*
    dekh abh yaha alag se handling karni padh rhi....
    maine phele bina handlin ke chalaya to exception raise ho gaya

    Exception in thread "main" java.lang.UnsupportedOperationException: Withdrawal not allowed in Fixed Term Account!
	at LSP.FixedAcc.deposit(LSPNotFollowed.java:45)
	at LSP.Client.transactions(LSPNotFollowed.java:58)
	at LSP.LSPNotFollowed.main(LSPNotFollowed.java:78)

Process finished with exit code 1

    Abh agar koi account hoga jisme withdraw nhi hoga, uspe bhi if else karke handle karo
    to iss se better nhi ki alag maintain karo...
     */

    public void transactions(){
        for(Account a: userAccounts){
            a.deposit(1000);
            try {
                a.withdraw(50);
            } catch (UnsupportedOperationException e) {
                System.out.println("Exception for withdraw " + e.getMessage());
            }

        }
    }


}

public class LSPNotFollowed{
    public  static void main (String args []){
        Savingacc obj = new Savingacc();
        FixedAcc obj1 = new FixedAcc();
        List<Account>ua = new ArrayList<>();
        ua.add(obj);
        ua.add(obj1);

        /*
        Tested this.. i same object hi change hota...
         */
        obj.deposit(500);

        Client user = new Client(ua);
        user.transactions();

//        obj.deposit(500);




    }
}