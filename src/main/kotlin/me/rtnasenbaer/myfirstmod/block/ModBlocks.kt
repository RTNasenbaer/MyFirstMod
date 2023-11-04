package me.rtnasenbaer.myfirstmod.block

import me.rtnasenbaer.myfirstmod.MyFirstMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.MapColor
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object ModBlocks {

    val ANCIENT_SCALE_BLOCK = registerModBlock("ancient_scale_block", Block(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).strength(1.5f).sounds(BlockSoundGroup.BONE).breakInstantly()))
    val SCALE_BLOCK = registerModBlock("scale_block", Block(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).strength(1.5f).sounds(BlockSoundGroup.BONE).breakInstantly()))
    val ENCLOSED_FOSSILS = registerModBlock("enclosed_fossils", Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE).strength(4.5F, 3.0F).requiresTool()))

    private fun registerModBlock(name: String, block: Block) : Block {
        registerModBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier(MyFirstMod.MOD_ID, name), block)
    }

    private fun registerModBlockItem(name: String, block: Block) : Item {
        return Registry.register(Registries.ITEM, Identifier(MyFirstMod.MOD_ID, name), BlockItem(block, FabricItemSettings()))
    }
    fun registerModBlocks() {
        MyFirstMod.logger.info("Registering Mod Blocks for ${MyFirstMod.MOD_ID}")
    }
}