package org.example.productcatalogservice_feb2025.controllers;

import org.example.productcatalogservice_feb2025.Service.TestStringService;
import org.example.productcatalogservice_feb2025.models.TestString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestStringController {
    @Autowired
    TestStringService testStringService;

    @GetMapping("/{id}")
    public TestString getObjectById(@PathVariable int id) {
        TestString s = testStringService.getDataById(id);

        System.out.println(s.getName());
        return s;
    }

    @PostMapping()
    public TestString saveObject(@RequestBody TestString testString) {
        return testStringService.saveObject(testString);
    }
}
