package javafeatures.singleton;

public class SingletonImpl {
    private static SingletonImpl instance;

    private SingletonImpl() {
        // Private constructor to prevent instantiation
    }

    public static SingletonImpl getInstance() {
        if (instance == null) {
            instance = new SingletonImpl();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        SingletonImpl singleton = SingletonImpl.getInstance();
        singleton.showMessage();
    }
}
