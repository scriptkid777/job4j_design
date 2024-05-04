package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;


    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }


    private void initConnection() throws Exception {
        if (connection == null) {
            try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
                properties.load(in);
                Class.forName(properties.getProperty("driver-class-name"));
                String url = properties.getProperty("url");
                String login = properties.getProperty("login");
                String password = properties.getProperty("password");
                connection = DriverManager.getConnection(url, login, password);
            }
        }
    }




    public void createTable(String tableName) throws Exception {
        String query = String.format("CREATE TABLE IF NOT EXISTS %s();", tableName);
        initStatement(query);
        System.out.println(getTableScheme(connection, "stats"));
    }





    public String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }



    private void initStatement(String query) throws Exception {
        try  (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public void dropTable(String tableName) throws Exception {
        String query = String.format("drop table %s;", tableName);
        initStatement(query);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        initStatement(String.format("alter table %s add column %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        initStatement(String.format("alter table %s drop column %s;",
                tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        initStatement(String.format("alter table %s rename column %s to %s;",
                tableName, columnName, newColumnName));
    }




    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties());
        tableEditor.createTable("stats");
        tableEditor.addColumn("stats", "id", "serial primary key");
        tableEditor.addColumn("stats", "name", "varchar(33)");
        tableEditor.addColumn("stats", "test", "varchar(33)");
        tableEditor.addColumn("stats", "time", "int");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "stats"));
        tableEditor.renameColumn("stats", "time", "vremya");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "stats"));
        tableEditor.dropColumn("stats", "vremya");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "stats"));
        tableEditor.dropTable("stats");
    }

}
