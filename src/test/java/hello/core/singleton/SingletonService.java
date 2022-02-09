package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance=new SingletonService();  //자기 자신을 참조해서 instance에 넣어놔

    public static SingletonService getInstance(){   //이 메서드를 통해서만 조회 가능
        return instance;
    }

    //생성자를 private로 막아
    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
