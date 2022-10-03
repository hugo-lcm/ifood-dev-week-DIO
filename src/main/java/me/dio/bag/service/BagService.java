package me.dio.bag.service;

import me.dio.bag.model.Bag;
import me.dio.bag.model.Item;
import me.dio.bag.resource.dto.ItemDto;

public interface BagService {

    Bag displayBag(Long id);
    Bag closeBag(Long id, int paymentMethod);
    Item addItemToBag(ItemDto itemDto);

}
