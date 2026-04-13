package com.carlos.assettrack.assettrack.repository;

import com.carlos.assettrack.assettrack.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

}
