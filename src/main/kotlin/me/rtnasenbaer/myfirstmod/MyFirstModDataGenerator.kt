package me.rtnasenbaer.myfirstmod

import me.rtnasenbaer.myfirstmod.datagen.*
import me.rtnasenbaer.myfirstmod.world.ModConfiguredFeatures
import me.rtnasenbaer.myfirstmod.world.ModPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.registry.RegistryBuilder
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

object MyFirstModDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack: FabricDataGenerator.Pack = fabricDataGenerator.createPack()
		pack.addProvider { output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup> -> ModBlockTagProvider(output, registriesFuture) }
		pack.addProvider { output: FabricDataOutput, completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup> -> ModItemTagProvider(output, completableFuture) }
		pack.addProvider { dataOutput: FabricDataOutput -> ModLootTableProvider(dataOutput) }
		pack.addProvider { output: FabricDataOutput -> ModModelProvider(output) }
		pack.addProvider { output: FabricDataOutput -> ModRecipeProvider(output) }
		pack.addProvider { output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup> -> ModWorldGenerator(output, registriesFuture) }
	}

	override fun buildRegistry(registryBuilder: RegistryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
	}
}