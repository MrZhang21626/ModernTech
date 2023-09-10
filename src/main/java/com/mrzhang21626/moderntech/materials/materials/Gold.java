package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;

public class Gold extends Material {
    public Gold() {
        super(Properties.of("gold").formula("Au").color(0xfdf55f).strength(3.0f).durability(32).hasAll());
    }
}
