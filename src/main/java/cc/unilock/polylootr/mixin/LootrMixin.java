package cc.unilock.polylootr.mixin;

import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zestyblaze.lootr.Lootr;
import net.zestyblaze.lootr.init.ModBlockEntities;
import net.zestyblaze.lootr.init.ModEntities;
import net.zestyblaze.lootr.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Lootr.class)
public class LootrMixin {
	@Inject(method = "onInitialize", at = @At("TAIL"))
	private void onInitialize(CallbackInfo ci) {
		PolymerItemUtils.ITEM_CHECK.register((itemStack) ->
			itemStack.is(ModItems.BARREL)
				|| itemStack.is(ModItems.CHEST)
				|| itemStack.is(ModItems.INVENTORY)
				|| itemStack.is(ModItems.SHULKER)
				|| itemStack.is(ModItems.TRAPPED_CHEST)
				|| itemStack.is(ModItems.TROPHY)
		);

		PolymerItemUtils.ITEM_MODIFICATION_EVENT.register((original, client, player) -> {
			ItemStack stack = null;

			if (original.is(ModItems.BARREL)) {
				stack = Items.BARREL.getDefaultInstance();
			}
			if (original.is(ModItems.CHEST)) {
				stack = Items.CHEST.getDefaultInstance();
			}
			if (original.is(ModItems.INVENTORY)) {
				stack = Items.CHEST.getDefaultInstance();
			}
			if (original.is(ModItems.SHULKER)) {
				stack = Items.SHULKER_BOX.getDefaultInstance();
			}
			if (original.is(ModItems.TRAPPED_CHEST)) {
				stack = Items.TRAPPED_CHEST.getDefaultInstance();
			}
			if (original.is(ModItems.TROPHY)) {
				stack = Items.PLAYER_HEAD.getDefaultInstance();
			}

			if (stack != null) {
				stack.setTag(original.getTag());
				return stack;
			}

			return original;
		});

		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_BARREL);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_CHEST);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_INVENTORY);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_LOOT_SHULKER);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SPECIAL_TRAPPED_LOOT_CHEST);

		PolymerEntityUtils.registerType(ModEntities.LOOTR_MINECART_ENTITY);
	}
}
