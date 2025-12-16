package cc.unilock.polylootr.util;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import xyz.nucleoid.packettweaker.PacketContext;

public class SimplePolymerBlockWithEntity implements PolymerBlock {
	private final Block block;
	private final BlockEntityType<?> type;

	public SimplePolymerBlockWithEntity(Block block, BlockEntityType<?> type) {
		this.block = block;
		this.type = type;
	}

	@Override
	public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
		return this.block.withPropertiesOf(state);
	}

	@Override
	public void onPolymerBlockSend(BlockState blockState, BlockPos.MutableBlockPos pos, PacketContext.NotNullWithPlayer contexts) {
		contexts.getClientConnection().send(PolymerBlockUtils.createBlockEntityPacket(pos, this.type, null));
	}
}
