import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class GenericFactoryDemo {
    public static void main(String[] args) {
    	Object p = createInstance(
    		    "exercise.Person",                      
    		    new Class<?>[]{String.class, int.class},
    		    new Object[]{"Sonica", 25}
    		);


        if (p != null) {
            System.out.println("Created: " + p);
        }
    }

    public static Object createInstance(String className, Class<?>[] paramTypes, Object[] args) {
        try {
            Class<?> clazz = Class.forName(className);
            var ctor = clazz.getConstructor(paramTypes);
            return ctor.newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
