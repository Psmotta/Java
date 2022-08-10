import javax.management.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws InvalidAttributesException, FileNotFoundException, InvalidAttributeValueException {

        Sistema sistema = new Sistema();

        sistema.mostrarDatasValidas();

    }

}
