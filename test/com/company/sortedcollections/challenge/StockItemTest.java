package com.company.sortedcollections.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StockItemTest {

    StockItem stockItem;

    @BeforeEach
    void setUp(){
        stockItem = new StockItem("NameOfStock", 10, 1);
    }

    @Nested
    @DisplayName("Tests for reserving stock logic")
    class itemReservation{

        @Test
        @DisplayName("Attempt to reserve no items")
        void availableQuantity_no_reserv() {
            assertEquals(1, stockItem.availableQuantity());
        }

        @Test
        @DisplayName("Attempt to reserve 1 item")
        void availableQuantity_one_item_reserved() {
            stockItem.reserveStock(1);
            assertEquals(0, stockItem.availableQuantity());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, 2})
        @DisplayName("Attempt to reserve incorrect number of items: 0, -1, moreThanAvailable")
        void availableQuantity_incorrectNumberOfItemsReserved(int val) {
            stockItem.reserveStock(val);
            assertEquals(1, stockItem.availableQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for setting price logic")
    class settingItemPrice {

        @Test
        @DisplayName("Attempt to change price to 20")
        void setPrice_to_20() {
            stockItem.setPrice(20);
            assertEquals(20, stockItem.getPrice());
        }

        @ParameterizedTest
        @ValueSource(doubles = {0, -1})
        @DisplayName("Attempt to change price for incorrect values: to 0, -1")
        void setPrice_to_minusOne(double val) {
            stockItem.setPrice(val);
            assertEquals(10, stockItem.getPrice());
        }
    }
}