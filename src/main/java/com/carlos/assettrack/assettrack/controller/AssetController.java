package com.carlos.assettrack.assettrack.controller;

import com.carlos.assettrack.assettrack.model.Asset;
import com.carlos.assettrack.assettrack.service.IAssetService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("asset-app")
@CrossOrigin(value = "http://localhost:3000")
public class AssetController {

    private static final Logger logger = LoggerFactory.getLogger(AssetController.class);

    @Autowired
    private IAssetService AssetService;

    // Obtener todos los activos: GET http://localhost:8080/asset-app/assets
    @GetMapping("/assets")
    public List<Asset> getAssets(){
        List<Asset> assets = AssetService.getAllAssets();
        assets.forEach(asset -> logger.info(asset.toString()));
        return assets;
    }
    // Guardar un producto http://localhost:8080/asset-app/assets
    @PostMapping("assets")
    public Asset addAsset(@Valid @RequestBody Asset asset){
        logger.info("Asset to add: " + asset);
        return AssetService.saveAsset(asset);
    }

    //Obtener un producto por Id http://localhost:8080/asset-app/assets/{id}
    @GetMapping("assets/{id}")
        public Asset getAssetById(@PathVariable Long id){
        logger.info("Asset to get: " + id);
        return AssetService.getAssetById(id);
    }

    //Eliminar un producto por Id http://localhost:8080/asset-app/assets/{id}
    @DeleteMapping("assets/{id}")
    public void deleteAssetById(@PathVariable Long id){
        logger.info("Asset to delete: " + id);
        AssetService.deleteAssetById(id);
    }



}
