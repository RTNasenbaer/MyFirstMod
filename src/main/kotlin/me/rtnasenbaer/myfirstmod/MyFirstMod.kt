package me.rtnasenbaer.myfirstmod

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItemGroups
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object MyFirstMod : ModInitializer {
	const val MOD_ID: String = "myfirstmod"
	val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Initializing of $MOD_ID")
		ModItemGroups.registerModItemGroups()

		ModItems.registerModItems()
		ModBlocks.registerModBlocks()
	}
}