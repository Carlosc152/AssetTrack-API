package com.carlos.assettrack.assettrack.service;

import com.carlos.assettrack.assettrack.exception.ResourceNotFoundException;
import com.carlos.assettrack.assettrack.model.Asset;
import com.carlos.assettrack.assettrack.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService implements IAssetService{

    @Autowired
    private AssetRepository assetRepository;


    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long id) {

        return assetRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Asset no encontrado con id " + id));
    }

    @Override
    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public void deleteAssetById(Long id) {
        assetRepository.deleteById(id);

    }
}
