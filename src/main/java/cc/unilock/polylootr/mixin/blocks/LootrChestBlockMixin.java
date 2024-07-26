package cc.unilock.polylootr.mixin.blocks;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import noobanidus.mods.lootr.block.LootrChestBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootrChestBlock.class)
public class LootrChestBlockMixin implements PolymerBlock {
	@Override
	public BlockState getPolymerBlockState(BlockState state) {
		return Blocks.CHEST.withPropertiesOf(state);
	}
}
