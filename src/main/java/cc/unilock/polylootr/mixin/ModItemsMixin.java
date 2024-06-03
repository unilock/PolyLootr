package cc.unilock.polylootr.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.zestyblaze.lootr.init.ModBlocks;
import net.zestyblaze.lootr.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ModItems.class)
public class ModItemsMixin {
	@WrapOperation(method = "<clinit>", at = @At(value = "NEW", target = "(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/world/item/Item$Properties;)Lnet/minecraft/world/item/BlockItem;"))
	private static BlockItem newBlockItem(Block block, Item.Properties properties, Operation<BlockItem> original) {
		if (block.equals(ModBlocks.BARREL)) {
			return new PolymerBlockItem(block, properties, Items.BARREL);
		}
		if (block.equals(ModBlocks.CHEST)) {
			return new PolymerBlockItem(block, properties, Items.CHEST);
		}
		if (block.equals(ModBlocks.INVENTORY)) {
			return new PolymerBlockItem(block, properties, Items.CHEST);
		}
		if (block.equals(ModBlocks.SHULKER)) {
			return new PolymerBlockItem(block, properties, Items.SHULKER_BOX);
		}
		if (block.equals(ModBlocks.TRAPPED_CHEST)) {
			return new PolymerBlockItem(block, properties, Items.TRAPPED_CHEST);
		}
		if (block.equals(ModBlocks.TROPHY)) {
			return new PolymerBlockItem(block, properties, Items.PLAYER_HEAD);
		}

		return original.call(block, properties);
	}
}
