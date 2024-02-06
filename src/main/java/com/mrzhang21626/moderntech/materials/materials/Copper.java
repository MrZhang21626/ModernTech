package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.materials.MaterialTier;

public class Copper extends Material {
    public Copper() {
        super(new Properties("copper",
                new MaterialTier.TierProperties(0, 154, 4f, 2f, 18, "ingot")).
                formula("Cu").color(0xc15a36).strength(3.0f).hasAllMaterials().hasTools());
    }
}
