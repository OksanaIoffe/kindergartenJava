
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KindergartenModel {
    private Connection connection;

    public KindergartenModel(String url, String user, String password) throws SQLException {

        connection = DriverManager.getConnection(url, user, password);
        createTables();
    }

    private void createTables() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS groups (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), number INT)");
        statement.execute("CREATE TABLE IF NOT EXISTS children (id INT AUTO_INCREMENT PRIMARY KEY, fullName VARCHAR(255), gender VARCHAR(10), age INT, groupId INT, FOREIGN KEY (groupId) REFERENCES groups(id))");
        statement.close();
    }

    public void addGroup(Group group) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO groups (name, number) VALUES (?, ?)");
        ps.setString(1, group.getName());
        ps.setInt(2, group.getNumber());
        ps.executeUpdate();
        ps.close();
    }

    public void addChild(Child child, int groupId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO children (fullName, gender, age, groupId) VALUES (?, ?, ?, ?)");
        ps.setString(1, child.getFullName());
        ps.setString(2, child.getGender());
        ps.setInt(3, child.getAge());
        ps.setInt(4, groupId);
        ps.executeUpdate();
        ps.close();
    }

    public List<Group> getGroups() throws SQLException {
        List<Group> groups = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM groups");

        while (rs.next()) {
            Group group = new Group(rs.getString("name"), rs.getInt("number"));
            groups.add(group);
            loadChildrenForGroup(group);
        }

        rs.close();
        statement.close();
        return groups;
    }

    private void loadChildrenForGroup(Group group) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM children WHERE groupId = ?");
        ps.setInt(1, group.getNumber()); // Используем номер группы как id
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Child child = new Child(rs.getString("fullName"), rs.getString("gender"), rs.getInt("age"));
            group.addChild(child);
        }

        rs.close();
        ps.close();
    }

    public void close() throws SQLException {
        connection.close();
    }
}


