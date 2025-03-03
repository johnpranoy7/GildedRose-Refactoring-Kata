package com.gildedrose;

class GildedRose {
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (item.quality > 0 && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }


                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }

                    }
                }
            }

            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (item.quality > 0 && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            item.quality = item.quality - 1;
                        }

                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
