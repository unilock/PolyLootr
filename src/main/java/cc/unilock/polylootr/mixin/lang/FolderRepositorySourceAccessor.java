package cc.unilock.polylootr.mixin.lang;

import net.minecraft.server.packs.repository.FolderRepositorySource;
import net.minecraft.server.packs.repository.PackSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FolderRepositorySource.class)
public interface FolderRepositorySourceAccessor {
	@Accessor
	PackSource getPackSource();
}
