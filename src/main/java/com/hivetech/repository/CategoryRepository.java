package com.hivetech.repository;

import com.hivetech.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);

    Category findByCategoryId(Long categoryId);
}
