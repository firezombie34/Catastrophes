package com.coznix.catastrophes.events;

import com.coznix.catastrophes.Catastrophes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Catastrophes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)

public class ModServerEvents {

    @SubscribeEvent
    public static void onServerChat(ServerChatEvent event) { }
}
