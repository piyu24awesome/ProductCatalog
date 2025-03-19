package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.models.TestString;
import org.example.productcatalogservice_feb2025.repo.TestStringRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestStringService {
    @Autowired
    TestStringRepo testStringRepo;

    public TestString getDataById(Integer id) {

        var result = testStringRepo.findTestById(id);
        System.out.println(result);
//        System.out.println(result.size());
//        return result.get(0);
//        return new TestString(((Integer) result.get(0)[0]), ((String) result.get(0)[1]));
        return result;
    }

    public TestString saveObject(TestString testString) {
        return testStringRepo.save(testString);
    }


}
