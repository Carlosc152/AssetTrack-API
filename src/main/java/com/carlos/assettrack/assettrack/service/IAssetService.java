package com.carlos.assettrack.assettrack.service;

import com.carlos.assettrack.assettrack.model.Asset;

import java.util.List;

public interface IAssetService {

    public List<Asset> getAllAssets();
    public Asset getAssetById(Long id);
    public Asset saveAsset(Asset asset);
    public void deleteAssetById(Long id);

}
