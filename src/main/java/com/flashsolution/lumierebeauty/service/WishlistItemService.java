
package com.flashsolution.lumierebeauty.service;

import com.flashsolution.lumierebeauty.entity.WishlistItem;
import com.flashsolution.lumierebeauty.entity.Product;
import com.flashsolution.lumierebeauty.repository.WishlistItemRepository;
import com.flashsolution.lumierebeauty.repository.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WishlistItemService {

    private final WishlistItemRepository wishlistItemRepository;
    private final ProductRepository productRepository;

    public WishlistItemService(
            WishlistItemRepository wishlistItemRepository,
            ProductRepository productRepository) {
        this.wishlistItemRepository = wishlistItemRepository;
        this.productRepository = productRepository;
    }

    public List<WishlistItem> getAllWishlistItems() {
        return wishlistItemRepository.findAll();
    }

    public WishlistItem addWishlistItem(WishlistItem item) {

        if (item.getProduct() == null ||
            item.getProduct().getId() == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Product ID is required"
            );
        }

        Long productId = item.getProduct().getId();

        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Product not found: " + productId
            ));

        item.setProduct(product);

        return wishlistItemRepository.save(item);
    }

    public void deleteWishlistItem(Long id) {
        wishlistItemRepository.deleteById(id);
    }
}
