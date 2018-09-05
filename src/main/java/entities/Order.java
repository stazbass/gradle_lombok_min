package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Order structure returned by order-api/../ORDER_DETAILS
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  String orderId;
  String[] sequence;
  String endPoint;
  Data data;
  Map<String, String> errors;
  Map<String, String> structuredErrors;
  Boolean success;
  OrderInternal order;
  private String id;

  @Builder
  @lombok.Data
  public static class OrderInternal {
    private TransitoryData transitoryData;
    private String id;
    private String uuid;
    private String lastExecutionStatus;
    private Annotation annotation;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
    private String orderKey;
    private String orderDate;
    private String userId;
    private String uvn;
    private String status;
    private ShippingAddress shippingAddress;
    private List<Object> orderShipments;
    private List<Object> orderPayments;
    private List<Object> issues;
    private String throwExceptionOnDuplicateOrderLine;
    private List<Object> successfulOrderPayments;
    private OrderAnnotations orderAnnotations;
    private String orderType;
    private List<OrderLine> orderLines;
    private BillingAddress billingAddress;

    @Builder
    @lombok.Data
    public static class TransitoryData {
      private Boolean canChangeAddress;
      private Boolean canCancel;
      private Boolean canPurchase;
      private Boolean canExtend;
      private Boolean canReturn;
      private String total;
      private Boolean canReportIssue;
      private ChargeDetails chargeDetails;
      private NetChargeDetails netChargeDetails;
      private RefundDetails refundDetails;
      private OrderSummary orderSummary;

      @Builder
      @lombok.Data
      public static class ChargeDetails {
        private String itemPrice;
        private String shippingPrice;
        private String tax;
        private String totalPrice;
      }

      @Builder
      @lombok.Data
      public static class NetChargeDetails {
        private String itemPrice;
        private String shippingPrice;
        private String tax;
        private String totalPrice;
      }

      @Builder
      @lombok.Data
      public static class RefundDetails {
        private String itemPrice;
        private String shippingPrice;
        private String tax;
        private String totalPrice;
      }

      @Builder
      @lombok.Data
      public static class OrderSummary {
        private Integer orderLineCount;
        private Integer rwywCount;
        private Integer orderPaymentCount;
        private OrderLinesByCatalogType orderLinesByCatalogType;
        private OrderLinesByStatus orderLinesByStatus;
        private Map<String, Integer> booksPerShipment;
        private Map<String, String> paymentsByDebitCredit;
        private Map<String, String> paymentsByStatus;

        @Builder
        @lombok.Data
        public static class OrderLinesByCatalogType {
          private Integer TEXTBOOK;
          private Integer COUPON;
        }

        @Builder
        @lombok.Data
        public static class OrderLinesByStatus {
          private Integer PLACED;
        }
      }
    }

    @Builder
    @lombok.Data
    public static class Annotation {
      private String php_session_id;
      private String region;
      private String countryName;
      private String authorizePaymentExternalUuid;
      private String uvn;
      private String vertexCustomerClassCode;
      private String countryCode;
      private String priceMatchGuaranteed;
      private String canMerge;
      //      @JsonProperty("fraud.PhoneCheck")
      private String fraud;
      private String legacy_shipping_address_id;
      private String order_lines_log_tax_quote_source;
      private String city;
      private String netsuiteExperimentFlag;
      private String total_coupon_saving;
      private String placedViaPlaceOrder;
      private String cartType;
      private String transactionSource;
      private String isMobile;
      private String legacy_billing_address_id;
      private String orderPlacedOn;
      private String fraud_suspected;
      private String ipAddress;
      private String isInApp;
    }

    @Builder
    @lombok.Data
    public static class ShippingAddress {
      private Long id;
      private String orderId;
      private String orderAddressType;
      private String firstName;
      private String lastName;
      private String line1;
      private String line2;
      private String city;
      private String state;
      private String zip;
      private String country;
      private String phone;
      private String createdBy;
      private String createdDate;
      private String modifiedBy;
      private String modifiedDate;
      //      @JsonProperty("5DigitZip")
      private String DigitZip5;
    }

    @Builder
    @lombok.Data
    public static class BillingAddress {
      private Long id;
      private String orderId;
      private String orderAddressType;
      private String firstName;
      private String lastName;
      private String line1;
      private String line2;
      private String city;
      private String state;
      private String zip;
      private String country;
      private String phone;
      private String createdBy;
      private String createdDate;
      private String modifiedBy;
      private String modifiedDate;
      //      @JsonProperty("5DigitZip")
      private String DigitZip5;
    }

    @Builder
    @lombok.Data
    public static class OrderLine {
      private TransitoryData transitoryData;
      private String id;
      private String uuid;
      private String lastExecutionStatus;
      private Annotation annotation;
      private String createdBy;
      private String createdDate;
      private String modifiedBy;
      private String modifiedDate;
      private Integer orderId;
      private String catalogItemId;
      private String catalogItemType;
      private String catalogItemName;
      private CatalogItem catalogItem; // comes from catalog api service
      private String quantity;
      private String inventoryId;
      private String inventoryReservationId;
      private String itemType;
      private String transactionType;
      private String orderLineStatus;
      private String displayStatus;
      private String pricingLogId;
      private String itemPrice;
      private String shippingPrice;
      private String tax;
      private String originalItemPrice;
      private String listPrice;
      private String parentLineId;
      private String isCustomerVisible;
      private String rentalExpirationDate;
      private OrderLinePhysical orderLinePhysical;
      private Object orderLineDigital;
      private List<Map<String, String>> orderPayments;
      private String status;
      private String transType;
      private Boolean physical;
      private Boolean digital;
      private String shipOrFulfillDate;
      private OrderLineAnnotation orderLineAnnotation;
      private SubscriptionInformation subscriptionInformation;

      @Builder
      @lombok.Data
      public static class TransitoryData {
        private Boolean canCancel;
        private Boolean canPurchase;
        private Boolean canExtend;
        private Boolean canReturn;
        private String total;
        private Boolean canReportIssue;
      }
      @Builder
      @lombok.Data
      public static class SubscriptionInformation {
        private String id;
        private String userId;
        private String orderId;
        private String orderLineId;
        private String catalogId;
        private String paymentId;
        private String renew;
        private String status;
        private String createdBy;
        private String modifiedBy;
        private String renewalPeriod;
        private String renewalPrice;
        private String initialPeriod;
        private String initialPrice;
        private String createdDate;
        private String modifiedDate;
        private String renewalDate;
        private String suspendDate;
        private String nextPointsPostingDate;
        private String lastErrorCode;
        private String transLogId;
        private String subscriptionLogId;
        private String lastChargeMessage;
        private String canSwap;
        private String canPause;
        private String canCancel;
        private String orderLineLogId;
        private String isPaymentSuccessful;
        private String isSuspendPending;
        private String isSwapPending;
        private String isCancelPending;
        private String cancelledDate;
      }

      @Builder
      @lombok.Data
      public static class Annotation {
        private String vertexTaxProductClass;
        private String eligibleProviders;
        //        @JsonProperty("price-expires")
        private String price_expires;
        private String lastPriceRefresh;
        //        @JsonProperty("price-information")
        private String price_information;
        private String provider;
        //        @JsonProperty("CPN-FreeShip:CPN-57753536")
        private String CPN_FreeShip_CPN_57753536;
        private String sourcingDecisionParams;
      }

      @Builder
      @lombok.Data
      public static class OrderLinePhysical {
        private String lineId;
        private String orderCondition;
        private String shipMethodId;
        private String shippingAddressId;
        private String gdd;
        private String transitTime;
        private String merchantId;
        private String shipmentId;
        private String rentalReturnedDate;
        private String originalLineId;
        private String shippedInventoryCondition;
        private String createdBy;
        private String createdDate;
        private String modifiedBy;
        private String modifiedDate;
      }

      @Builder
      @lombok.Data
      public static class OrderLineAnnotation {
        private String vertexTaxProductClass;
        private String eligibleProviders;
        //        @JsonProperty("price-expires")
        private String price_expires;
        private String lastPriceRefresh;
        //        @JsonProperty("price-information")
        private String price_information;
        private String provider;
        //        @JsonProperty("CPN-FreeShip:CPN-57753536")
        private String CPN_FreeShip_CPN_57753536;
        private String sourcingDecisionParams;
      }
    }

    @Builder
    @lombok.Data
    public static class OrderAnnotations {
      private String php_session_id;
      private String region;
      private String countryName;
      private String authorizePaymentExternalUuid;
      private String uvn;
      private String vertexCustomerClassCode;
      private String countryCode;
      private String priceMatchGuaranteed;
      private String canMerge;
      private String fraud;
      private String legacy_shipping_address_id;
      private String order_lines_log_tax_quote_source;
      private String city;
      private String netsuiteExperimentFlag;
      private String total_coupon_saving;
      private String placedViaPlaceOrder;
      private String cartType;
      private String transactionSource;
      private String isMobile;
      private String legacy_billing_address_id;
      private String orderPlacedOn;
      private String fraud_suspected;
      private String ipAddress;
      private String isInApp;
    }
  }

  @Builder
  @lombok.Data
  public static class Data {
    //    @JsonProperty("verified.determine_e_book_access")
    String determine_e_book_access;
    String LAST_PLUGIN_EVALUATED;
    String determine_order_line_level_totals;
    //    @JsonProperty("Inputs")
    Input inputs;

    @Builder
    @lombok.Data
    public static class Input {
      private String orderIds;
      private String orderId;
      private String orderLineIds;
      private String itemList;
      private String userId;
      private String orderKeys;
      private String issues;
      private String address;
      private String order;
      private String forceSequenceReload;
      private String inputData;
      private String ordersFetchLimitForUser;
      private String shortResponse;
      private String paymentInfo;
    }
  }
}
