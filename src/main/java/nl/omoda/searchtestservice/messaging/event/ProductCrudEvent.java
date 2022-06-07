package nl.omoda.ecsearchservice.messaging.event;

import nl.omoda.ecsearchservice.messaging.dto.ProductDto;

public class ProductCrudEvent {
    private final String crudType;
    private final ProductDto payload;

    public ProductCrudEvent(String crudType, ProductDto payload) {
        this.crudType = crudType;
        this.payload = payload;
    }

    public String getCrudType() {
        return this.crudType;
    }

    public ProductDto getPayload() {
        return this.payload;
    }

    @Override
    public String toString() {
        return "{" +
                " crudType='" + getCrudType() + "'" +
                ", payload='" + getPayload() + "'" +
                "}";
    }
}
