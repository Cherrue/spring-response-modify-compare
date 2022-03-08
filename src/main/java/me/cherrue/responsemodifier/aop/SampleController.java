package me.cherrue.responsemodifier.aop;

import me.cherrue.responsemodifier.ChildEntity;
import me.cherrue.responsemodifier.ParentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/aop")
    public ParentEntity aop() {
        ChildEntity childEntity = new ChildEntity();
        childEntity.setData1("data1");
        childEntity.setData2("data2");

        return childEntity;
    }
}
