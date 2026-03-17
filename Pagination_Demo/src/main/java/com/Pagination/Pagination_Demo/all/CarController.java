package com.Pagination.Pagination_Demo.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	private Car_Repo repo;

	@PostMapping("/add-cars")
	public Car addcars(@RequestBody Car car) {

		return repo.save(car);

	}

	@GetMapping("/get-all")
	public Page<Car> getall(@RequestParam(value = "number") int number, @RequestParam(value = "size") int size,
			@RequestParam(value = "field") String field, @RequestParam(value = "direction") String direction) {
//		Sort sor;
//		if(direction.startsWith("d") ||direction.startsWith("D"))
//		{
//		Sort sort=Sort.by(Sort.Direction.DESC,field);
//		sor=sort;
//		}
//		else
//		{
//			Sort sort=Sort.by(Sort.Direction.ASC,field);
//			sor=sort;
//		}

		Sort sort = direction.startsWith("d") ? Sort.by(Sort.Direction.DESC, field)
				: Sort.by(Sort.Direction.ASC, field);

		Pageable pageable = PageRequest.of(number, size, sort);

		return repo.findAll(pageable);
	}
}
