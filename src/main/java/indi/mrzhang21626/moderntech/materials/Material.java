package indi.mrzhang21626.moderntech.materials;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public enum Material {
    BERYLLIUM("beryllium", 5.5f, true, true, true, true, true, true, true, true),
    BORON("boron", 9.5f, true, true, true, true, false, true, true, true);

    private RegistryObject<Item> dust, tinyDust, ingot, nugget, plate, rod, screw;
    private final boolean hasDust, hasTinyDust, hasIngot, hasNugget, hasPlate, hasRod, hasScrew, hasBlock;
    private RegistryObject<Block> block;
    private final Map<Material, RegistryObject<Block>> blockOfPlate = new HashMap<>();
    private RegistryObject<BlockItem> blockItem;
    private final Map<Material, RegistryObject<BlockItem>> itemBlockOfPlate = new HashMap<>();

    private final float hardness;
    private final String name;

    Material(String name, float hardness, boolean hasDust, boolean hasTinyDust, boolean hasIngot, boolean hasNugget, boolean hasPlate, boolean hasRod, boolean hasScrew, boolean hasBlock) {
        this.name = name;
        this.hardness = hardness;
        this.hasDust = hasDust;
        this.hasTinyDust = hasTinyDust;
        this.hasIngot = hasIngot;
        this.hasNugget = hasNugget;
        this.hasPlate = hasPlate;
        this.hasRod = hasRod;
        this.hasScrew = hasScrew;
        this.hasBlock = hasBlock;
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

    public Map<Material, RegistryObject<Block>> getBlockOfPlate() {
        return blockOfPlate;
    }

    public void addBlockOfPlate(Material material, RegistryObject<Block> block) {
        blockOfPlate.put(material, block);
    }

    public Map<Material, RegistryObject<BlockItem>> getItemBlockOfPlate() {
        return itemBlockOfPlate;
    }

    public void addItemBlockOfPlate(Material material, RegistryObject<BlockItem> blockItem) {
        itemBlockOfPlate.put(material, blockItem);
    }

    public boolean isHasDust() {
        return hasDust;
    }

    public boolean isHasTinyDust() {
        return hasTinyDust;
    }

    public boolean isHasIngot() {
        return hasIngot;
    }

    public boolean isHasNugget() {
        return hasNugget;
    }

    public boolean isHasPlate() {
        return hasPlate;
    }

    public boolean isHasRod() {
        return hasRod;
    }

    public boolean isHasScrew() {
        return hasScrew;
    }

    public RegistryObject<Item> getScrew() {
        return screw;
    }

    public void setScrew(RegistryObject<Item> screw) {
        this.screw = screw;
    }

    public boolean isHasBlock() {
        return hasBlock;
    }
}
