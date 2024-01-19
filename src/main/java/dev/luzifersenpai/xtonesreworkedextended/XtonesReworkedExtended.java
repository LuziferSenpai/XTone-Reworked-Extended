package dev.luzifersenpai.xtonesreworkedextended;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import dev.luzifersenpai.xtonesreworkedextended.init.BlockInit;
import dev.luzifersenpai.xtonesreworkedextended.blocks.*;

@Mod(XtonesReworkedExtended.MODID)
public class XtonesReworkedExtended {
    public static final String MODID = "xtonesreworkedextended";

    public XtonesReworkedExtended() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        BlockInit.ITEMS.register(bus);
        BlockInit.TABS.register(bus);

        LaveWhite.stupidJava();
        LaveLightGray.stupidJava();
        LaveGray.stupidJava();
        LaveBlack.stupidJava();
        LaveBrown.stupidJava();
        LaveRed.stupidJava();
        LaveOrange.stupidJava();
        LaveYellow.stupidJava();
        LaveLime.stupidJava();
        LaveGreen.stupidJava();



        LavePurple.stupidJava();


    }
}
