package com.coznix.catastrophes.items;

import com.coznix.catastrophes.Catastrophes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(Catastrophes.TAB));
    }
}
