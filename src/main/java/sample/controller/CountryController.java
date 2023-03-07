package sample.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.repositories.CountryJdbcRepository;

import sample.repositories.CountryRepository;

@CrossOrigin
@RestController
class CountryController {

    @Autowired
    CountryRepository rep;

    @Autowired
    CountryJdbcRepository jdbc;

    @GetMapping("/jpa")
    public Object jpa() {
        return rep.getAll();
    }
 
    @GetMapping("/jdbc")
    public Object jdbc() throws SQLException {
        return jdbc.getAll();
    }
}
