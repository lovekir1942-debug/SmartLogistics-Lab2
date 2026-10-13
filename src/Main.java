import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("CAR-001", 4);
        Truck truck = new Truck(10000, "TRUCK-001", true);
        Drone drone = new Drone("DRONE-001", 100);

        truck.load(2000.0);

        CargoItem electronics = new CargoItem("Электроника", 500.0);
        truck.load(electronics);

        List<CargoItem> batch = new ArrayList<>();
        batch.add(new CargoItem("Кирпичи", 8000.0));
        batch.add(new CargoItem("Инструменты", 100.0));
        truck.load(batch);

        FleetManager fleetManager = new FleetManager();
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(car);
        fleet.add(truck);
        fleet.add(drone);

        fleetManager.startDelivery(fleet);

        StandardBox standardBox = new StandardBox("SB-001", "Книги", 15.0);
        FragileItem fragileItem = new FragileItem("FI-001", "Ваза", 3.0, true);
        RefrigeratedContainer refrigerated = new RefrigeratedContainer("RC-001", "Мороженое", 100.0, -18.0);

        List<ITrackable> trackableFleet = new ArrayList<>();
        trackableFleet.add(truck);
        trackableFleet.add(drone);

        LogisticsCenter center = new LogisticsCenter();
        center.monitorFleet(trackableFleet);

        truck.move();
        drone.move();

        center.dispatch(trackableFleet);

        Warehouse<StandardBox> standardWarehouse = new Warehouse<>();
        standardWarehouse.addItem(standardBox);
        standardWarehouse.addItem(new StandardBox("SB-002", "Одежда", 10.0));

        Warehouse<FragileItem> fragileWarehouse = new Warehouse<>();
        fragileWarehouse.addItem(fragileItem);

        standardWarehouse.printManifest();
        fragileWarehouse.printManifest();

        Report<Warehouse<StandardBox>> reportStandard = new Report<>(standardWarehouse);
        reportStandard.printReport();

        Report<Warehouse<FragileItem>> reportFragile = new Report<>(fragileWarehouse);
        reportFragile.printReport();
    }
}