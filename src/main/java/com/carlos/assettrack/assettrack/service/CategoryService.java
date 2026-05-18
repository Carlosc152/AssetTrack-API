package com.carlos.assettrack.assettrack.service;

import com.carlos.assettrack.assettrack.dto.CategoryDTO;
import com.carlos.assettrack.assettrack.exception.ResourceNotFoundException;
import com.carlos.assettrack.assettrack.mapper.CategoryMapper;
import com.carlos.assettrack.assettrack.model.Asset;
import com.carlos.assettrack.assettrack.model.Category;
import com.carlos.assettrack.assettrack.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    //Metodo para obtener todas las categorias
    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .toList();
    }

    //Metodo para obtener un metodo por id
    @Override
    public Category getCategoryById(Long id) {

        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category no encontrado con id " + id));
    }

    //Metodo para guardar un categoria
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    //Metodo para eliminar una categoria
    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);

    }
}
