package me.cherrue.responsemodifier.controller;

import me.cherrue.responsemodifier.ChildEntity;
import me.cherrue.responsemodifier.ParentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/controller")
    public ParentEntity filter() {
        ChildEntity childEntity = new ChildEntity();
        childEntity.setData1("data1");
        childEntity.setData2("data2");

        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setData1(childEntity.getData1());
        return parentEntity;
    }
}
