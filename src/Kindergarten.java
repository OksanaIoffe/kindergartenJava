import java.util.ArrayList;
import java.util.List;

public class Kindergarten {
    private List<Group> groups;

    public Kindergarten() {
        this.groups = new ArrayList<>();
    }


    public void addGroup(Group group) {
        groups.add(group);
    }

    public void displayGroups() {
        System.out.println("Группа в детском саду:");
        for (Group group : groups) {
            group.showChildren();
        }
    }

    public static void main(String[] args) {
        Kindergarten kindergarten = new Kindergarten();

        Group group1 = new Group("Солнышки", 1);
        Group group2 = new Group("Тигрята", 2);

        group1.addChild(new Child("Иванов Иван Иванович", "Муж", 4));
        group1.addChild(new Child("Петрова Мария Петровна", "Жен", 5));

        group2.addChild(new Child("Сидоров Алексей Алексеевич", "Муж", 3));

        kindergarten.addGroup(group1);
        kindergarten.addGroup(group2);

        kindergarten.displayGroups();

        // Пример редактирования
        group1.removeChild(new Child("Иванов Иван Иванович", "Mуж", 4)); // Удаляем по значению
        group1.addChild(new Child("Смирнов Дмитрий Владимирович", "Mуж", 4)); // Добавляем нового ребенка

        System.out.println("после редактирования:");
        kindergarten.displayGroups();
    }
}
