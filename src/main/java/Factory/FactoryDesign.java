package Factory;// It will not be pure factory... basically factory + strategy
/*
Important: ye basic hai...
please plan to create payment design with coupons ya kuch aur
 */

interface  PaymentStrategy{
    public void pay();
}

class UPI implements PaymentStrategy{

    /*
    Abh yaha pe koi option UPI id set karne ka bhi ho sakta
    agar ye bas startegy hota
    to constructor will pick upi id.
     */

    @Override
    public void pay() {
        System.out.println("Paying through UPI");
    }
}

class CreditCard implements PaymentStrategy{

    /*
    If only strategy
    to constructor will pick Credit card details
     */

    @Override
    public void pay() {
        System.out.println("Paying through Credit Card");
    }
}
class Wallet implements PaymentStrategy{

    /*
    If only strategy
    to constructor will pick Wallet details example: paytm
     */

    @Override
    public void pay() {
        System.out.println("Paying through Wallet");
    }
}

class PaymentFactory{
    public enum FactoryDesignEnum {
        CreditCard,
        UPI,
        Wallet
    }
    public PaymentStrategy createPayment(FactoryDesignEnum type){
        /*
        IMPORTANT:
        - tune phele if/else likha tha to tujhe pura enum.type likhna padha.
        Instead of that use switch.

        - For default ya vo last else case [incorrect type ]
        Important:
        1. UnsupportedOperationException is a class, not an object
        2. Exceptions must be thrown, not returned

        - Instead of unsupportedOperation use
        Use throw new IllegalArgumentException(...)
        This is the industry-standard approach and interview-safe answer.
         */




       /* if(type==FactoryDesignEnum.CreditCard){
            return new CreditCard();
        }
        else if(type==FactoryDesignEnum.UPI){
            return new UPI();
        }
        else if (type==FactoryDesignEnum.Wallet){
            return  new Wallet();
        }
        return  null;
//        else {
//            return UnsupportedOperationException;
//        }
        */
        switch (type) {
            case CreditCard:
                return new CreditCard();
            case UPI:
                return new UPI();
            case Wallet:
                return new Wallet();
            default:
                throw new IllegalArgumentException("Unsupported payment type: " + type);
        }
    }
}

public class FactoryDesign {

    public static void main(String args[]){
        PaymentFactory factory =  new PaymentFactory();
        PaymentStrategy creditObj = factory.createPayment(PaymentFactory.FactoryDesignEnum.CreditCard);
        creditObj.pay();

        PaymentStrategy UPIObj = factory.createPayment(PaymentFactory.FactoryDesignEnum.UPI);
        UPIObj.pay();

        PaymentStrategy WalletObj = factory.createPayment(PaymentFactory.FactoryDesignEnum.Wallet);
        WalletObj.pay();

        /*
        Using enum is helpful to avoid such instances..ki non supported payment method dedo.
        But bas yaha test karke dekha...
        vo exception try catch pe nahi likho to exception raise ho jata hai..uske baad ka code run nhi hoga

        try {
            PaymentStrategy obj = factory.createPayment(PaymentFactory.FactoryDesignEnum.Gpay);
            obj.pay();
        } catch (IllegalArgumentException  e) {
            System.out.println("Please select a valid payment method");
        }
         */


    }
}