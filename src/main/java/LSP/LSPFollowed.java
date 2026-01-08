package LSP;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

interface NonWithdrawAccount{
    public void deposit(int amount);
}
/*
IMPORTANT:
Ek interface dusre interfce ko extend karta hai.
 */
interface WithdrawAccount extends NonWithdrawAccount{

    public void withdraw(int amount);
}
class Savingaccount implements WithdrawAccount{
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

class Currentaccount implements WithdrawAccount{
    private  int balance;

    @Override
    public void withdraw(int a){
        balance-=a;
        System.out.println("Current Account: Withdrawing the amount and balance = "+ balance);
    }

    @Override
    public void deposit(int a){
        balance+=a;
        System.out.println("Current Account: Deposit the amount and balance = "+ balance);

    }
}

class FixedAccount implements NonWithdrawAccount{
    private  int balance;

    @Override
    public void deposit(int a){
        balance+=a;
        System.out.println("Fixed deposit: Deposit the amount and balance = "+ balance);

    }

}
class UserClient{
    List<NonWithdrawAccount>userAccountsNonWithdraw;
    List<WithdrawAccount>userAccountsWithdraw;

    public UserClient( List<NonWithdrawAccount> ua, List<WithdrawAccount>ub ){
        this.userAccountsNonWithdraw = ua;
        this.userAccountsWithdraw=ub;
    }

    public void uerTransactions(){
        for(NonWithdrawAccount a: userAccountsNonWithdraw){
            a.deposit(1000);
            // only deposit

        }

        for(WithdrawAccount a: userAccountsWithdraw){
            a.deposit(1000);
            a.withdraw(50);
        }
    }


}

public class LSPFollowed{
    public  static void main (String args []){
        Savingaccount obj = new Savingaccount();
        FixedAccount obj1 = new FixedAccount();
        Currentaccount obj2=new Currentaccount();
        List<NonWithdrawAccount>ua = new ArrayList<>();
        ua.add(obj1);

        /*
        Directly:  withdrawableAccounts.add(new SavingAccount());
         */
        List<WithdrawAccount>ub = new ArrayList<>();
        ub.add(obj);
        ub.add(obj2);

        UserClient user = new UserClient(ua,ub);
        user.uerTransactions();




    }
}