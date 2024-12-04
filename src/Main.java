

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            KindergartenModel model = new KindergartenModel("jdbc:mysql://localhost:3306/kindergarten", "root", "password");
            KindergartenView view = new KindergartenView();
            KindergartenController controller = new KindergartenController(model, view);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Выберите действие:");
                System.out.println("1. Добавить группу");
                System.out.println("2. Добавить ребенка");
                System.out.println("3. Показать группы");
                System.out.println("4. Выход");

                int choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера

                switch (choice) {
                    case 1:
                        System.out.println("Введите название группы:");
                        String groupName = scanner.nextLine();
                        System.out.println("Введите номер группы:");
                        int groupNumber = scanner.nextInt();
                        controller.addGroup(groupName, groupNumber);
                        break;
                    case 2:
                        System.out.println("Введите ФИО ребенка:");
                        String fullName = scanner.nextLine();
                        System.out.println("Введите пол ребенка:");
                        String gender = scanner.nextLine();
                        System.out.println("Введите возраст ребенка:");
                        int age = scanner.nextInt();
                        System.out.println("Введите номер группы:");
                        int gNumber = scanner.nextInt();
                        controller.addChild(fullName, gender, age, gNumber);
                        break;
                    case 3:
                        controller.showGroups();
                        break;
                    case 4:
                        model.close();
                        System.exit(0);
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

