package cc.unilock.polylootr.mixin;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.zestyblaze.lootr.block.LootrShulkerBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootrShulkerBlock.class)
public class LootrShulkerBlockMixin implements PolymerBlock {
	@Override
	public Block getPolymerBlock(BlockState state) {
		return Blocks.SHULKER_BOX;
	}

	@Override
	public BlockState getPolymerBlockState(BlockState state) {
		return Blocks.SHULKER_BOX.withPropertiesOf(state);
	}
}
