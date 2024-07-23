package cc.unilock.polylootr.mixin.entity;

import eu.pb4.polymer.core.api.entity.PolymerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.zestyblaze.lootr.entity.LootrChestMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LootrChestMinecartEntity.class)
public class LootrChestMinecartEntityMixin implements PolymerEntity {
	@Override
	public EntityType<?> getPolymerEntityType(ServerPlayer player) {
		return EntityType.CHEST_MINECART;
	}
}
