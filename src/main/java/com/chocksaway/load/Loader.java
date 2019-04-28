package com.chocksaway.load;

import com.chocksaway.domain.Detail;
import com.chocksaway.service.DetailsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Author milesd on 27/04/2019.
 */
@Component
public class Loader implements CommandLineRunner {
    @Autowired
    DetailsManager detailsManager;

    private final Logger logger = LoggerFactory.getLogger(Loader.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Loading details data...");

        detailsManager.saveDetail(new Detail("username", new BCryptPasswordEncoder().encode("password")));
    }
}
