package com.ousl.shopmarketapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ousl.shopmarketapp.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "USED DDR3 4GB", 2500, true, "https://mdcomputers.lk/wp-content/uploads/2023/01/1GB-D3-1.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "USED 500GB", 3400, true, "https://newlinecomputers.lk/wp-content/uploads/2023/01/Untitled-1.png"));
        productList.add(new Product(UUID.randomUUID().toString(), "USED 550W", 3500, true, "https://hwbusters.com/wp-content/uploads/2022/12/psu_top1-3-1024x576.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "USED I7 3770", 15000, false, "https://m.media-amazon.com/images/I/61SSfFDCleL.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "USED 775", 1000, true, "https://mdcomputers.lk/wp-content/uploads/2023/02/3d2f03be02aeb6bed156b29f0ed7b284.png"));
        productList.add(new Product(UUID.randomUUID().toString(), "USED 19inch", 12500, true, "https://zentech.lk/wp-content/uploads/2020/07/DELL-19-inch-Wide-LCD-Monitor-E1911c.png"));
        productList.add(new Product(UUID.randomUUID().toString(), "RAIDMAX X616 ARGB", 18000, true, "https://www.gamestreet.lk/images/products/2946.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "MOFII WIRELESS", 750, true, "https://sapcomputers.lk/wp-content/uploads/2022/11/04-mofii-go18.jpg?v=1667974723"));
        productList.add(new Product(UUID.randomUUID().toString(), "JEDEL K518", 1800, true, "https://mobileparts.lk/wp-content/uploads/2022/12/k518-800x800-1.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "LOGITECH BRIO 4K", 70000, true, "https://www.gcentre.lk/wp-content/uploads/2022/02/Logitech-Brio-4K-Webcam-03.jpg"));
        mutableProductList.setValue(productList);
    }
}

