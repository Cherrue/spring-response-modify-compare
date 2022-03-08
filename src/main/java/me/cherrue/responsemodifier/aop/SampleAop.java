package me.cherrue.responsemodifier.aop;

import me.cherrue.responsemodifier.ChildEntity;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAop {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void controllerPoint() {}

    @AfterReturning(pointcut = "controllerPoint()", returning = "result")
    public void afterReturning(ChildEntity result) {
        result.setData2(null);
    }
}
