package nl.omoda.ecsearchservice.messaging.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StockMutationDto {

    @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "productOptionId")
    private ProductOptionDto productOption;

    private int amount;

    protected StockMutationDto() {}

    public StockMutationDto(ProductOptionDto productOption, int amount) {
        this.productOption = productOption;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", productOption='" + getProductOption() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public ProductOptionDto getProductOption() {
        return this.productOption;
    }

    public void setProductOption(ProductOptionDto productOption) {
        this.productOption = productOption;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
