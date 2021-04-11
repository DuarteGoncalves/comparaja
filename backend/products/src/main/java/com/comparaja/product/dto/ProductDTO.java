package com.comparaja.product.dto;

import java.util.Map;

public class ProductDTO {
    private Long id;
    private String providerName;
    private String providerLogoURL;
    private Boolean isSponsored;
    private Map<String, Object> data;

    public ProductDTO(Long id, String providerName, String providerLogoURL, Boolean isSponsored,
            Map<String, Object> data) {
        this.id = id;
        this.providerName = providerName;
        this.providerLogoURL = providerLogoURL;
        this.isSponsored = isSponsored;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getIsSponsored() {
        return isSponsored;
    }

    public void setIsSponsored(Boolean isSponsored) {
        this.isSponsored = isSponsored;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    
}
