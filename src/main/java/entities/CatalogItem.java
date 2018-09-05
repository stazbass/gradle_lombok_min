package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class CatalogItem {
  private String type;
  private String catalogItemId;
  private String name;
  private String transType;
  private String status;
  private CatalogItemType catalogItemType;
  private String catalogProviderId;
  private String createdDate;
  private String modifiedDate;
  private String isbn;
  private String ean;
  private String edition;
  private String editionNo;
  private String primaryAuthor;
  private String bisacCode;
  private String bisacLabel;
  private String copyright;
  private String illustrated;
  private String listPrice;
  private String netPrice;
  private String title;
  private String subtitle;
  private String publisherName;
  private String audienceCode;
  private String imgLarge;
  private String imgMedium;
  private String imgThumb;
  private String imgSmall;
  private String lcp;
  private String availableInventoryCount;
  private String totalInventoryCount;
  private String description;
  private String toc;
  private String biblioId;
  private String containsExtra;
  private String pricingTermId;
  private Boolean dac;
  private String cheggStudyStickerCapable;
  private String publishDate;
  private String imgWidth80;
  private String imgWidth100;
  private String imgWidth400;
  private String imgWidth144;
  private String imgBox60_70;
  private String imgWidth200;
  private String imgWidth288;
  private String imgWidth120;
  private List<String> authors;
  private List<Price> prices;

  public enum CatalogItemType {
    TYPE_UNKNOWN_DEFAULT(""),
    TYPE_EBOOK("EBOOK"),
    TYPE_TBS("TBS"),
    TYPE_DONATION("DONATION"),
    TYPE_SUBSCRIPTION("SUBSCRIPTION"),
    TYPE_TEST_PREP("TEST_PREP"),
    TYPE_POINTS_ALC("PTS_ALC"),
    TYPE_QNA("QNA"),
    TYPE_ALC_QNA("ALC_QNA_ANS"),
    TYPE_ALC_TBS("ALC_TBS_SOL"),
    TYPE_NOTES("NOTES"),
    TYPE_TEXTBOOK("TEXTBOOK"),
    TYPE_TESTPREP("TEST_PREP"),
    TYPE_COUPON("COUPON"),
    TYPE_EXTENSION("EXTENSION"),
    TYPE_MGHDAC("MGHDAC"),
    TYPE_FIXED_RECURRING_BUNDLE("RECURRING_BUNDLE_ITEM"),
    TYPE_PROMOTION("PROMOTION"),
    TYPE_CS("LM"),
    TYPE_FIXED_RECURRING("FIXED_RECURRING_ITEM");

    final String value;


    CatalogItemType(final String value) {
      this.value = value;
    }

    static CatalogItemType forValue(String value) {
      for (CatalogItemType t : CatalogItemType.values()) {
        if (t.value.equals(value)) return t;
      }
      return TYPE_UNKNOWN_DEFAULT;
    }
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor

  @Builder
  public static class Price {
    private String price;
    private PricingType pricingType;
    private Map<String, String> nameValuePairs;
    private String ebookRentType;
    private String termDays;
    private String pricingContractId;
    private String termName;
    private String expires;
    private String term;
    private String priceType;
    private String dueDate;
    private String termId;
    private String logId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    @Builder
    public static class PricingType {
      private Map<String, String> nameValuePairs;
    }
  }
}
