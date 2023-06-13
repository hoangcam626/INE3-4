package com.hivetech.controller;

import com.hivetech.entity.Category;
import com.hivetech.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String addCategory() {
        return "private/admin/category";
    }

    @RequestMapping(value = "/api/v1/category", method = RequestMethod.POST)
    public ResponseEntity createCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(201).build();
    }
}