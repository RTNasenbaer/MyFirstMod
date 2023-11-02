package me.rtnasenbaer.myfirstmod

import me.rtnasenbaer.myfirstmod.blocks.MyBlock
import me.rtnasenbaer.myfirstmod.items.MyItem
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object MyFirstMod : ModInitializer {
	private const val NAMESPACE: String = "myfirstmod"
    private val logger = LoggerFactory.getLogger(NAMESPACE)

	private val modItemGroup: ItemGroup = FabricItemGroup.builder()
		.icon{ItemStack(myBlockItem)}
		.displayName(Text.translatable("itemGroup.$NAMESPACE.mod_item_group"))
		.entries{ _, entries -> entries.addAll(listOf(ItemStack(myItem), ItemStack(myBlockItem)))}
		.build()
	private val myBlock: MyBlock = MyBlock(FabricBlockSettings.create().strength(4.0f))
	private val myBlockItem: BlockItem = BlockItem(myBlock, FabricItemSettings().fireproof())
	val myItem: MyItem = MyItem(FabricItemSettings().maxCount(16))

	override fun onInitialize() {
		logger.info("Hello Fabric world!")
		Registry.register(Registries.ITEM_GROUP, Identifier(NAMESPACE, "mod_item_group"), modItemGroup)
		Registry.register(Registries.BLOCK, Identifier(NAMESPACE, "my_block"), myBlock)
		Registry.register(Registries.ITEM, Identifier(NAMESPACE, "my_block"), myBlockItem)
		Registry.register(Registries.ITEM, Identifier(NAMESPACE, "my_item"), myItem)

	}
}