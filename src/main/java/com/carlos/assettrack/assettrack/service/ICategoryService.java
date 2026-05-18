package com.carlos.assettrack.assettrack.service;
import com.carlos.assettrack.assettrack.dto.CategoryDTO;
import com.carlos.assettrack.assettrack.model.Category;

import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getAllCategories();
    public Category getCategoryById(Long id);
    public Category saveCategory(Category category);
    public void deleteCategoryById(Long id);
}
