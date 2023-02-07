package com.marcos.springcloud.pricesservice.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.springcloud.pricesservice.models.entities.Price;
import com.marcos.springcloud.pricesservice.models.responses.PriceResponse;
import com.marcos.springcloud.pricesservice.models.services.IPriceService;

@RestController
@RequestMapping(path = "/api")
public class PriceRestController {

	@Autowired
	private IPriceService priceService;

	@GetMapping("/prices")
	public ResponseEntity<?> getPrices(@RequestParam String date, Long productId, Long brandId) throws ParseException {
		List<Price> prices = this.priceService.getPriceByDateAndProductAndBrand(date, productId, brandId);

		if (prices.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Price price = prices.get(0); // Highest priority price - order by priority desc

			PriceResponse priceResponse = new PriceResponse(price.getPriceList(), price.getProduct().getId(),
					price.getBrand().getId(), price.getStartDate(), price.getEndDate(), date, price.getPrice(),
					price.getCurr());

			return new ResponseEntity<>(priceResponse, HttpStatus.OK);
		}

	}

}
