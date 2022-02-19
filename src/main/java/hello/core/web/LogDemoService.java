package hello.core.web;

import hello.core.common.Mylogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final Mylogger mylogger;
    public void logic(String id){
        mylogger.log("service id="+id);
    }
}
