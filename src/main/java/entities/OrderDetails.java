package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * OrderDetails information to be returned via REST API
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
  private String userId;
  private String orderUuid;
  private String orderKey;
  private String orderDate;
  private String orderType;
  private String orderStatus;
  private BillingAddress billingAddress;
  private ShippingAddress shippingAddress;
  private List<OrderLine> orderLines;
  private Shipment shipment;

  @Builder
  @lombok.Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class BillingAddress {
    private String country;
    private String firstName;
    private String lastName;
  }

  @Builder
  @lombok.Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ShippingAddress {
    private String country;
    private String firstName;
    private String lastName;
  }

  @Builder
  @lombok.Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class OrderLine {
    private String id;
    private List<String> authorNames;
//    private Object authors;
    private String cancelledDate;
    private String catalogItemId;
    private String catalogItemType;
    private CatalogItem catalogItem;
    private Object companyName;
    private Object dac;
    private String displayStatus;
    private String ean;
    private String title;
    private String edition;
    private String editionNo;
    private String isbn;
    private String gdd;
    private String imgThumb;
    private Boolean extendable;
    private Object extension;
    private Boolean cancellable;
    private Boolean isDac;
    private String getDac;
    private Boolean renewable;
    private Boolean digital;
    private Boolean donation;
    private Boolean ebook;
    private String itemPrice;
    private String itemType;
    private String orderConditionString;
    private Object originalRentalDueDate;
    private Object shippingPrice;
    private Object shippedInventoryCondition;
    private Integer orderId;
    private String parentLineId;
    private String rentalExpirationDate;
    private String shipOrFulfillDate;
    private String status;
    private String transactionType;
  }

  @Builder
  @lombok.Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Shipment {
    private String carrier;
    private String completeShipDate;
    private String shipMethodCode;
    private String source;
  }
}
