public class Drone extends Vehicle implements ITrackable{
    private int butteryLevel;

    private double latitude;
    private double longitude;
    private double altitude;

    public Drone(String id, int butteryLevel) {
        super(5, id);
        if (butteryLevel < 0 || butteryLevel > 100) {
            throw new IllegalArgumentException("Заряд батареи должен быть больше 0 и меньше 100%");
        }
        this.butteryLevel = butteryLevel;
        this.latitude = 54.720163;
        this.longitude = 55.931490;
        this.altitude = 30.0;
    }

    @Override
    public void move() {
        if (this.butteryLevel <= 0){
            System.out.println("Дрон "+getId()+" разряжен. Ему требуется зарядка!");
        }
        this.butteryLevel -= 5;
        this.latitude += 0.0001;
        this.longitude += 0.0001;
        this.altitude += 0.0001;

        System.out.println("Дрон " + getId() + " летит по вохдуху, заряд батареи: " + this.butteryLevel + "%");

    }

    @Override
    public String getCurrentCoordinates(){
        return String.format("Широта: %.4f, Долгота: %.4f, Высота: %.1f м", latitude,longitude,altitude);
    }
    @Override
    public void sendStatusUpdate(){
        System.out.println("Дрон "+getId()+" Координаты: "+getCurrentCoordinates()+" Заряд батареи: "+getButteryLevel()+"%");
    }
    public int getButteryLevel() {
        return butteryLevel;
    }
}
