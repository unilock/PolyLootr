package cc.unilock.polylootr.mixin;

import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import net.zestyblaze.lootr.Lootr;
import net.zestyblaze.lootr.init.ModBlockEntities;
import net.zestyblaze.lootr.init.ModEntities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Lootr.class)
public class LootrMixin {
	@Inject(method = "onInitialize", at = @At("TAIL"), remap = false)
	private void onInitialize(CallbackInfo ci) {
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_BARREL);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_CHEST);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_INVENTORY);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_SHULKER);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_TRAPPED_LOOT_CHEST);

		PolymerEntityUtils.registerType(ModEntities.LOOTR_MINECART_ENTITY);
	}
}
