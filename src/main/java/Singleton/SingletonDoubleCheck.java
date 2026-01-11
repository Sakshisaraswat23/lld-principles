package Singleton;

class Singleton{

    // 1. static variable instance
    private static Singleton instance;

    // 2. private constructor
    private  Singleton(){
        System.out.println("Private constructor");
    }

    // 3. static function getInstance
    public static Singleton getInstance(){
        if(instance==null)
        {
            synchronized (Singleton.class){
                if(instance==null) {
                    /*
                    IMPORTANT
                    tune yaha se hi return kar diya tha
                    return new Singleton();

                    ye wrong hai, iss se multiple object create hue
                    kyuki instance assign hi nhi hua.
                     */
                    instance= new Singleton();
                }

            }

        }
        return instance;
    }
}
public class SingletonDoubleCheck {

    public static void main(String args[]){
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj==obj2);
    }

}

