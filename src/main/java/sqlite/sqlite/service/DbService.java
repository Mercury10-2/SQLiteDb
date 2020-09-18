package sqlite.sqlite.service;

import java.util.List;

import sqlite.sqlite.payload.RequestDto;
import sqlite.sqlite.payload.ResponseDto;

public interface DbService {
    
    List<ResponseDto> queryDb(RequestDto input);
    
}
