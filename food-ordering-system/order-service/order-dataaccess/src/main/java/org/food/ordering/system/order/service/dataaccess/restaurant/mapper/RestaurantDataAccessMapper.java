package org.food.ordering.system.order.service.dataaccess.restaurant.mapper;

import org.food.ordering.system.domain.valueobject.Money;
import org.food.ordering.system.domain.valueobject.ProductId;
import org.food.ordering.system.domain.valueobject.RestaurantId;
import org.food.ordering.system.order.service.dataaccess.restaurant.entity.RestaurantEntity;
import org.food.ordering.system.order.service.dataaccess.restaurant.exceptiom.RestaurantDataAccessException;
import org.food.ordering.system.order.service.domain.entity.Product;
import org.food.ordering.system.order.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataAccessMapper {


    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Restaurant restaurantEntitiesToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity = restaurantEntities.stream().findFirst().orElseThrow(() ->
                new RestaurantDataAccessException("Restaurant could not be found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                        new Product(new ProductId(entity.getProductId()), entity.getProductName(),
                                new Money(entity.getProductPrice())))
                .collect(Collectors.toList());

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .active(restaurantEntity.getRestaurantActive())
                .products(restaurantProducts)
                .build();

    }
}
