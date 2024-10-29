import java.util.ArrayList;
import java.util.List;


class Group {
    private String name;
    private int number;
    private List<Child> children;

    public Group(String name, int number) {
        this.name = name;
        this.number = number;
        this.children = new ArrayList<>();
    }

    //добавление ребенка
    public void addChild(Child child) {
        children.add(child);
    }

    //удаление ребенка
    public void removeChild(Child child) {
        children.remove(child);
    }

    // Метод отображение детей в группе
    public void showChildren() {
        System.out.println("Группа: " + name + ";" + " Номер:" + number + "");
        for (Child child : children) {
            System.out.println("   " + child);
        }
    }

}
