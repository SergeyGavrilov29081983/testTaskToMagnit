package ru.repository;

import ru.model.Model;
import ru.util.SqlHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Repository {

    private final SqlHelper sqlHelper;
    private static final Logger LOGGER = Logger.getLogger(Repository.class.getName());


    public Repository(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clear() throws SQLException {
        LOGGER.info("storage clear");
        sqlHelper.execute("DELETE FROM test");
    }

    public void save(Model model) throws SQLException {
        LOGGER.info("model saved " + model);
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO test (id, field) VALUES (?, ?)")) {
                ps.setString(1, model.getId());
                ps.setInt(2, model.getField());
                ps.execute();
            }
            return null;
        });
    }

    public List<Model> getAll() throws SQLException {
        LOGGER.info("All models are get");
        return sqlHelper.transactionalExecute(conn -> {
            List<Model> models = new ArrayList<>();
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM test")) {
                ResultSet rs = ps.executeQuery();
                ps.setFetchSize(100);
                while (rs.next()) {
                    int field = rs.getInt("field");
                    models.add(new Model(field));
                }
            }
            return models;
        });
    }

}
