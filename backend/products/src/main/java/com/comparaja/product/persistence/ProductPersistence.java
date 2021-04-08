package com.comparaja.product.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.comparaja.product.dto.ProductDTO;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductPersistence {

    private static final String challengeQuery = "SELECT prod.data FROM products prod INNER JOIN providers prov ON prod.provider_id = prov.id WHERE prov.is_active AND prod.data -> 'internet_download_speed_in_mbs' IS NOT NULL ";
    private static final String productQuery = "SELECT prov.name as providerName, prov.logo_url as providerLogoURL, prod.data AS json FROM products prod INNER JOIN providers prov ON prod.provider_id = prov.id WHERE prov.is_active AND prod.data -> 'internet_download_speed_in_mbs' IS NOT NULL ";
   
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ProductDTO buildProductDTO(String providerName, String providerLogoURL, String json) {
        Map<String, Object> data = new JSONObject(json).toMap();
        return new ProductDTO(providerName, providerLogoURL, data);
    }

    public List<String> getChallengeQuery() {
        List<String> results = jdbcTemplate.queryForList(challengeQuery, String.class);
        return results;
    }

    public List<ProductDTO> getProducts(Integer minDownloadSpeed, Integer minMobilePhoneData, Integer phones,
            Integer maxPrice) {
        String filterQuery = productQuery;
        List<Object> argsList = new ArrayList<>();
        if (minDownloadSpeed != null) {
            filterQuery = filterQuery + "AND CAST ( prod.data ->> 'internet_download_speed_in_mbs' AS Integer ) >= $1 ";
            argsList.add(minDownloadSpeed);
        }
        if (minMobilePhoneData != null) {
            filterQuery = filterQuery + "AND CAST ( prod.data ->> 'mobile_phone_data_in_gbps' AS Integer ) >= ? ";
            argsList.add(minMobilePhoneData);
        }
        if (phones != null) {
            filterQuery = filterQuery + "AND CAST ( prod.data ->> 'mobile_phone_count' AS Integer ) = ? ";
            argsList.add(phones);
        }
        if (maxPrice != null) {
            filterQuery = filterQuery + "AND CAST ( prod.data ->> 'price' AS DOUBLE PRECISION ) < ? ";
            argsList.add(maxPrice);
        }
        Object[] argsArray = new Object[argsList.size()];
        argsArray = argsList.toArray(argsArray);
        List<ProductDTO> products = jdbcTemplate.query(filterQuery, argsArray,
                (rs, rowNum) -> buildProductDTO(rs.getString("providerName"), rs.getString("providerLogoURL"),
                        rs.getString("json")));
        return products;
    }
}
