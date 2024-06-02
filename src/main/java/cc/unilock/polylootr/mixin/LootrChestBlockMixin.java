package cc.unilock.polylootr.mixin;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.zestyblaze.lootr.block.LootrChestBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootrChestBlock.class)
public class LootrChestBlockMixin implements PolymerBlock {
	@Override
	public Block getPolymerBlock(BlockState state) {
		return Blocks.CHEST;
	}

	@Override
	public BlockState getPolymerBlockState(BlockState state) {
		return Blocks.CHEST.withPropertiesOf(state);
	}
}