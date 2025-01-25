package cc.unilock.polylootr.mixin.entity;

import eu.pb4.polymer.core.api.entity.PolymerEntity;
import net.minecraft.world.entity.EntityType;
import noobanidus.mods.lootr.common.entity.LootrChestMinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import xyz.nucleoid.packettweaker.PacketContext;

@Mixin(LootrChestMinecartEntity.class)
public class LootrChestMinecartEntityMixin implements PolymerEntity {
	@Override
	public EntityType<?> getPolymerEntityType(PacketContext packetContext) {
		return EntityType.CHEST_MINECART;
	}
}
