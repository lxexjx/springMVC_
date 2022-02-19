package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(PrototypeTest.PrototypeBean.class);

        PrototypeBean prototypeBean1=ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2=ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUserPrototype(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);
        ClientBean clientBean1=ac.getBean(ClientBean.class);
        int count1= clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2=ac.getBean(ClientBean.class);
        int count2= clientBean2.logic();
        assertThat(count2).isEqualTo(2);

    }
    @Scope("singleton")
    static class ClientBean{
        //private final PrototypeBean prototypeBean;  //생성전에 주입

        @Autowired
        ApplicationContext applicationContext;

//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean){
//            this.prototypeBean=prototypeBean;
//        }

        public int logic(){
             PrototypeBean prototypeBean=applicationContext.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            int count=prototypeBean.getCount();
            return count;

        }
    }
    @Scope("prototype")
    static class PrototypeBean{
        protected int count=0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("Prototype.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("Prototype.destroy");
        }
    }
}
