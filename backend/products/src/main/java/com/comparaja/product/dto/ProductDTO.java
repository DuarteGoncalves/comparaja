package com.comparaja.product.dto;

import java.util.Map;

public class ProductDTO {
    private String providerName;
    private String providerLogoURL;
    private Map<String, Object> data;

    public ProductDTO(String providerName, String providerLogoURL, Map<String, Object> data) {
        this.providerName = providerName;
        this.providerLogoURL = providerLogoURL;
        this.data = data;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderLogoURL() {
        return providerLogoURL;
    }

    public void setProviderLogoURL(String providerLogoURL) {
        this.providerLogoURL = providerLogoURL;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}
