package com.chocksaway.service;

import com.chocksaway.domain.Detail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author milesd on 27/04/2019.
 */

@Service
public class DetailsManager {
	Logger logger = LoggerFactory.getLogger(DetailsManager.class);

	private Map<String, Detail> details;

	public DetailsManager() {
		details = new HashMap<>();
	}

	public void addDetail(String name, String password) {
		details.put(name, new Detail(name, password));
	}

	public void deleteDetail(String name) {
		details.remove(name);
	}

	public List<Detail> getDetails() {
		return new ArrayList(details.values());
	}

	public Detail getDetail(String name) {
		return details.get(name);
	}

	public void saveDetail(Detail detail) {
	    details.put(detail.getName(), detail);
    }

}
