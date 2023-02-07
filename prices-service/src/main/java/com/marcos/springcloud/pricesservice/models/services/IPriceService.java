package com.marcos.springcloud.pricesservice.models.services;

import java.util.List;

import com.marcos.springcloud.pricesservice.models.entities.Price;

public interface IPriceService {

	public List<Price> getPriceByDateAndProductAndBrand(String date, Long productId, Long brandId);

}
