package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(output: FabricDataOutput,completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun configure(arg: RegistryWrapper.WrapperLookup?) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.FOSSIL_HELMET, ModItems.FOSSIL_CHESTPLATE, ModItems.FOSSIL_LEGGINGS, ModItems.FOSSIL_BOOTS)
    }
}