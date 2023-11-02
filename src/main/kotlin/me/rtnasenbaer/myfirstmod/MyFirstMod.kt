package me.rtnasenbaer.myfirstmod

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object MyFirstMod : ModInitializer {
	private const val NAMESPACE: String = "myfirstmod"
    private val logger = LoggerFactory.getLogger(NAMESPACE)

	override fun onInitialize() {
		logger.info("Hello Fabric world!")

	}
}