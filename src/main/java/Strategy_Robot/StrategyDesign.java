package Strategy_Robot;

/*
ONLY rule: composition over inheritance
Abh koi bhi combination easily banao

       class A
    class B      class C

    abh class B, class C same function rakhengi to DRY princple break
    aur nhi, to new firse inheritance

 */
interface RobotWalkStrategy
{

    public void  walk();
}
class Nowalk implements RobotWalkStrategy{
    @Override
    public void walk(){
        System.out.println(" NO walk");
    }
}

class Normalwalk implements RobotWalkStrategy{
    @Override
    public void walk(){
        System.out.println(" NOrmal walk");
    }
}

interface RobotFlyStrategy
{

    public void  fly();
}
class Nofly implements RobotFlyStrategy{
    @Override
    public void fly(){
        System.out.println(" NO fly");
    }
}

class Normalfly implements RobotFlyStrategy{
    @Override
    public void fly(){
        System.out.println(" NOrmal fly");
    }
}



class RobotClass{
    RobotFlyStrategy fly;
    RobotWalkStrategy walk;

    /*
    IMPORTANT
    tune constructor ko void return type de diya tha
    A constructor has no return type, name must be exactly same as class name
     */
    public RobotClass(RobotWalkStrategy obj, RobotFlyStrategy obj2){
        this.fly=obj2;
        this.walk=obj;
    }
    public void  walk(){
        walk.walk();
    }
    public void  fly(){
        fly.fly();
    }
}
public  class StrategyDesign{
    public static void main (String args[]){

        RobotClass obj = new RobotClass(new Nowalk(),new Normalfly() );
        obj.fly();
        obj.walk();

        /*
        You can not write obj.fly(), kyuki fly koi RobotClass ka function nhi.. banana padega aur
        vhi passed object se call karega
         */





    }
}

