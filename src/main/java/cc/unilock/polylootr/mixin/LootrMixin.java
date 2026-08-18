package cc.unilock.polylootr.mixin;

import cc.unilock.polylootr.util.SimplePolymerBlockWithEntity;
import cc.unilock.polylootr.util.SimplePolymerItem;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.block.PolymerHeadBlock;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
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

@Mixin(Lootr.class)
public class LootrMixin {
	@Inject(method = "onInitialize", at = @At("TAIL"), remap = false)
	private void onInitialize(CallbackInfo ci) {
		PolymerBlockUtils.registerOverlay(ModBlocks.BARREL, new SimplePolymerBlockWithEntity(Blocks.BARREL, BlockEntityTypes.BARREL));
		PolymerBlockUtils.registerOverlay(ModBlocks.CHEST, new SimplePolymerBlockWithEntity(Blocks.CHEST, BlockEntityTypes.CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.COPPER_CHEST, new SimplePolymerBlockWithEntity(Blocks.COPPER_CHEST.weathering().unaffected(), BlockEntityTypes.CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.EXPOSED_COPPER_CHEST, new SimplePolymerBlockWithEntity(Blocks.COPPER_CHEST.weathering().exposed(), BlockEntityTypes.CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.WEATHERED_COPPER_CHEST, new SimplePolymerBlockWithEntity(Blocks.COPPER_CHEST.weathering().weathered(), BlockEntityTypes.CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.OXIDIZED_COPPER_CHEST, new SimplePolymerBlockWithEntity(Blocks.COPPER_CHEST.weathering().oxidized(), BlockEntityTypes.CHEST));
		PolymerBlockUtils.registerOverlay(ModBlocks.DECORATED_POT, new SimplePolymerBlockWithEntity(Blocks.DECORATED_POT, BlockEntityTypes.DECORATED_POT));
		PolymerBlockUtils.registerOverlay(ModBlocks.SHULKER_BOX, new SimplePolymerBlockWithEntity(Blocks.SHULKER_BOX, BlockEntityTypes.SHULKER_BOX));
		PolymerBlockUtils.registerOverlay(ModBlocks.SUSPICIOUS_GRAVEL, new SimplePolymerBlockWithEntity(Blocks.SUSPICIOUS_GRAVEL, BlockEntityTypes.BRUSHABLE_BLOCK));
		PolymerBlockUtils.registerOverlay(ModBlocks.SUSPICIOUS_SAND, new SimplePolymerBlockWithEntity(Blocks.SUSPICIOUS_SAND, BlockEntityTypes.BRUSHABLE_BLOCK));
		PolymerBlockUtils.registerOverlay(ModBlocks.TRAPPED_CHEST, new SimplePolymerBlockWithEntity(Blocks.TRAPPED_CHEST, BlockEntityTypes.TRAPPED_CHEST));
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

		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.BARREL, (obj, ctx) -> BlockEntityTypes.BARREL);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.BRUSHABLE_BLOCK, (obj, ctx) -> BlockEntityTypes.BRUSHABLE_BLOCK);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.CHEST, (obj, ctx) -> BlockEntityTypes.CHEST);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.DECORATED_POT, (obj, ctx) -> BlockEntityTypes.DECORATED_POT);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.SHULKER_BOX, (obj, ctx) -> BlockEntityTypes.SHULKER_BOX);
		PolymerBlockUtils.registerBlockEntity(ModBlockEntities.TRAPPED_CHEST, (obj, ctx) -> BlockEntityTypes.TRAPPED_CHEST);

		PolymerItemUtils.registerOverlay(ModItems.BARREL, new SimplePolymerItem(Items.BARREL));
		PolymerItemUtils.registerOverlay(ModItems.CHEST, new SimplePolymerItem(Items.CHEST));
		PolymerItemUtils.registerOverlay(ModItems.COPPER_CHEST, new SimplePolymerItem(Items.COPPER_CHEST.weathering().unaffected()));
		PolymerItemUtils.registerOverlay(ModItems.EXPOSED_COPPER_CHEST, new SimplePolymerItem(Items.COPPER_CHEST.weathering().exposed()));
		PolymerItemUtils.registerOverlay(ModItems.WEATHERED_COPPER_CHEST, new SimplePolymerItem(Items.COPPER_CHEST.weathering().weathered()));
		PolymerItemUtils.registerOverlay(ModItems.OXIDIZED_COPPER_CHEST, new SimplePolymerItem(Items.COPPER_CHEST.weathering().oxidized()));
		PolymerItemUtils.registerOverlay(ModItems.DECORATED_POT, new SimplePolymerItem(Items.DECORATED_POT));
		PolymerItemUtils.registerOverlay(ModItems.SHULKER_BOX, new SimplePolymerItem(Items.SHULKER_BOX));
		PolymerItemUtils.registerOverlay(ModItems.SUSPICIOUS_GRAVEL, new SimplePolymerItem(Items.SUSPICIOUS_GRAVEL));
		PolymerItemUtils.registerOverlay(ModItems.SUSPICIOUS_SAND, new SimplePolymerItem(Items.SUSPICIOUS_SAND));
		PolymerItemUtils.registerOverlay(ModItems.TRAPPED_CHEST, new SimplePolymerItem(Items.TRAPPED_CHEST));
		PolymerItemUtils.registerOverlay(ModItems.TROPHY, new SimplePolymerItem(Items.PLAYER_HEAD));

		PolymerEntityUtils.registerOverlay(ModEntities.ITEM_FRAME, obj -> ctx -> EntityTypes.ITEM_FRAME);
		PolymerEntityUtils.registerOverlay(ModEntities.MINECART_WITH_CHEST, obj -> ctx -> EntityTypes.CHEST_MINECART);
	}
}
