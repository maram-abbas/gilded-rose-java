package com.gildedrose;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";

    public static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private int decreaseQuality(int oldQuality)
    {
        if(oldQuality > 0)
            return oldQuality - 1;

        return 0;
    }

    private int increaseQuality (int oldQuality)
    {
        if(oldQuality < MAX_QUALITY)
            return oldQuality + 1;

        return oldQuality;
    }

    private int decreaseSellIn(int oldSellIn)
    {
        return oldSellIn - 1;
    }

    private void updateAgedBrieQuality(Item item)
    {
        item.quality = increaseQuality(item.quality);

        if(item.sellIn < 0)
            item.quality = increaseQuality(item.quality);
    }

    private void updateBackStageQuality(Item item)
    {
        item.quality = increaseQuality(item.quality);

        if(item.sellIn < 10)
            item.quality = increaseQuality(item.quality);

        if (item.sellIn < 5)
            item.quality = increaseQuality(item.quality);

        if(item.sellIn < 0)
            item.quality = 0;
    }

    private void updateConjuredQuality(Item item)
    {
        if(item.sellIn < 0)
        {
            item.quality = decreaseQuality(item.quality);
            item.quality = decreaseQuality(item.quality);
            item.quality = decreaseQuality(item.quality);
            item.quality = decreaseQuality(item.quality);
        }
        else
        {
            item.quality = decreaseQuality(item.quality);
            item.quality = decreaseQuality(item.quality);
        }
    }

    public void updateQuality()
    {
        for(Item item : items)
        {
            if(!item.name.equals(SULFURAS))
            {
                item.sellIn = decreaseSellIn(item.sellIn);

                if(item.name.equals(AGED_BRIE))
                    updateAgedBrieQuality(item);

                else if(item.name.equals(BACKSTAGE))
                    updateBackStageQuality(item);

                else if(item.name.equals(CONJURED))
                    updateConjuredQuality(item);

                else {
                    item.quality = decreaseQuality(item.quality);

                    if(item.sellIn < 0)
                        item.quality = decreaseQuality(item.quality);
                }
            }
        }
    }
}