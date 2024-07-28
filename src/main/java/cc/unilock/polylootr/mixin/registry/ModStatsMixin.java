package cc.unilock.polylootr.mixin.registry;

import eu.pb4.polymer.core.api.other.PolymerStat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import noobanidus.mods.lootr.init.ModStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModStats.class, remap = false)
public class ModStatsMixin {
	@Shadow
	public static ResourceLocation LOOTED_LOCATION;

	@Shadow
	public static Stat<ResourceLocation> LOOTED_STAT;

	@Inject(method = "registerStats", at = @At("HEAD"), cancellable = true)
	private static void registerStats(CallbackInfo ci) {
		LOOTED_LOCATION = PolymerStat.registerStat(LOOTED_LOCATION, StatFormatter.DEFAULT);
		LOOTED_STAT = Stats.CUSTOM.get(LOOTED_LOCATION);
		ci.cancel();
	}
}
