package hello.core.singleton;

public class StatefulService {  //trl+shift+t : 자동으로 test만듦
    //
//    private int price;  //상태를 유지하는 필드
//
//    public void order(String name,int price){
//        System.out.println("name="+name+"price="+price);
//        this.price=price;   //여기가 문제점!!!
//    }

//    public int getPrice(){
//        return price;
//    }
    //지역적이지 않게 변경함
        public int order(String name,int price){
        System.out.println("name="+name+"price="+price);
        return price;
    }



}
