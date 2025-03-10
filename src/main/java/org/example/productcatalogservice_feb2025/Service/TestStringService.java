package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.models.TestString;
import org.example.productcatalogservice_feb2025.repo.TestStringRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class TestStringService {
    @Autowired
    TestStringRepo testStringRepo;

   public TestString getDataById(int id)
   {

       Object[] result = testStringRepo.findTestById(1);
      // System.out.println(result[0]);
       return testStringRepo.findById(id).get();
   }

   public TestString saveObject(TestString testString){
       return testStringRepo.save(testString);
   }


}
