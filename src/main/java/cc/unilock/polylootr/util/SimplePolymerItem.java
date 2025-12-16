package cc.unilock.polylootr.util;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

public class SimplePolymerItem implements PolymerItem {
	private final Item item;

	public SimplePolymerItem(Item item) {
		this.item = item;
	}

	@Override
	public Item getPolymerItem(ItemStack itemStack, PacketContext context) {
		return this.item;
	}

	@Override
	public @Nullable ResourceLocation getPolymerItemModel(ItemStack stack, PacketContext context) {
		return null;
	}
}
