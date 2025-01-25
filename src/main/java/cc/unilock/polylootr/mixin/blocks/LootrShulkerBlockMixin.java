package cc.unilock.polylootr.mixin.blocks;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import noobanidus.mods.lootr.common.block.LootrShulkerBlock;
import org.spongepowered.asm.mixin.Mixin;
import xyz.nucleoid.packettweaker.PacketContext;

@Mixin(LootrShulkerBlock.class)
public class LootrShulkerBlockMixin implements PolymerBlock {
	@Override
	public BlockState getPolymerBlockState(BlockState blockState, PacketContext packetContext) {
		return Blocks.SHULKER_BOX.withPropertiesOf(blockState);
	}

	@Override
	public void onPolymerBlockSend(BlockState blockState, BlockPos.MutableBlockPos pos, PacketContext.NotNullWithPlayer contexts) {
		contexts.getClientConnection().send(PolymerBlockUtils.createBlockEntityPacket(pos, BlockEntityType.SHULKER_BOX, null));
	}
}
