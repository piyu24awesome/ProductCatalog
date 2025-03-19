package org.example.productcatalogservice_feb2025.controllers.inhertancecontroller;

import org.example.productcatalogservice_feb2025.Service.others.TestStringService;
import org.example.productcatalogservice_feb2025.models.SingleClass.TestString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestStringController {
    @Autowired
    TestStringService testStringService;

    @GetMapping("/{id}")
    public List<TestString> getObjectById(@PathVariable int id) {
      return testStringService.getDataById(id);


    }

    @PostMapping()
    public TestString saveObject(@RequestBody TestString testString) {
        return testStringService.saveObject(testString);
    }
}
