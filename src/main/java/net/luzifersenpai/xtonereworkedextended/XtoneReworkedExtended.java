package net.luzifersenpai.xtonereworkedextended;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.tobsend.xtonesreworked.block.ModBlocks;

import net.luzifersenpai.xtonereworkedextended.blocks.LavePurpleBlocks;
import net.luzifersenpai.xtonereworkedextended.items.ModItems;

import java.util.ArrayList;
import java.util.Collection;

@Mod(XtoneReworkedExtended.MODID)
public class XtoneReworkedExtended {
    public static final String MODID = "xtonereworkedextended";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public XtoneReworkedExtended() {
        LOGGER.info("SETUP Xtones Reworked Extended");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        LavePurpleBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register(
            "xtonesextendedtab",
            () ->
                    CreativeModeTab
                            .builder()
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .icon(() -> new ItemStack(ModBlocks.XTONE_TILE.get()))
                            .displayItems((parameters, output) -> {
                                output.acceptAll(buildCreativeTabList());
                            })
                            .title(Component.translatable("itemGroup.xtonesreworkedextended"))
                            .build()
    );

    private static Collection<ItemStack> buildCreativeTabList() {
        Collection<ItemStack> tabEntries = new ArrayList<>();

        ModItems.ITEMS
                .getEntries()
                .forEach(item -> tabEntries.add(new ItemStack(item.get())));

        return tabEntries;
    };


    private void commonSetup(final FMLCommonSetupEvent event) {}

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
