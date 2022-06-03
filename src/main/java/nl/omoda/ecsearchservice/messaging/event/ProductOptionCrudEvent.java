package nl.omoda.ecsearchservice.messaging.event;

import nl.omoda.ecsearchservice.messaging.dto.ProductOptionDto;

public class ProductOptionCrudEvent {
    private final String crudType;
    private final ProductOptionDto payload;

    public ProductOptionCrudEvent(String crudType, ProductOptionDto payload) {
        this.crudType = crudType;
        this.payload = payload;
    }

    public String getCrudType() {
        return this.crudType;
    }

    public ProductOptionDto getPayload() {
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
