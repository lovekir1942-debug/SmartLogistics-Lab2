import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private String id;
    private double maxCapacityKg;
    private double currentLoadKg;
    private List<CargoItem> cargoList;

    public Vehicle(double maxCapacityKg, String id) {
        this.id = id;
        if (maxCapacityKg <= 0)
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        this.maxCapacityKg = maxCapacityKg;
        this.cargoList = new ArrayList<>();
    }

    public abstract void move();

    public String getId() {
        return id;
    }

    public double getMaxCapacityKg() {
        return maxCapacityKg;
    }

    public double getCurrentLoadKg() {
        return currentLoadKg;
    }

    // Версия 1: только вес (быстрая загрузка без имён)
    public void load(double weight) {
        if (weight <= 0){
            System.out.println("Ошибка: вес должен быть > 0");
        }
        // аноним груз
        CargoItem anonymItem = new CargoItem("Аноним груз", weight);
        load(anonymItem);
    }

    // Версия 2: именованный груз
    public void load(CargoItem item) {
        double potentialLoad = this.currentLoadKg + item.getWeight();

        if (potentialLoad <= this.maxCapacityKg){
            this.currentLoadKg = potentialLoad;
            this.cargoList.add(item);
            System.out.println("Груз '" + item.getName() + "' (" + item.getWeight() + " кг) успешно загружен в " + this.id);
        } else {
            double r = potentialLoad - this.maxCapacityKg;
            System.out.println("Ошибка: превышен лимит загрузки для " + this.id + ". Не достаточно " + r + " кг.");
        }
    }

    // Версия 3: партия грузов
    public void load(List<CargoItem> items) {
        if (items.isEmpty()){
            System.out.println("Список грузов пуст. Загрузка отменена");
        }
        System.out.println("Начинается загрузка партии из " + items.size() + " грузов в " + this.id + ":");
        for (CargoItem item : items){
            load(item);
        }
    }

    public List<CargoItem> getCargoList() {
        return cargoList;
    }
}
