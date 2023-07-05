public class SingleObject {

    private static SingleObject single_instance =null;
    public String s;

    private SingleObject(){
        s ="Inside constructor";
        System.out.println(s);
    }
    public static synchronized SingleObject getInstance(){
        if (single_instance==null){
            single_instance=new SingleObject();
        }
        return single_instance;
    }
    public void showMessage(){
        System.out.println("Message in showMessage function which is in singleton class ");
    }

}