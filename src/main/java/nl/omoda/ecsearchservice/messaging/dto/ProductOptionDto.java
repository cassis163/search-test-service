package nl.omoda.ecsearchservice.messaging.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductOptionDto {
    @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private ProductDto product;

    private String name;

    protected ProductOptionDto() {}

    public ProductOptionDto(Long id, ProductDto product, String name) {
        this.id = id;
        this.product = product;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", product='" + getProduct() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return this.product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
