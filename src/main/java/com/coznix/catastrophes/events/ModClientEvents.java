package com.coznix.catastrophes.events;

import com.coznix.catastrophes.Catastrophes;
import com.coznix.catastrophes.util.RegistryHandler;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Catastrophes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent // LivingEntity#
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == Items.STICK)  {
            Catastrophes.LOGGER.info("Player tried to jump with a stick!");
            World world = player.getEntityWorld();
            world.setBlockState(player.func_233580_cy_().add(0, -1, 0), RegistryHandler.RUBY_BLOCK.get().getDefaultState());
         }
     }
}
