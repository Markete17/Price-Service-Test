package com.marcos.springcloud.pricesservice.models.responses;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceResponse {

	private static final DecimalFormat df = new DecimalFormat("0.00");

	private Long priceList;

	private Long productId;

	private Long brandId;

	private Date startDate;

	private Date endDate;

	private Date applicationDate;

	private String finalPrice;

	public PriceResponse(Long priceList, Long productId, Long brandId, Date startDate, Date endDate,
			String applicationDate, Double finalPrice, String curr) throws ParseException {
		super();
		this.priceList = priceList;
		this.productId = productId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		Date dater = formatter.parse(applicationDate);
		java.sql.Timestamp timeStampDate = new Timestamp(dater.getTime());
		this.applicationDate = timeStampDate;
		this.finalPrice = df.format(finalPrice) + " " + curr;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
}
