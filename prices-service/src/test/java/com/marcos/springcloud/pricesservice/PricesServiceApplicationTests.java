package com.marcos.springcloud.pricesservice;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PricesServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	/**
	 * Case 1 - request at 10:00 on the 14th of the day for product 35455 for brand 1 (CARREFOUR)
	 * Inputs:
	 	-productId = 35455
	 	-brandId = 1
	 	-date = 2020-06-14-10.00.00
	 * PriceList Id Expected: 1
	 * @throws Exception
	 */
	@Test
	void test1() throws Exception {
		
		String priceListIdExpected = "1";
		
		String url = "/api/prices?productId=35455&brandId=1&date=2020-06-14-10.00.00";
		
		testWithURLAndPriceListId(url, priceListIdExpected);
	}
	
	/**
	 * Case 2 - request at 16:00 on the 14th of the day of the product 35455 for brand 1 (CARREFOUR)
	 * Inputs:
	 	-productId = 35455
	 	-brandId = 1
	 	-date = 2020-06-14-16.00.00
	 * PriceList Id Expected: 2
	 * @throws Exception
	 */

	@Test
	void test2() throws Exception {

		String priceListIdExpected = "2";
		
		String url = "/api/prices?productId=35455&brandId=1&date=2020-06-14-16.00.00";
		
		testWithURLAndPriceListId(url, priceListIdExpected);
	}
	
	/**
	 * Case 3 - request at 21:00 on the 14th of the day of the product 35455 for brand 1 (CARREFOUR)
	 * Inputs:
	 	-productId = 35455
	 	-brandId = 1
	 	-date = 2020-06-14-21.00.00
	 * PriceList Id Expected: 1
	 * @throws Exception
	 */

	@Test
	void test3() throws Exception {

		String priceListIdExpected = "1";
		
		String url = "/api/prices?productId=35455&brandId=1&date=2020-06-14-21.00.00";
		
		testWithURLAndPriceListId(url, priceListIdExpected);
	}
	
	/**
	 * Case 4 - request at 10:00 on the 15th of the day of the product 35455 for brand 1 (CARREFOUR)
	 * Inputs:
	 	-productId = 35455
	 	-brandId = 1
	 	-date = 2020-06-15-10.00.00
	 * PriceList Id Expected: 3
	 * @throws Exception
	 */

	@Test
	void test4() throws Exception {

		String priceListIdExpected = "3";
		
		String url = "/api/prices?productId=35455&brandId=1&date=2020-06-15-10.00.00";
		
		testWithURLAndPriceListId(url, priceListIdExpected);
	}
	
	/**
	 * Case 5 - request at 21:00 on the 16th of the day of the product 35455 for brand 1 (CARREFOUR)
	 * Inputs:
	 	-productId = 35455
	 	-brandId = 1
	 	-date = 2020-06-16-21.00.00
	 * PriceList Id Expected: 4
	 * @throws Exception
	 */

	@Test
	void test5() throws Exception {
		
		String priceListIdExpected = "4";
		
		String url = "/api/prices?productId=35455&brandId=1&date=2020-06-16-21.00.00";

		testWithURLAndPriceListId(url, priceListIdExpected);
	}
	
	private void testWithURLAndPriceListId(String url, String priceListIdExpected) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.priceList").value(priceListIdExpected));
	}

}
