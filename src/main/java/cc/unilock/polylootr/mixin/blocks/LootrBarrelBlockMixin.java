package cc.unilock.polylootr.mixin.blocks;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import noobanidus.mods.lootr.common.block.LootrBarrelBlock;
import org.spongepowered.asm.mixin.Mixin;
import xyz.nucleoid.packettweaker.PacketContext;

@Mixin(LootrBarrelBlock.class)
public class LootrBarrelBlockMixin implements PolymerBlock {
	@Override
	public BlockState getPolymerBlockState(BlockState blockState, PacketContext packetContext) {
		return Blocks.BARREL.withPropertiesOf(blockState);
	}

	@Override
	public void onPolymerBlockSend(BlockState blockState, BlockPos.MutableBlockPos pos, PacketContext.NotNullWithPlayer contexts) {
		contexts.getClientConnection().send(PolymerBlockUtils.createBlockEntityPacket(pos, BlockEntityType.BARREL, null));
	}
}
