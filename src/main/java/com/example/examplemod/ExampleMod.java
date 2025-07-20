package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "autovoid";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static ExampleMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("2muu OP");
    }


    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getMinecraft();
        GuiScreen current = mc.currentScreen;

        if (current != null) {
            if (current.getClass().getSimpleName().toLowerCase().contains("chat")) {
                render();
            }
        } else {
            render();
        }
    }

    public void render() {
        Minecraft mc = Minecraft.getMinecraft();
        FontRenderer fr = mc.fontRendererObj;
        ScaledResolution sr = new ScaledResolution(mc);

        String text = "Auto Void §7Hypixel";
        int x = sr.getScaledWidth() - fr.getStringWidth(text) - 5;
        int y = 5;

        fr.drawString(text, x, y, 0x19bfe0, true);
    }
}
