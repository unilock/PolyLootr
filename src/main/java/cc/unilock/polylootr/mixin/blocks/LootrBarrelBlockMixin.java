package cc.unilock.polylootr.mixin.blocks;

import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import noobanidus.mods.lootr.block.LootrBarrelBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootrBarrelBlock.class)
public class LootrBarrelBlockMixin implements PolymerBlock {
	@Override
	public BlockState getPolymerBlockState(BlockState state) {
		return Blocks.BARREL.withPropertiesOf(state);
	}

	@Override
	public void onPolymerBlockSend(BlockState blockState, BlockPos.MutableBlockPos pos, ServerPlayer player) {
		player.connection.send(PolymerBlockUtils.createBlockEntityPacket(pos, BlockEntityType.BARREL, null));
	}
}
