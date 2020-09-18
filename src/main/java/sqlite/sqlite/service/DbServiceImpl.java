package sqlite.sqlite.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sqlite.sqlite.payload.RequestDto;
import sqlite.sqlite.payload.ResponseDto;

@Service
public class DbServiceImpl implements DbService {

    private Connection connect() {
        String url = "jdbc:sqlite:src/main/resources/data.sqlite";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private String query(String row, String col) {
        StringBuilder sb = new StringBuilder();
        sb
            .append("select ")
            .append(row)
            .append(", ")
            .append(col)
            .append(", v FROM source_data order by ")
            .append(row)
            .append(" asc");
        return sb.toString();
    }

    public List<ResponseDto> queryDb(RequestDto input) {
        List<ResponseDto> result = new ArrayList<>();
        String query = query(input.getRow(), input.getCol());
        try (
                Connection connection = this.connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next())
                result.add(getDbInput(resultSet, input.getRow(), input.getCol()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private ResponseDto getDbInput(ResultSet resultSet, String row, String col) throws SQLException {
        return new ResponseDto(
                getSingleValue(resultSet, row),
                getSingleValue(resultSet, col),
                String.valueOf(resultSet.getLong("v")));
    }

    private String getSingleValue(ResultSet resultSet, String value) throws SQLException {
        switch(value) {
            case "y":
                return String.valueOf(resultSet.getInt(value));
            default:
                return resultSet.getString(value);
        }
    }
}
