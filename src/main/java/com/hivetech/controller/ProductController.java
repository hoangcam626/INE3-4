package com.hivetech.controller;

import com.hivetech.dto.CreateProductDto;
import com.hivetech.entity.Category;
import com.hivetech.entity.Product;
import com.hivetech.service.interfaces.CategoryService;
import com.hivetech.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView showCreateProduct() {
        ModelAndView model = new ModelAndView("private/admin/product");
        List<Category> categories = categoryService.getCategories();
        model.addObject("categories", categories);
        return model;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(
            @RequestParam("image") MultipartFile img,
            @RequestParam("name") String name,
            @RequestParam("category") int categoryId,
            @RequestParam("price") float price,
            @RequestParam("shortDescription") String shortDescription,
            @RequestParam("status") String status) throws IOException {
        CreateProductDto productDto = CreateProductDto.builder()
                .image(img)
                .name(name)
                .categoryId(categoryId)
                .price(price)
                .shortDescription(shortDescription)
                .status(status).build();

        productService.addProduct(productDto);
        return ResponseEntity.status(201).build();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getViewProducts() {
        return "private/admin/list-products";
    }

    @RequestMapping(value = "/api/v1/products", method = RequestMethod.GET)
    public ResponseEntity getProducts(@RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Product> products = productService.getAllProducts(pageNo, pageSize);
        return ResponseEntity.ok(products);
    }
}