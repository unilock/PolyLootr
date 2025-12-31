package cc.unilock.polylootr.mixin;

import cc.unilock.polylootr.util.SimplePolymerBlockWithEntity;
import cc.unilock.polylootr.util.SimplePolymerItem;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.block.PolymerHeadBlock;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import noobanidus.mods.lootr.fabric.Lootr;
import noobanidus.mods.lootr.fabric.init.ModBlockEntities;
import noobanidus.mods.lootr.fabric.init.ModBlocks;
import noobanidus.mods.lootr.fabric.init.ModEntities;
import noobanidus.mods.lootr.fabric.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.nucleoid.packettweaker.PacketContext;

@Mixin(Lootr.class)
public class LootrMixin {
	@Inject(method = "onInitialize", at = @At("TAIL"), remap = false)
	private void onInitialize(CallbackInfo ci) {
		PolymerBlockUtils.registerOverlay(ModBlocks.BARREL, new SimplePolymerBlockWithEntity(Blocks.BARREL, BlockEntityType.BARREL));
		PolymerBlockUtils.registerOverlay(ModBlocks.CHEST, new SimplePolymerBlockWithEntity(Blocks.CHEST, BlockEntityType.CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.INVENTORY, new SimplePolymerBlockWithEntity(Blocks.CHEST, BlockEntityType.CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.SHULKER, new SimplePolymerBlockWithEntity(Blocks.SHULKER_BOX, BlockEntityType.SHULKER_BOX));
		PolymerBlockUtils.registerOverlay(ModBlocks.TRAPPED_CHEST, new SimplePolymerBlockWithEntity(Blocks.TRAPPED_CHEST, BlockEntityType.TRAPPED_CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.TROPHY, new PolymerHeadBlock() {
			@Override
			public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
				return Blocks.PLAYER_HEAD.withPropertiesOf(state);
			}

			// https://minecraft.novaskin.me/skin/6459833115/Trophy-gold
			@Override
			public String getPolymerSkinValue(BlockState state, BlockPos pos, PacketContext context) {
				return "ewogICJ0aW1lc3RhbXAiIDogMTY5MTM1OTg5MTMxOSwKICAicHJvZmlsZUlkIiA6ICJiNGJmZDZhNmRiZGQ0MDg2ODRhYmIzYzlmNDQyNmRiYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJWZXJzYWNlNjciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU2MDVhN2NlNThhNzExZGU3Y2UxYzRiOGM4MjhkY2ZkNjZjYWE1M2Q3MTIwNGQ0NTNmMGViZDM1ZTk5YzJhNiIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9";
			}
		});

		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_BARREL, (obj, ctx) -> BlockEntityType.BARREL);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_CHEST, (obj, ctx) -> BlockEntityType.CHEST);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_INVENTORY, (obj, ctx) -> BlockEntityType.CHEST);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_SHULKER, (obj, ctx) -> BlockEntityType.SHULKER_BOX);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.LOOTR_TRAPPED_CHEST, (obj, ctx) -> BlockEntityType.TRAPPED_CHEST);

		PolymerItemUtils.registerOverlay(ModItems.BARREL, new SimplePolymerItem(Items.BARREL));
		PolymerItemUtils.registerOverlay(ModItems.CHEST, new SimplePolymerItem(Items.CHEST));
		PolymerItemUtils.registerOverlay(ModItems.INVENTORY, new SimplePolymerItem(Items.CHEST));
		PolymerItemUtils.registerOverlay(ModItems.SHULKER, new SimplePolymerItem(Items.SHULKER_BOX));
		PolymerItemUtils.registerOverlay(ModItems.TRAPPED_CHEST, new SimplePolymerItem(Items.TRAPPED_CHEST));
		PolymerItemUtils.registerOverlay(ModItems.TROPHY, new SimplePolymerItem(Items.PLAYER_HEAD));

		PolymerEntityUtils.registerOverlay(ModEntities.LOOTR_MINECART_ENTITY, obj -> ctx -> EntityType.CHEST_MINECART);
	}
}
