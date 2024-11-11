import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kindergarten kindergarten = new Kindergarten();

        kindergarten.addGroup("Солнышки", 1);
        kindergarten.addGroup("Тигрята", 2);

        kindergarten.addChildToGroup("Солнышки", new Child("Иванов Иван Иванович", "Муж", 4));
        kindergarten.addChildToGroup("Солнышки", new Child("Петрова Мария Петровна", "Жен", 5));
        kindergarten.addChildToGroup("Тигрята", new Child("Сидоров Алексей Алексеевич", "Муж", 3));

        // Вывод информации о группах
        kindergarten.displayGroups();
    }
}