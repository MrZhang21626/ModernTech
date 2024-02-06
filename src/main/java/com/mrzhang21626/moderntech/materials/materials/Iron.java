package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.materials.MaterialTier;

public class Iron extends Material {
    public Iron() {
        super(new Properties("iron", new MaterialTier.TierProperties(2, 250, 6, 2, 14, "ingots"))
                .formula("Fe").color(0xd8d8d8).strength(5.0f).hasAllMaterials().hasTools());
    }
}
