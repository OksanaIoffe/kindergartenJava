import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Kindergarten {
    private Connection connection;
    private List<Group> groups;

    public Kindergarten() {
        groups = new ArrayList<>();
        initializeDatabase();
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:kindergarten.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGroup(String name, int number) {
        try {
            Group group = new Group(name, number);
            groups.add(group);
            String sql = "INSERT INTO groups (name, number) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, number);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addChildToGroup(String groupName, Child child) {
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                group.addChild(child);
                saveChildToDatabase(child, groupName);
                return;
            }
        }
        System.out.println("Группа не найдена: " + groupName);
    }

    private void saveChildToDatabase(Child child, String groupName) {
        try {
            String sql = "SELECT id FROM groups WHERE name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, groupName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int groupId = rs.getInt("id");
                sql = "INSERT INTO children (fullName, gender, age, groupId) VALUES (?, ?, ?, ?)";
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, child.getFullName());
                pstmt.setString(2, child.getGender());
                pstmt.setInt(3, child.getAge());
                pstmt.setInt(4, groupId);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void displayGroups() {
        for (Group group : groups) {
            System.out.println("Группа: " + group.getName() + " (Номер: " + group.getNumber() + ")");
            for (Child child : group.getChildren()) {
                System.out.println("   Ребенок: " + child.getFullName() + ", Пол: " + child.getGender() + ", Возраст: " + child.getAge());
            }
        }
    }
}
