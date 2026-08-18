package cc.unilock.polylootr.util;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.networking.v1.context.PacketContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

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
	public Identifier getPolymerItemModel(ItemStack stack, PacketContext context, HolderLookup.Provider lookup) {
		return null;
	}
}
