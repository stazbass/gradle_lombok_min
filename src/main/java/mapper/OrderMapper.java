package mapper;

import entities.CatalogItem;
import entities.Order;
import entities.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public interface OrderMapper {
  @Mapper
  interface OrderMainMapper {
    OrderMainMapper instance = Mappers.getMapper(OrderMainMapper.class);
    @Mappings({
        @Mapping(source = "order.userId", target = "userId"),
        @Mapping(source = "order.orderDate", target = "orderDate"),
        @Mapping(source = "order.orderType", target = "orderType"),
        @Mapping(source = "order.billingAddress", target = "billingAddress"),
        @Mapping(source = "order.shippingAddress", target = "shippingAddress"),
        @Mapping(source = "order.orderLines", target = "orderLines"),
        @Mapping(source = "order.uuid", target = "orderUuid"),
        @Mapping(source = "order.status", target = "orderStatus"),
        @Mapping(source = "order.orderKey", target = "orderKey"),
    })
    OrderDetails toOrderDetails(Order.OrderInternal order);
    @Mappings({
        @Mapping(source = "catalogItem.authors", target = "authorNames"),
        @Mapping(source = "catalogItem.dac", target = "dac"),
        @Mapping(source = "subscriptionInformation.cancelledDate", target = "cancelledDate"),
        @Mapping(source = "catalogItem.catalogItemId", target = "catalogItemId"),
        @Mapping(source = "catalogItem.catalogItemType", target = "catalogItemType"),
        @Mapping(source = "orderLineInternal.status", target = "status")
    })
    void updateOrderLine(Order.OrderInternal.OrderLine orderLineInternal, @MappingTarget OrderDetails.OrderLine orderLine);
  }
}
