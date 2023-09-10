package com.mrzhang21626.moderntech.registries;

import com.mrzhang21626.moderntech.materials.Material;
import com.mrzhang21626.moderntech.materials.materials.*;

public class RegistryMaterials {
    public static void init() {
        Material.addMaterial(new Beryllium());
        Material.addMaterial(new Boron());
        Material.addMaterial(new Iron());
        Material.addMaterial(new Copper());
        Material.addMaterial(new Gold());
    }
}
