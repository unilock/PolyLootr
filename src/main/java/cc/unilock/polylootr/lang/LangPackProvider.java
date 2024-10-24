package cc.unilock.polylootr.lang;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.BuiltInMetadata;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public record LangPackProvider(ModContainer mod) implements RepositorySource, Pack.ResourcesSupplier, PackResources {
	public static final RepositorySource INSTANCE = new LangPackProvider(FabricLoader.getInstance().getModContainer("lootr").orElseThrow());

	@Override
	public void loadPacks(Consumer<Pack> onLoad) {
		onLoad.accept(
			Pack.readMetaAndCreate(
				location(),
				this,
				PackType.SERVER_DATA,
				new PackSelectionConfig(true, Pack.Position.BOTTOM, false)
			)
		);
	}

	@Override
	@NotNull
	public PackResources openPrimary(PackLocationInfo location) {
		return this;
	}

	@Override
	@NotNull
	public PackResources openFull(PackLocationInfo location, Pack.Metadata metadata) {
		return openPrimary(location);
	}

	@Override
	@Nullable
	public IoSupplier<InputStream> getRootResource(String... elements) {
		var path = mod.findPath(String.join("/", elements));

		return path.map(IoSupplier::create).orElse(null);
	}

	@Override
	@Nullable
	public IoSupplier<InputStream> getResource(PackType packType, ResourceLocation location) {
		var path = mod.findPath("assets/" + location.getNamespace() + "/" + location.getPath());

		return path.map(IoSupplier::create).orElse(null);
	}

	@Override
	public void listResources(PackType packType, String namespace, String path, ResourceOutput resourceOutput) {
		var optional = mod.findPath("assets/" + namespace + "/" + path);

		if (optional.isEmpty()) {
			return;
		}

		try {
			String separator = optional.get().getFileSystem().getSeparator();
			Files.walkFileTree(optional.get(), new SimpleFileVisitor<>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					String filename = optional.get().relativize(file).toString().replace(separator, "/");
					ResourceLocation location = ResourceLocation.tryBuild(namespace, path + "/" + filename);

					if (location != null) {
						resourceOutput.accept(location, IoSupplier.create(file));
					}

					return super.visitFile(file, attrs);
				}
			});
		} catch (IOException ignored) {
			// NO-OP
		}
	}

	@Override
	@NotNull
	public Set<String> getNamespaces(PackType type) {
		return Set.of("lootr");
	}

	@Override
	@Nullable
	public <T> T getMetadataSection(MetadataSectionSerializer<T> deserializer) {
		return BuiltInMetadata.of(PackMetadataSection.TYPE, new PackMetadataSection(Component.literal("PolyLootr"), SharedConstants.getCurrentVersion().getPackVersion(PackType.SERVER_DATA), Optional.empty())).get(deserializer);
	}

	@Override
	@NotNull
	public PackLocationInfo location() {
		return new PackLocationInfo(
			"$polylootr",
			Component.literal("PolyLootr"),
			PackSource.BUILT_IN,
			Optional.empty()
		);
	}

	@Override
	public void close() {

	}
}
