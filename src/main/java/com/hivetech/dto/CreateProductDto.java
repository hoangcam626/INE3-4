package com.hivetech.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateProductDto {
    private MultipartFile image;
    private String name;
    private int categoryId;
    private float price;
    private String shortDescription;
    private String status;
}
