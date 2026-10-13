public class FragileItem extends BaseCargo{
    private boolean requiresSpecialHandling;


    public FragileItem(String id, String name, double weight, boolean requiresSpecialHandling) {
        super(id, name, weight);
        this.requiresSpecialHandling = requiresSpecialHandling;
    }

    @Override
    public String getType(){
        return "FragileItem [Требует спец. обработки: " + requiresSpecialHandling + "]";

    }

    public boolean isRequiresSpecialHandling() {
        return requiresSpecialHandling;
    }
}
