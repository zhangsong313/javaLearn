package generic.genericMethod;

public class Methods {
    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.get("aa");
        methods.get(123);
    }
    private <T> void get(T t){
        System.out.println(t.getClass().getName());
    }
}
