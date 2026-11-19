
package com.flashsolution.lumierebeauty.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashsolution.lumierebeauty.entity.WishlistItem;
import com.flashsolution.lumierebeauty.service.WishlistItemService;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "*")
public class WishlistItemController {

    private final WishlistItemService wishlistItemService;

    public WishlistItemController(WishlistItemService wishlistItemService) {
        this.wishlistItemService = wishlistItemService;
    }

    @GetMapping
    public List<WishlistItem> getAllWishlistItems() {
        return wishlistItemService.getAllWishlistItems();
    }

    @PostMapping
    public WishlistItem addWishlistItem(@RequestBody WishlistItem item) {
        return wishlistItemService.addWishlistItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteWishlistItem(@PathVariable Long id) {
        wishlistItemService.deleteWishlistItem(id);
    }
}
