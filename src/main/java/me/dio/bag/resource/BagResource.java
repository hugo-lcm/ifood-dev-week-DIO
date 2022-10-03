package me.dio.bag.resource;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.bag.model.Bag;
import me.dio.bag.model.Item;
import me.dio.bag.resource.dto.ItemDto;
import me.dio.bag.service.BagService;
import org.springframework.web.bind.annotation.*;

@Api(value="/ifood-devweek/bags")
@RestController
@RequestMapping("/ifood-devweek/bags")
@RequiredArgsConstructor
public class BagResource {

    private final BagService bagService;

    @PostMapping
    public Item addItemToBag(@RequestBody ItemDto itemDto) {
        return bagService.addItemToBag(itemDto);
    }

    @GetMapping("/{id}")
    public Bag displayBag(@PathVariable("id") Long id) {
        return bagService.displayBag(id);
    }

    @PatchMapping("/closeBag/{bagId}")
    public Bag closeBag(@PathVariable("bagId") Long bagId,
                        @RequestParam("paymentMethod") int paymentMethod) {
        return bagService.closeBag(bagId, paymentMethod);
    }

}
