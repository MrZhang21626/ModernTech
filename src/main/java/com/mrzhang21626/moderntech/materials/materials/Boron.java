package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.materials.MaterialTier;

public class Boron extends Material {
    public Boron() {
        super(new Properties("boron",
                new MaterialTier.TierProperties(3, 1024, 9f, 2f, 16, "ingot"))
                .formula("B").color(0x5c5c5c).strength(6.5f).hasAllMaterials().hasTools());
    }
}
