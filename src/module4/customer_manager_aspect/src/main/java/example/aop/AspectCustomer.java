package example.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectCustomer {

//    @Pointcut(value ="execution(* example.controller.CustomerServlet.create(..))")
//    public void pointcut() {}
//
//    @Before( "pointcut()")
//    public void logger(){
//        System.out.println("create customer");
//    }
//
//    @After("pointcut()")
//    public void logger2(){
//        System.out.println("After execution");
//    }
}
