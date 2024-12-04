

import java.sql.SQLException;
import java.util.List;

public class KindergartenController {
    private KindergartenModel model;
    private KindergartenView view;

    public KindergartenController(KindergartenModel model, KindergartenView view) {
        this.model = model;
        this.view = view;
    }

    public void addGroup(String name, int number) throws SQLException {
        Group group = new Group(name, number);
        model.addGroup(group);
        view.displayMessage("Группа добавлена: " + group);
    }

    public void addChild(String fullName, String gender, int age, int groupId) throws SQLException {
        Child child = new Child(fullName, gender, age);
        model.addChild(child, groupId);
        view.displayMessage("Ребенок добавлен: " + child);
    }

    public void showGroups() throws SQLException {
        List<Group> groups = model.getGroups();

        for (Group group : groups) {
            view.displayMessage(group.toString());
            for (Child child : group.getChildren()) {
                view.displayMessage("\t" + child.toString());
            }
        }
    }
}
