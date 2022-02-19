package hello.core.web;

import hello.core.common.Mylogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final Mylogger mylogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL=request.getRequestURI().toString();
        mylogger.setrequestURL(requestURL);

        mylogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
