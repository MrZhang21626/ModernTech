package indi.mrzhang21626.moderntech.materials;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public enum Material {
    BERYLLIUM("beryllium", 5.5f);

    private RegistryObject<Item> dust, tinyDust, ingot, nugget, plate, rod;
    private RegistryObject<Block> block;
    private RegistryObject<BlockItem> blockItem;

    private final float hardness;
    private final String name;

    Material(String name, float hardness) {
        this.name = name;
        this.hardness = hardness;
    }


    public String getName() {
        return name;
    }

    public RegistryObject<Item> getDust() {
        return dust;
    }

    public void setDust(RegistryObject<Item> dust) {
        this.dust = dust;
    }

    public RegistryObject<Item> getTinyDust() {
        return tinyDust;
    }

    public void setTinyDust(RegistryObject<Item> tiny_dust) {
        this.tinyDust = tiny_dust;
    }

    public RegistryObject<Item> getIngot() {
        return ingot;
    }

    public void setIngot(RegistryObject<Item> ingot) {
        this.ingot = ingot;
    }

    public RegistryObject<Item> getNugget() {
        return nugget;
    }

    public void setNugget(RegistryObject<Item> nugget) {
        this.nugget = nugget;
    }

    public RegistryObject<Item> getPlate() {
        return plate;
    }

    public void setPlate(RegistryObject<Item> plate) {
        this.plate = plate;
    }

    public RegistryObject<Item> getRod() {
        return rod;
    }

    public void setRod(RegistryObject<Item> rod) {
        this.rod = rod;
    }


    public float getHardness() {
        return hardness;
    }

    public RegistryObject<Block> getBlock() {
        return block;
    }

    public void setBlock(RegistryObject<Block> block) {
        this.block = block;
    }

    public RegistryObject<BlockItem> getBlockItem() {
        return blockItem;
    }

    public void setBlockItem(RegistryObject<BlockItem> blockItem) {
        this.blockItem = blockItem;
    }
}
