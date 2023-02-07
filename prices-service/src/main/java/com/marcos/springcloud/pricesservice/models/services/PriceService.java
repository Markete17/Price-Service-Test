package com.marcos.springcloud.pricesservice.models.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.springcloud.pricesservice.models.entities.Price;
import com.marcos.springcloud.pricesservice.models.repositories.PriceRepository;

@Service
public class PriceService implements IPriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public List<Price> getPriceByDateAndProductAndBrand(String date, Long productId, Long brandId) {

		String pattern = "yyyy-MM-dd-HH.mm.ss";

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			Date dater = formatter.parse(date);
			java.sql.Timestamp timeStampDate = new Timestamp(dater.getTime());

			return this.priceRepository
					.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProduct_IdAndBrand_IdOrderByPriorityDesc(
							timeStampDate, timeStampDate, productId, brandId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
