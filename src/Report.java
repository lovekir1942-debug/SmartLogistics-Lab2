public class Report<T> {
    private T data;

    public Report(T data){
        this.data = data;
    }

    public void printReport(){
        System.out.println("ОТЧЕТ");
        System.out.println("Тип данных: " + data.getClass().getSimpleName());
        System.out.println("Содержимое: "+ data.toString());
    }
}
