package me.rtnasenbaer.myfirstmod.block

import me.rtnasenbaer.myfirstmod.MyFirstMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModBlocks {

    val ancientScaleBlock = registerModBlock("ancient_scale_block", Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).breakInstantly()))
    val scaleBlock = registerModBlock("scale_block", Block(FabricBlockSettings.copyOf(Blocks.BONE_BLOCK).breakInstantly()))
    val enclosedFossils = registerModBlock("enclosed_fossils", Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE)))

    fun registerModBlock(name: String, block: Block) : Block {
        registerModBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier(MyFirstMod.MOD_ID, name), block)
    }

    fun registerModBlockItem(name: String, block: Block) : Item {
        return Registry.register(Registries.ITEM, Identifier(MyFirstMod.MOD_ID, name), BlockItem(block, FabricItemSettings()))
    }
    fun registerModBlocks() {
        MyFirstMod.logger.info("Registering Mod Blocks for ${MyFirstMod.MOD_ID}")
    }
}