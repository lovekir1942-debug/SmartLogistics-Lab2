public class Car extends Vehicle{
    private int passengerCount;

    public Car(String id, int passengerCount) {
        super(500, id);
        if (passengerCount <= 0) {
            throw new IllegalArgumentException("Число пассажиров должно быть > 0");
        }
        this.passengerCount = passengerCount;
    }

    @Override
    public void move() {
        System.out.println("Легковой автомобиль " + getId() + " едет по дороге со скоростью 90 км/ч");
    }

    public int getPassengerCount() {
        return passengerCount;
    }
}
