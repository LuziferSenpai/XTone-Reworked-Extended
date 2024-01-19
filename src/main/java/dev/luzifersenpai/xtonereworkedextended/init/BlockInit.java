package dev.luzifersenpai.xtonereworkedextended.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import dev.luzifersenpai.xtonereworkedextended.blocks.LavePurple;
import dev.luzifersenpai.xtonereworkedextended.XtoneReworkedExtended;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, XtoneReworkedExtended.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XtoneReworkedExtended.MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, XtoneReworkedExtended.MODID);

    public static final List<Supplier<? extends ItemLike>> XTONE_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> XTONE_REWORKED_EXTEND_TAB = TABS.register(
            "xtone_reworked_extended_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.xtone_reworked_extended"))
                    .icon(LavePurple.LAVE_BLOCK_PURPLE_0.get()::getDefaultInstance)
                    .displayItems(((itemDisplayParameters, output) -> XTONE_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()))))
                    .build()
    );

    public static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name) {
        RegistryObject<Block> newBlock = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of().strength(6F).requiresCorrectToolForDrops()));
        RegistryObject<BlockItem> newBlockItem = ITEMS.register(name, () -> new BlockItem(newBlock.get(), new Item.Properties()));

        XTONE_TAB_ITEMS.add(newBlockItem);

        return newBlockItem;
    }
}
