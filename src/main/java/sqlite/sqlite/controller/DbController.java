package sqlite.sqlite.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sqlite.sqlite.payload.RequestDto;
import sqlite.sqlite.payload.ResponseDto;
import sqlite.sqlite.service.DbService;

@RestController
@RequestMapping("/")
public class DbController {

    private final DbService service;

    public DbController(DbService service) {
        this.service = service;
    }

    @GetMapping("{input}")
    public List<ResponseDto> queryDb(@PathVariable(name = "input") String input) {
        return service.queryDb(new RequestDto(input));
    }
}
