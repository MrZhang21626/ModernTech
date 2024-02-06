package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.materials.MaterialTier;

public class Gold extends Material {
    public Gold() {
        super(new Properties("gold",
                new MaterialTier.TierProperties(0, 32, 12, 0, 22, "ingots"))
                .formula("Au").color(0xfdf55f).strength(3.0f).hasAllMaterials().hasTools());
    }
}
