import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.CatalogItem;
import entities.Order;
import entities.OrderDetails;
import mapper.OrderMapper;

public class OrderMappingDemo {


  public CatalogItem getCatalogItem(String id) {
    CatalogItem item = (new Gson()).fromJson(FileContent.readFile("catalog_item.json"), CatalogItem.class);
    item.setCatalogItemId(id);
    return item;
  }

  public void main(Object... args) {

    String[] availableFiles = new String[]{
        "responses/COUPON.json",
        "responses/DONATION.json",
        "responses/EBOOK.json",
        "responses/FIXED_RECURRING_ITEM.json",
        "responses/ONE_TIME_BUNDLE_ITEM.json",
        "responses/ONE_TIME_ITEM.json",
        "responses/RECURING_BUNDLE_ITEM.json",
        "responses/REGULAR.json",
        "responses/SUBSCRIPTION.json",
        "responses/TEXTBOOK.json"};
    for(String file : availableFiles){
      System.out.println(String.format("Parsing %s", file));
      Order order = (new Gson()).fromJson(FileContent.readFile(file), Order.class);
      order.getOrder().getOrderLines().stream().forEach(ol -> ol.setCatalogItem(getCatalogItem(ol.getCatalogItemId())));
      OrderDetails orderDetails = OrderMapper.OrderMainMapper.instance.toOrderDetails(order.getOrder());
      System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(orderDetails));
    }
  }
}
