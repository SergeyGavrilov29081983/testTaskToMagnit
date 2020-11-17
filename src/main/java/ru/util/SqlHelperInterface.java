package ru.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlHelperInterface <T> {

    T execute(PreparedStatement preparedStatement) throws SQLException;
}
