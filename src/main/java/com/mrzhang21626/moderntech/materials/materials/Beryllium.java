package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.materials.MaterialTier;

public class Beryllium extends Material {
    public Beryllium() {
        super(new Properties("beryllium",
                new MaterialTier.TierProperties(2, 256, 14, 2, 14, "ingots"))
                .formula("Be").color(0xcad5b5).strength(5.0f).hasAllMaterials().hasTools());
    }
}
