package visualizer;

import entities.Order;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class XMLGenTest
{

  public List<String> getFieldNames() {
    List<String> result = new ArrayList<>();
    String newLine = System.getProperty("line.separator");

    //determine fields declared in this class only (no fields of superclass)
    Field[] fields = Order.class.getDeclaredFields();

    //print field names paired with their values
    for ( Field field : fields  ) {
        result.add( field.getName() );
    }

    return result;
  }
  @Test
  public void testGenerator(){
    List<String> fields = getFieldNames();
    for (int i = 0; i < fields.size(); i++) {
      System.out.println(XMLGen.getItem(10+i, fields.get(i), Optional.empty(), Optional.of(26*i+26)));
    }
    String text = XMLGen.getItem(10, "text", Optional.of(10), Optional.of(20));
    System.out.println(text);
  }

}