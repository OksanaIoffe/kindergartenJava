import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kindergarten kindergarten = new Kindergarten();

        kindergarten.addGroup("��������", 1);
        kindergarten.addGroup("�������", 2);

        kindergarten.addChildToGroup("��������", new Child("������ ���� ��������", "���", 4));
        kindergarten.addChildToGroup("��������", new Child("������� ����� ��������", "���", 5));
        kindergarten.addChildToGroup("�������", new Child("������� ������� ����������", "���", 3));

        // ����� ���������� � �������
        kindergarten.displayGroups();
    }
}