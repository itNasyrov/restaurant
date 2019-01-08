package restaurant.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Order
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-02T23:40:43.246+05:00")

public class Order   {
  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("customer")
  private String customer = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  @JsonProperty("date_ready")
  private OffsetDateTime dateReady = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("items")
  private List<OrderItem> items = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("tableNumber")
  private Integer tableNumber = null;

  public Order comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(value = "")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Order customer(String customer) {
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")


  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public Order date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Order dateReady(OffsetDateTime dateReady) {
    this.dateReady = dateReady;
    return this;
  }

   /**
   * Get dateReady
   * @return dateReady
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDateReady() {
    return dateReady;
  }

  public void setDateReady(OffsetDateTime dateReady) {
    this.dateReady = dateReady;
  }

  public Order id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order items(List<OrderItem> items) {
    this.items = items;
    return this;
  }

  public Order addItemsItem(OrderItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<OrderItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }

  public Order status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Order tableNumber(Integer tableNumber) {
    this.tableNumber = tableNumber;
    return this;
  }

   /**
   * Get tableNumber
   * @return tableNumber
  **/
  @ApiModelProperty(value = "")


  public Integer getTableNumber() {
    return tableNumber;
  }

  public void setTableNumber(Integer tableNumber) {
    this.tableNumber = tableNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.comment, order.comment) &&
        Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.date, order.date) &&
        Objects.equals(this.dateReady, order.dateReady) &&
        Objects.equals(this.id, order.id) &&
        Objects.equals(this.items, order.items) &&
        Objects.equals(this.status, order.status) &&
        Objects.equals(this.tableNumber, order.tableNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, customer, date, dateReady, id, items, status, tableNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    dateReady: ").append(toIndentedString(dateReady)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tableNumber: ").append(toIndentedString(tableNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

