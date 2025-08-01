### About

**In Minecraft, you can instamine stone — but not wood, glass, or deepslate. That’s weird, right?**

**InstantBreak** fixes that. It allows instant mining of many common blocks using the correct tools, enchantments, and effects.

The mod tweaks Minecraft’s break calculation to better match block hardness and logic. It also expands which tools are considered valid for certain blocks — for example, pickaxes can now break glass.

---

### InstantBreak Improvements

**Instant Breaking Conditions**

| Block Group                                    | Minimum Instant Break Requirement                    |
| ---------------------------------------------- | -------------------------------------------- |
| Glass, Stained Glass, Glass Pane               | Efficiency I on diamond pickaxe              |
| Wood, Planks, Crafting Table, etc.             | Efficiency V on netherite axe                |
| Stone, Cobblestone, Concrete, etc. (≤ 2.5 Hardness)     | Efficiency V on netherite pickaxe            |
| Stone Ores, Deepslate, End Stone, etc. (≤ 3.0 Hardness) | Efficiency V on netherite pickaxe + Haste I  |
| Cobbled Deepslate, Furnace, etc. (≤ 3.5 Hardness)       | Efficiency V on netherite pickaxe + Haste II |

**Adjusted Tool Compatibility**

| Block Type                   | New Correct Tool |
| ---------------------------- | ---------------- |
| Glass & Glass Variants       | Pickaxe          |
| Beacon                       | Pickaxe          |
| Skulls (e.g. Player, Wither) | Axe              |
| Glowstone                    | Pickaxe          |
| Redstone Lamp                | Pickaxe          |
| Sea Lantern                  | Pickaxe          |
| Froglight                    | Hoe              |
| Cactus                       | Hoe              |
| Candle                       | Pickaxe          |
| Lever                        | Pickaxe          |
| Sniffer Egg                  | Pickaxe          |

---

### Compatibility

| Minecraft Version | Loader             | Status       | Version  | Notes                    |
|-------------------|--------------------|--------------|----------|--------------------------|
| 1.21 – 1.21.8     | Fabric             | ✅ Supported | Latest   |       |
|                   |  other mod loaders | 🛠 In Progress    | –     | Support is currently in development |
| < 1.21            | Fabric / other mod loaders | ❌ Not Supported | –      | Support planned in future versions         |

---

### License
This project is licensed under the BSD 2-Clause License.

---

Developed by the MARS Team MC.
