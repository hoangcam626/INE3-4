package com.hivetech.service.interfaces;

import com.hivetech.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getCategories();

    Category getCategory(long id);

    void addCategory(Category category);
}
