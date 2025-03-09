package org.example.productcatalogservice_feb2025.Service;

import org.example.productcatalogservice_feb2025.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public boolean deleteCategory(long id) {

        if(categoryRepo.existsById(id)) {
            //deletes the category and all products
            categoryRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
