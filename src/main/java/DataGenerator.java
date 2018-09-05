import com.google.gson.Gson;
import entities.CatalogItem;
import entities.Order;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class DataGenerator {

  public static final int COUNT_ITEMS = 10;

  public CatalogItem getCatalogItem() {
    String catalogAPiResponse = readFile("catalog_item.json");
    CatalogItem item = new Gson().fromJson(catalogAPiResponse, CatalogItem.class);
    return item;
  }

  public List<Order.OrderInternal.OrderLine> generateOrderLines(int orderId) {
    List<Order.OrderInternal.OrderLine> result = new ArrayList<>();
    for (int i = 0; i < COUNT_ITEMS; i++) {
      Order.OrderInternal.OrderLine line = Order.OrderInternal.OrderLine.builder().orderId(orderId).build();
      line.setCatalogItem(getCatalogItem());
      result.add(line);
    }
    return result;
  }

  public Order orderFromFile(String filename) {
    return new Gson().fromJson(readFile(filename), Order.class);
  }

  public CatalogItem catalogItemFromFile(String filename) {
    return new Gson().fromJson(readFile(filename), CatalogItem.class);
  }

  public List<CatalogItem> feedIds(Supplier<CatalogItem> templateItemSupplier, int count) {
    List<CatalogItem> result = new LinkedList<>();
    for (int i = 0; i < count; i++) {
      CatalogItem item = templateItemSupplier.get();
      item.setCatalogItemId(UUID.randomUUID().toString());
      result.add(item);
    }
    return result;
  }

  public List<Order> generateOrders() {
    List<Order> result = new ArrayList<>();
    for (int i = 0; i < COUNT_ITEMS; i++) {
      Order order = Order.builder().order(Order.OrderInternal.builder()
          .orderLines(generateOrderLines(i)).build()).build();
      result.add(order);
    }
    return result;
  }


  public String readFile(String path) {
    StringBuffer result = new StringBuffer();
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResource(path).openStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        result.append(line);
        result.append('\n');
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result.toString();
  }


}
