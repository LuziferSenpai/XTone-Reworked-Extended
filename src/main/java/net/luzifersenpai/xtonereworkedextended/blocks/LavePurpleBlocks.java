package net.luzifersenpai.xtonereworkedextended.blocks;

import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.tobsend.xtonesreworked.block.custom.XBlock;

import net.luzifersenpai.xtonereworkedextended.XtoneReworkedExtended;
import net.luzifersenpai.xtonereworkedextended.items.ModItems;

public class LavePurpleBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, XtoneReworkedExtended.MODID);

    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_0 = registerBlock("lave_block_purple_0", XBlock::new);

    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_1 = registerBlock("lave_block_purple_1", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_2 = registerBlock("lave_block_purple_2", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_3 = registerBlock("lave_block_purple_3", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_4 = registerBlock("lave_block_purple_4", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_5 = registerBlock("lave_block_purple_5", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_6 = registerBlock("lave_block_purple_6", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_7 = registerBlock("lave_block_purple_7", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_8 = registerBlock("lave_block_purple_8", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_9 = registerBlock("lave_block_purple_9", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_10 = registerBlock("lave_block_purple_10", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_11 = registerBlock("lave_block_purple_11", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_12 = registerBlock("lave_block_purple_12", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_13 = registerBlock("lave_block_purple_13", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_14 = registerBlock("lave_block_purple_14", XBlock::new);
    public static final RegistryObject<Block> LAVE_BLOCK_PURPLE_15 = registerBlock("lave_block_purple_15", XBlock::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
