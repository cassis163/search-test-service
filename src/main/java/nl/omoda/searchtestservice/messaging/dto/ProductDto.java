package nl.omoda.ecsearchservice.messaging.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductDto {

    @Id
    private Long id;

    private String name;

    protected ProductDto() {}

    public ProductDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
