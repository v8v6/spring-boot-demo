package com.example.springbootdemo.dynamic.datasource;

import com.baomidou.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomJdbcDataSourceProvider extends AbstractJdbcDataSourceProvider {



  public CustomJdbcDataSourceProvider(String driverClassName, String url, String username,
      String password) {
    super(driverClassName, url, username, password);
  }

  @Override
  protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
    // xx: DataSourceProperty
    ResultSet rs = statement.executeQuery("SELECT * FROM data_source");
    Map<String, DataSourceProperty> dataSourcePropertiesMap = new HashMap<>();
    while (rs.next()) {
      String platform = rs.getString("platform");
      String userMame = rs.getString("user_name");
      String password = rs.getString("password");
      String url = rs.getString("url");
      DataSourceProperty dataSourceProperty = new DataSourceProperty();
      dataSourceProperty.setUrl(url);
      dataSourceProperty.setPassword(password);
      dataSourceProperty.setUsername(userMame);
      dataSourceProperty.setDriverClassName("com.mysql.cj.jdbc.Driver");
      dataSourcePropertiesMap.put(platform, dataSourceProperty);
    }
    return dataSourcePropertiesMap;
  }
}
