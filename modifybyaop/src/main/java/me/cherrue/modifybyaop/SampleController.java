package me.cherrue.modifybyaop;

import me.cherrue.modifybyaop.entity.ChildEntity;
import me.cherrue.modifybyaop.entity.ParentEntity;
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
