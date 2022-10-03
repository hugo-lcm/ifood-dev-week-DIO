package me.dio.bag.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.bag.enumeration.PaymentMethod;
import me.dio.bag.model.Bag;
import me.dio.bag.model.Item;
import me.dio.bag.model.Restaurant;
import me.dio.bag.repository.BagRepository;
import me.dio.bag.repository.ItemRepository;
import me.dio.bag.repository.ProductRepository;
import me.dio.bag.resource.dto.ItemDto;
import me.dio.bag.service.BagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BagServiceImpl implements BagService {

    private final BagRepository bagRepository;
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;

    @Override
    public Bag displayBag(Long id) {

        return bagRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("this bag does not exist!");
                }
        );

    }

    @Override
    public Bag closeBag(Long id, int numberPaymentMethod) {

        Bag bag = displayBag(id);
        if (bag.getItems().isEmpty()) {
            throw new RuntimeException("this bag is empty!");
        }
        PaymentMethod paymentMethod =
                numberPaymentMethod == 0 ? PaymentMethod.CASH : PaymentMethod.MACHINE;
        bag.setPaymentMethod(paymentMethod);
        bag.setClosed(true);
        return bagRepository.save(bag);

    }

    @Override
    public Item addItemToBag(ItemDto itemDto) {

        Bag bag = displayBag(itemDto.getBagId());
        if (bag.isClosed()) {
            throw new RuntimeException("this bag is closed!");
        }
        Item itemToBeInserted = Item.builder()
                .quantity(itemDto.getQuantity())
                .bag(bag)
                .product(productRepository.findById(itemDto.getProductId()).orElseThrow(
                        () -> {
                            throw new RuntimeException("this product does not exist!");
                        }
                ))
                .build();
        List<Item> bagItems = bag.getItems();
        if (bagItems.isEmpty()) {
            bagItems.add(itemToBeInserted);
        } else {
            Restaurant actualRestaurant = bagItems.get(0).getProduct().getRestaurant();
            Restaurant restaurantOfItemToBeAdd = itemToBeInserted.getProduct().getRestaurant();
            if (actualRestaurant.equals(restaurantOfItemToBeAdd)) {
                bagItems.add(itemToBeInserted);
            } else {
                throw new RuntimeException("it is not possible to add products from different restaurants. " +
                        "Empty the bag or choose products from the same restaurant!");
            }
        }

        List<Double> valueOfItems = new ArrayList<>();
        for (Item bagItem: bagItems) {
            double totalItemValue = bagItem.getProduct().getUnitaryValue() * bagItem.getQuantity();
            valueOfItems.add(totalItemValue);
        }

        double totalBagValue = valueOfItems.stream()
                .mapToDouble(totalValueOfEachItem -> totalValueOfEachItem)
                .sum();

        bag.setTotalValue(totalBagValue);
        bagRepository.save(bag);
        return itemToBeInserted;
    }
}
