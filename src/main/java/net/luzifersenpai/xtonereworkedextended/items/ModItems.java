package net.luzifersenpai.xtonereworkedextended.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.luzifersenpai.xtonereworkedextended.XtoneReworkedExtended;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XtoneReworkedExtended.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
