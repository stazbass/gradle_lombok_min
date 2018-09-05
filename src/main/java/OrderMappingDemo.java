import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.CatalogItem;
import entities.Order;
import entities.OrderDetails;
import mapper.OrderMapper;

import java.util.LinkedList;
import java.util.List;

public class OrderMappingDemo {
//  public Order readOrder(String file) {
//    String fileContent = FReader.readFile(file);
//    DataGenerator dataGenerator = new DataGenerator();
//    Order order = (new Gson()).fromJson(fileContent, Order.class);
//    CatalogItem item = (new Gson()).fromJson(FReader.readFile("catalog_item.json"), CatalogItem.class);
//    List<CatalogItem> catalogItems = new LinkedList<>();
//    order.getOrder().getOrderLines().stream().forEach(ol -> {
//      CatalogItem catalogItem = (new Gson()).fromJson(FReader.readFile("catalog_item.json"), CatalogItem.class);
//      catalogItem.setCatalogItemId(ol.getCatalogItemId());
//      catalogItems.add(catalogItem);
//    });
//    System.out.println(catalogItems);
//    return order;
//  }

  public CatalogItem getCatalogItem(String id){
    CatalogItem item = (new Gson()).fromJson(FReader.readFile("catalog_item.json"), CatalogItem.class);
    item.setCatalogItemId(id);
    return item;
  }

  public void main(Object... args) {
    Order order =(new Gson()).fromJson( FReader.readFile("responses/COUPON.json"), Order.class);
    order.getOrder().getOrderLines().stream().forEach(ol->ol.setCatalogItem(getCatalogItem(ol.getCatalogItemId())));
    OrderDetails orderDetails = OrderMapper.OrderMainMapper.instance.toOrderDetails(order.getOrder());
//    System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(orderDetails));
  }
}
