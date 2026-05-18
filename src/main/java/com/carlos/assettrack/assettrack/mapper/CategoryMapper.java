package com.carlos.assettrack.assettrack.mapper;

import com.carlos.assettrack.assettrack.dto.CategoryDTO;
import com.carlos.assettrack.assettrack.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // De Entidad a DTO (Para cuando enviamos datos al cliente)
    CategoryDTO toDTO(Category category);

    // De DTO a Entidad (Para cuando recibimos datos del cliente y queremos operar en BD)
    Category toEntity(CategoryDTO categoryDTO);
}