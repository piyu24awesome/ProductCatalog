package org.example.productcatalogservice_feb2025.Service.others;

import org.example.productcatalogservice_feb2025.models.SingleClass.TestString;
import org.example.productcatalogservice_feb2025.repo.inheritance.TestStringRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestStringService {
    @Autowired
    TestStringRepo testStringRepo;

   public List<TestString> getDataById(int id)
   {

      // Object[] result = testStringRepo.findTestById(1);
      // System.out.println(result[0]);
      // return testStringRepo.findById(id).get();
        List<TestString> list= testStringRepo.findTestStringById(id);
        return list;
   }

   public TestString saveObject(TestString testString){
       return testStringRepo.save(testString);
   }


}
