package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void checkExpiredItemQuality () {
        Item[] items = new Item[] { new Item("item1", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void checkItemQualityNegative () {
        Item[] items = new Item[] { new Item("item1", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void checkAgedBrieQuality () {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void checkItemQualityMax () {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void checkSulfurasQuality () {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);
    }

    @Test
    void checkSulfurasSellIn () {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void checkBackStageTenOrLess () {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void checkBackStageFiveOrLess () {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33, app.items[0].quality);
    }

    @Test
    void checkBackStageOverTen () {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void checkBackStageQualityAfterConcert () {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void checkConjuredQualityAfterNoSellIn () {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }
    @Test
    void checkConjuredQuality () {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

}
