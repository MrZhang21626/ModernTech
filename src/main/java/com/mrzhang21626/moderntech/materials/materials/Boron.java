package com.mrzhang21626.moderntech.materials.materials;

import com.mrzhang21626.moderntech.materials.Material;

public class Boron extends Material {
    public Boron() {
        super(Properties.of("boron").formula("B").color(0x5c5c5c).strength(6.5f).durability(1024).hasAll());
    }
}
