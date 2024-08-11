package cc.unilock.polylootr.mixin;

import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import noobanidus.mods.lootr.fabric.Lootr;
import noobanidus.mods.lootr.fabric.init.ModBlockEntities;
import noobanidus.mods.lootr.fabric.init.ModEntities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Lootr.class)
public class LootrMixin {
	@Inject(method = "onInitialize", at = @At("TAIL"), remap = false)
	private void onInitialize(CallbackInfo ci) {
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_BARREL);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_CHEST);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_INVENTORY);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_SHULKER);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_TRAPPED_CHEST);

		PolymerEntityUtils.registerType(ModEntities.LOOTR_MINECART_ENTITY);
	}
}
