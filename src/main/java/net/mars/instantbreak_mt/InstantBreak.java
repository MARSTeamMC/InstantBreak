package net.mars.instantbreak_mt;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(InstantBreak.MOD_ID)
public class InstantBreak {
    public static final String MOD_ID = "instantbreak_mt";
    public static final double MDECILLION = Math.pow(10, 256);

    public static final Logger LOGGER = LogUtils.getLogger();

    public InstantBreak(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        String version = ModList.get().getModContainerById(MOD_ID).orElseThrow(() -> new RuntimeException("Mod not Found")).getModInfo().getVersion().toString();

        LOGGER.info("[{}] v{} initialized by MARS Team.", MOD_ID, version);
    }
}