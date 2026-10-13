public class Truck extends Vehicle implements ITrackable{

    private boolean hasTrailer;
    private double latitude;
    private double longitude;
    public Truck(double maxCapacityKg, String id, boolean hasTrailer) {
        super(hasTrailer ? maxCapacityKg + 5000 : maxCapacityKg, id);
        this.hasTrailer = hasTrailer;
        this.latitude = 54.720163; // корды ФИЗМАТА
        this.longitude = 55.931490;
    }

    @Override
    public void move() {
        this.latitude += 0.001;
        this.longitude += 0.001;
        System.out.println("Грузовик " + getId() + " едет по трассе со скоростью 70 км/ч");
    }
    @Override
    public String getCurrentCoordinates(){
        return String.format("Широта: %.4f, Долгота: %.4f", latitude,longitude);
    }
    @Override
    public void sendStatusUpdate(){
        System.out.println("Грузовик "+getId()+" Координаты: "+ getCurrentCoordinates()+" Загрузка: "+getCurrentLoadKg()+" кг");
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }


}
