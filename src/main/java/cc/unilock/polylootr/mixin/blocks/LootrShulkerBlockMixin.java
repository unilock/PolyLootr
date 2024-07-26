package cc.unilock.polylootr.mixin.blocks;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import noobanidus.mods.lootr.block.LootrShulkerBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootrShulkerBlock.class)
public class LootrShulkerBlockMixin implements PolymerBlock {
	@Override
	public BlockState getPolymerBlockState(BlockState state) {
		return Blocks.SHULKER_BOX.withPropertiesOf(state);
	}
}
