package com.hivetech.service.implement;

import com.hivetech.entity.Category;
import com.hivetech.exception.CustomException;
import com.hivetech.repository.CategoryRepository;
import com.hivetech.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(long id) {
        Category category = categoryRepository.findByCategoryId(id);
        if (category == null) {
            throw new CustomException("Data Category not valid");
        }
        return category;
    }

    @Override
    public void addCategory(Category category) {
        Category findCategory = categoryRepository.findByName(category.getName());
        if (findCategory == null) {
            categoryRepository.save(category);
        } else {
            throw new CustomException("Category Exist");
        }
    }
}
