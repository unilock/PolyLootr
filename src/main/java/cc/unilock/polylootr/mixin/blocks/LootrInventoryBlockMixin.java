package cc.unilock.polylootr.mixin.blocks;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import noobanidus.mods.lootr.block.LootrInventoryBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootrInventoryBlock.class)
public class LootrInventoryBlockMixin implements PolymerBlock {
	@Override
	public BlockState getPolymerBlockState(BlockState state) {
		return Blocks.CHEST.withPropertiesOf(state);
	}
}
