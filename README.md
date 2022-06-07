# search-test-service
Used for testing the applicability of event sourcing!
## Behaviour
Receives Pub/Sub messages from the product-test-service and stock-test-service and processes them into events.
The resulting events will be registered and managed (possibly with EventStoreDB).
Event sourcing revolves around deriving state from a start (snapshot) and a series of events.
In this case, the stored events will be used to get the state of product options, stock and possibly products.

<img src="https://user-images.githubusercontent.com/42798012/171846720-42aaa42b-9212-4759-94a2-53396280f58a.png" height="300px">

Event sourcing is often implemented with the CQRS pattern to make it more intuitive.
However, CQRS is not a requirement for the implementation of event sourcing.

<img src="https://user-images.githubusercontent.com/42798012/171845833-67f30019-3974-444b-b8f3-3bd1c0bd32eb.png" width="100%">
