import java.util.List;

public interface IManageable {
    void add(Item item); // додати предмет
    void remove(Item item); // видалити предмет
    List<Item> listAvailable(); // список доступних предметів
    List<Item> listBorrowed(); // список взятих предметів
}
