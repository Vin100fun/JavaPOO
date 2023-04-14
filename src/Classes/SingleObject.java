
package Classes;

import java.util.UUID;

public class SingleObject {
    UUID id;
    //create an object of SingleObject
    private final static SingleObject instance = new SingleObject();

    public SingleObject() {
        this.id = UUID.randomUUID();
    }
    //make the constructor private so that this class cannot be
    //instantiated

    //Get the only object available
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
