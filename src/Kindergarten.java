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
        System.out.println("������ � ������� ����:");
        for (Group group : groups) {
            group.showChildren();
        }
    }

    public static void main(String[] args) {
        Kindergarten kindergarten = new Kindergarten();

        Group group1 = new Group("��������", 1);
        Group group2 = new Group("�������", 2);

        group1.addChild(new Child("������ ���� ��������", "���", 4));
        group1.addChild(new Child("������� ����� ��������", "���", 5));

        group2.addChild(new Child("������� ������� ����������", "���", 3));

        kindergarten.addGroup(group1);
        kindergarten.addGroup(group2);

        kindergarten.displayGroups();

        // ������ ��������������
        group1.removeChild(new Child("������ ���� ��������", "M��", 4)); // ������� �� ��������
        group1.addChild(new Child("������� ������� ������������", "M��", 4)); // ��������� ������ �������

        System.out.println("����� ��������������:");
        kindergarten.displayGroups();
    }
}
