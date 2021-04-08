package com.comparaja.product.service;

import java.util.List;

import com.comparaja.product.business.ProductBusiness;
import com.comparaja.product.dto.ProductDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequestMapping
public class ProductService {

  @Autowired
  private ProductBusiness business;

  @GetMapping()
  public Object getChallengeQueryResults() {
    Object response = business.getChallengeQuery();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/product")
  public Object getProducts(@RequestParam(name = "min_download_speed", required = false) Integer minDownloadSpeed,
      @RequestParam(name = "min_mobile_phone_data", required = false) Integer minMobilePhoneData,
      @RequestParam(name = "phones", required = false) Integer phones,
      @RequestParam(name = "max_price", required = false) Integer maxPrice) {
    try {
      List<ProductDTO> response = business.getProducts(minDownloadSpeed, minMobilePhoneData, phones, maxPrice);
      return new ResponseEntity<>(response, response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>("Could not process your request", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
