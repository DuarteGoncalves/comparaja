package com.comparaja.product.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.comparaja.product.dto.ProductDTO;
import com.comparaja.product.persistence.ProductPersistence;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductBusiness {

    @Autowired
    private ProductPersistence persistence;

    public Object getChallengeQuery() {
        List<Map<String, Object>> products = new ArrayList<>();
        for (String result : persistence.getChallengeQuery()) {
            products.add(new JSONObject(result).toMap());
        }
        return products;
    }

    public List<ProductDTO> getProducts(Integer minDownloadSpeed, Integer minMobilePhoneData, Integer phones,
            Integer maxPrice) {
        return persistence.getProducts(minDownloadSpeed, minMobilePhoneData, phones, maxPrice);
    }
}
