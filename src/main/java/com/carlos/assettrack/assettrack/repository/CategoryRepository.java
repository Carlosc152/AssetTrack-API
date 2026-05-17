package com.carlos.assettrack.assettrack.repository;

import com.carlos.assettrack.assettrack.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
