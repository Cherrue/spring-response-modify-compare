package me.cherrue.modifybyconverter;

import me.cherrue.modifybyconverter.entity.ChildEntity;
import me.cherrue.modifybyconverter.entity.ParentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/converter")
    public ParentEntity filter() {
        ChildEntity childEntity = new ChildEntity();
        childEntity.setData1("data1");
        childEntity.setData2("data2");

        return childEntity;
    }
}