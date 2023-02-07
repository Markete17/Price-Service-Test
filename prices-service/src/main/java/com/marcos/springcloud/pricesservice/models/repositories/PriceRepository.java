package com.marcos.springcloud.pricesservice.models.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.marcos.springcloud.pricesservice.models.entities.Price;

public interface PriceRepository extends CrudRepository<Price, Long> {

	// Spring Data JPA
	List<Price> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProduct_IdAndBrand_IdOrderByPriorityDesc(
			Timestamp startDate, Timestamp endDate, Long productId, Long brandId);

	// Spring Data JPA @Query Method
	@Query("select p from Price p where p.startDate<=?1 and p.endDate>=?2 and p.product.id=?3 and p.brand.id=?4 order by p.priority desc")
	List<Price> findByDate(Timestamp startDate, Timestamp endDate, Long productId, Long brandId);

}
