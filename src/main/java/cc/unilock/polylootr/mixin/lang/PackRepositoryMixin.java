package cc.unilock.polylootr.mixin.lang;

import cc.unilock.polylootr.lang.LangPackProvider;
import net.minecraft.server.packs.repository.FolderRepositorySource;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.LinkedHashSet;
import java.util.Set;

@Mixin(PackRepository.class)
public class PackRepositoryMixin {
	@Shadow
	@Final
	@Mutable
	private Set<RepositorySource> sources;

	@Inject(method = "<init>", at = @At("RETURN"))
	public void construct(RepositorySource[] resourcePackProviders, CallbackInfo info) {
		// Use a LinkedHashSet to preserve ordering
		sources = new LinkedHashSet<>(sources);

		// Search resource pack providers to find any server-related pack provider.
		boolean shouldAddServerProvider = false;

		for (RepositorySource provider : this.sources) {
			if (provider instanceof FolderRepositorySource
				&& (((FolderRepositorySourceAccessor) provider).getPackSource() == PackSource.WORLD
				|| ((FolderRepositorySourceAccessor) provider).getPackSource() == PackSource.SERVER)) {
				shouldAddServerProvider = true;
				break;
			}
		}

		// On server, add the mod resource pack provider.
		if (shouldAddServerProvider) {
			sources.add(LangPackProvider.INSTANCE);
		}
	}
}
