package Observer;
// pakage ka name likhne ke baad semicolon aata hai

import java.util.ArrayList;
import java.util.List;
// important: packages dekhle jo import hote hai.

interface Channel{

    public void subscribe(SubscribeYT obj);
    public void unsubscribe(SubscribeYT obj);
    public void notifyUser();
    public void uploadVideo();
}

interface SubscribeYT{
    public void update();
}

class Subscriber1 implements SubscribeYT{
    @Override
    public void update() {
        System.out.println(" New video is out for the channel you have subscribed.");

    }
}

class Channel1 implements  Channel{
    List<SubscribeYT> subscribedUser = new ArrayList<>();
    @Override
    public void subscribe(SubscribeYT obj) {
        subscribedUser.add(obj);
    }

    @Override
    public void unsubscribe(SubscribeYT obj) {
        subscribedUser.remove(obj);

    }

    @Override
    public void notifyUser() {

        for( SubscribeYT obj: subscribedUser) {
            obj.update();
        }
    }

    @Override
    public void uploadVideo() {
        System.out.println(" Uploading new video");
        notifyUser();

    }
}

public  class ObservableDesign{
    public static void main(String args[]){
        Channel obj = new Channel1();
        obj.subscribe(new Subscriber1());
        /*
        Tere pass bahut sare observer [Subscriber2,3,...] ho sakte
         */
        obj.uploadVideo();
    }
}
