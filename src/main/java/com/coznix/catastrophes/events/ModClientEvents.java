package com.coznix.catastrophes.events;
import com.coznix.catastrophes.Catastrophes;
import com.coznix.catastrophes.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Catastrophes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {


    @SubscribeEvent
    public static void onCatalystUseAir(PlayerInteractEvent.RightClickItem event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == RegistryHandler.CATALYST.get()) {
            World world = player.getEntityWorld();

            PlayerEntity player_for_text = event.getPlayer();

            if (!event.getPlayer().getEntityWorld().isRemote) {
                String msg = TextFormatting.DARK_RED + "The Catastrophe Cycle has been Enabled!";
                player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
            }
        }
    }
}
