package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;

public class Copper extends Material {
    public Copper() {
        super(Properties.of("copper").formula("Cu").color(0xc15a36).strength(3.0f).durability(154).hasAll());
    }
}
