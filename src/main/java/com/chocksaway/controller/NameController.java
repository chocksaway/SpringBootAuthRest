package com.chocksaway.controller;

import com.chocksaway.domain.Name;
import com.chocksaway.exception.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author milesd on 28/04/2019.
 */

@RestController
public class NameController {

    @PostMapping("/name")
    public String saveItem(@RequestBody Name name) {
        if (name == null) {
            throw new BadRequestException("Name is invalid");
        }
        return name.toString();
    }
}
