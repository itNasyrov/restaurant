package restaurant.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Document
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-02T23:40:43.246+05:00")

public class Document   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("documentItems")
  private List<DocumentItem> documentItems = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  public Document description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Document documentItems(List<DocumentItem> documentItems) {
    this.documentItems = documentItems;
    return this;
  }

  public Document addDocumentItemsItem(DocumentItem documentItemsItem) {
    if (this.documentItems == null) {
      this.documentItems = new ArrayList<DocumentItem>();
    }
    this.documentItems.add(documentItemsItem);
    return this;
  }

   /**
   * Get documentItems
   * @return documentItems
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<DocumentItem> getDocumentItems() {
    return documentItems;
  }

  public void setDocumentItems(List<DocumentItem> documentItems) {
    this.documentItems = documentItems;
  }

  public Document id(Long id) {
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

  public Document name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Document document = (Document) o;
    return Objects.equals(this.description, document.description) &&
        Objects.equals(this.documentItems, document.documentItems) &&
        Objects.equals(this.id, document.id) &&
        Objects.equals(this.name, document.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, documentItems, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Document {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    documentItems: ").append(toIndentedString(documentItems)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

