package sprint10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/softserve_test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }

    // public Connection createConnection() throws SQLException {
    //        DriverManager.registerDriver(new org.h2.Driver());
    //        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
    //        return connection;
    //    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        return statement = connection.createStatement();
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS " + schemaName + ";");
    }

    public void dropSchema() throws SQLException {
        statement.executeUpdate("DROP SCHEMA IF EXISTS " + schemaName + ";");
    }

    public void useSchema() throws SQLException {
        statement.execute("USE " + schemaName + ";");
    }

    public void createTableRoles() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS roles(" +
                "id int NOT NULL AUTO_INCREMENT, " +
                "roleName VARCHAR(256), " +
                "PRIMARY KEY (id))");
    }

    public void createTableDirections() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS directions(" +
                "id int NOT NULL AUTO_INCREMENT, " +
                "directionName VARCHAR(256), " +
                "PRIMARY KEY (id))");
    }

    public void createTableProjects() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS projects(" +
                "id int NOT NULL AUTO_INCREMENT, " +
                "projectName VARCHAR(256), " +
                "directionId int, " +
                "PRIMARY KEY (id), " +
                "CONSTRAINT projects_directions_id_fk FOREIGN KEY (directionId) REFERENCES directions(id));");
    }

    public void createTableEmployee() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee(" +
                "id int NOT NULL AUTO_INCREMENT, " +
                "firstName VARCHAR(256), " +
                "roleId int, " +
                "projectId int, " +
                "PRIMARY KEY (id), " +
                "CONSTRAINT employee_roles_id_fk FOREIGN KEY (roleId) REFERENCES roles(id)," +
                "CONSTRAINT employee_project_id_fk FOREIGN KEY (projectId) REFERENCES projects(id));");
    }

    public void dropTable(String tableName) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
    }

    public void insertTableRoles(String roleName) throws SQLException {
        statement.executeUpdate("INSERT INTO roles(roleName) VALUES ('" + roleName + "');");
    }

    public void insertTableDirections(String directionName) throws SQLException {
        statement.executeUpdate("INSERT INTO directions(directionName) VALUES ('" + directionName + "');");
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        statement.executeUpdate("INSERT INTO projects(projectName, directionId) VALUES ('" +
                projectName + "', " + getDirectionId(directionName) + ");");
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        statement.executeUpdate("INSERT INTO employee(firstName, roleId, projectId) VALUES ('" +
                firstName + "', " + getRoleId(roleName) + ", " + getProjectId(projectName) + ");");
    }

    public int getRoleId(String roleName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM roles WHERE roleName='" + roleName + "';");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getDirectionId(String directionName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM directions WHERE directionName='" + directionName + "';");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getProjectId(String projectName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM projects WHERE projectName='" + projectName + "';");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public int getEmployeeId(String firstName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM employee WHERE firstName='" + firstName + "';");
        resultSet.next();
        return resultSet.getInt("id");
    }

    public List<String> getAllRoles() throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT roleName FROM roles;");

        while (resultSet.next()) {
            result.add(resultSet.getString("roleName"));
        }
        return result;
    }

    public List<String> getAllDirestion() throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT directionName FROM directions;");

        while (resultSet.next()) {
            result.add(resultSet.getString("directionName"));
        }
        return result;
    }

    public List<String> getAllProjects() throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT projectName FROM projects;");

        while (resultSet.next()) {
            result.add(resultSet.getString("projectName"));
        }
        return result;
    }

    public List<String> getAllEmployee() throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT firstName FROM employee;");

        while (resultSet.next()) {
            result.add(resultSet.getString("firstName"));
        }
        return result;
    }

    public List<String> getAllDevelopers() throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT firstName FROM employee WHERE roleId=" +
                getRoleId("Developer") + ";");

        while (resultSet.next()) {
            result.add(resultSet.getString("firstName"));
        }
        return result;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT projectName FROM projects WHERE directionId=" +
                getDirectionId("Java") + ";");

        while (resultSet.next()) {
            result.add(resultSet.getString("projectName"));
        }
        return result;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("SELECT firstName FROM employee " +
                "INNER JOIN projects ON employee.projectId=projects.id " +
                "INNER JOIN directions on projects.directionId = directions.id " +
                "WHERE directionId=" + getDirectionId("Java") +
                " AND roleId=" + getRoleId("Developer") + ";");

        while (resultSet.next()) {
            result.add(resultSet.getString("firstName"));
        }
        return result;
    }


    public static void main(String[] args) {
        try {
            MyUtils myUtils = new MyUtils();
            myUtils.schemaName = "softserve_test";
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.dropSchema();
            myUtils.createSchema("softserve_test");
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployee();

            myUtils.insertTableDirections("dir1");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableDirections("C");

            myUtils.insertTableRoles("rol1");
            myUtils.insertTableRoles("Developer");

            myUtils.insertTableProjects("proj1", "dir1");
            myUtils.insertTableProjects("proj2", "Java");
            myUtils.insertTableProjects("proj3", "Java");
            myUtils.insertTableProjects("proj4", "C");

            myUtils.insertTableEmployee("name1", "rol1", "proj1");
            myUtils.insertTableEmployee("name2", "Developer", "proj2");
            myUtils.insertTableEmployee("name3", "Developer", "proj3");
            myUtils.insertTableEmployee("name4", "Developer", "proj4");
            myUtils.insertTableEmployee("name5", "rol1", "proj4");


            System.out.println("roles " + myUtils.getAllRoles());
            System.out.println("employee " + myUtils.getAllEmployee());
            System.out.println("directions " + myUtils.getAllDirestion());

            System.out.println("developers " + myUtils.getAllDevelopers());
            System.out.println("java projects " + myUtils.getAllJavaProjects());
            System.out.println("java developers " + myUtils.getAllJavaDevelopers());

            myUtils.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
