package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;

public class Beryllium extends Material {
    public Beryllium() {
        super(Properties.of("beryllium").formula("Be").color(0xcad5b5).strength(5.0f).durability(256).hasAll());
    }
}
