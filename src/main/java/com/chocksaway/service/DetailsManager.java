package com.chocksaway.service;

import com.chocksaway.domain.Detail;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * Author milesd on 27/04/2019.
 */

@Service
public class DetailsManager {
	private Map<String, Detail> details;

	public DetailsManager() {
		details = new HashMap<>();
	}

	public Detail getDetail(String name) {
		return details.get(name);
	}

	public void saveDetail(Detail detail) {
	    details.put(detail.getName(), detail);
    }

}
