package dev.luzifersenpai.xtonereworkedextended;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import dev.luzifersenpai.xtonereworkedextended.init.BlockInit;

@Mod(XtoneReworkedExtended.MODID)
public class XtoneReworkedExtended {
    public static final String MODID = "xtonereworkedextended";

    public XtoneReworkedExtended() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        BlockInit.ITEMS.register(bus);
        BlockInit.TABS.register(bus);
    }
}
