package me.cherrue.modifybyfilter;

import me.cherrue.modifybyfilter.entity.ChildEntity;
import me.cherrue.modifybyfilter.entity.ParentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/filter")
    public ParentEntity filter() {
        ChildEntity childEntity = new ChildEntity();
        childEntity.setData1("data1");
        childEntity.setData2("data2");

        return childEntity;
    }
}
