package restaurant.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TableBooking
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-02T23:40:43.246+05:00")

public class TableBooking   {
  @JsonProperty("bookTime")
  private OffsetDateTime bookTime = null;

  @JsonProperty("customer")
  private Customer customer = null;

  @JsonProperty("id")
  private Long id = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    BOOKED("TABLE_BOOKED"),
    
    OPENED("TABLE_OPENED"),
    
    CLOSED("TABLE_CLOSED"),
    
    CANCELLED("TABLE_CANCELLED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("tables")
  private List<RestaurantTable> tables = null;

  public TableBooking bookTime(OffsetDateTime bookTime) {
    this.bookTime = bookTime;
    return this;
  }

   /**
   * Get bookTime
   * @return bookTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getBookTime() {
    return bookTime;
  }

  public void setBookTime(OffsetDateTime bookTime) {
    this.bookTime = bookTime;
  }

  public TableBooking customer(Customer customer) {
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public TableBooking id(Long id) {
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

  public TableBooking status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TableBooking tables(List<RestaurantTable> tables) {
    this.tables = tables;
    return this;
  }

  public TableBooking addTablesItem(RestaurantTable tablesItem) {
    if (this.tables == null) {
      this.tables = new ArrayList<RestaurantTable>();
    }
    this.tables.add(tablesItem);
    return this;
  }

   /**
   * Get tables
   * @return tables
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RestaurantTable> getTables() {
    return tables;
  }

  public void setTables(List<RestaurantTable> tables) {
    this.tables = tables;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TableBooking tableBooking = (TableBooking) o;
    return Objects.equals(this.bookTime, tableBooking.bookTime) &&
        Objects.equals(this.customer, tableBooking.customer) &&
        Objects.equals(this.id, tableBooking.id) &&
        Objects.equals(this.status, tableBooking.status) &&
        Objects.equals(this.tables, tableBooking.tables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookTime, customer, id, status, tables);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableBooking {\n");
    
    sb.append("    bookTime: ").append(toIndentedString(bookTime)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tables: ").append(toIndentedString(tables)).append("\n");
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

