package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;

public class Iron extends Material {
    public Iron() {
        super(Properties.of("iron").formula("Fe").color(0xd8d8d8).strength(5.0f).durability(256).hasAll());
    }
}
