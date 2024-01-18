const fs = require("fs");
const modName = "xtonereworkedextended"
const pathToAssetsModName = `src/main/resources/assets/${modName}/`
const pathToDataModName = `src/main/resources/data/${modName}/`
const blockName = "lave_block_purple"
const fileName = "lave_purple"

for (var i = 0; i < 16; i++) {
    fs.writeFileSync(
        `${pathToAssetsModName}/blockstates/${blockName}_${i}.json`,
        JSON.stringify({
            "variants": {
                "": {
                    "model": `${modName}:block/${blockName}_${i}`
                }
            }
        }, null, 4)
    )

    fs.writeFileSync(
        `${pathToAssetsModName}/models/block/${blockName}_${i}.json`,
        JSON.stringify({
            "parent": "block/cube_all",
            "textures": {
                "all": `${modName}:block/${fileName}/${i}`
            }
        }, null, 4)
    )

    fs.writeFileSync(
        `${pathToAssetsModName}/models/item/${blockName}_${i}.json`,
        JSON.stringify({
            "parent": `${modName}:block/${blockName}_${i}`
        }, null, 4)
    )

    fs.writeFileSync(
        `${pathToDataModName}/loot_tables/blocks/${blockName}_${i}.json`,
        JSON.stringify({
            "type": "minecraft:block",
            "pools": [
                {
                    "rolls": 1,
                    "entries": [
                        {
                            "type": "minecraft:item",
                            "name": `${modName}:${blockName}_${i}`
                        }
                    ]
                }
            ]
        }, null, 4)
    )

    if (i === 0) {
        fs.writeFileSync(
            `${pathToDataModName}/recipes/${blockName}_${i}.json`,
            JSON.stringify({
                "type": "minecraft:crafting_shaped",
                "key": {
                    "B": {
                        "tag": "xtonesreworked:lave"
                    },
                    "C": {
                        "item": "minecraft:purple_dye"
                    }
                },
                "pattern": ["BBB", "BCB", "BBB"],
                "result": {
                    "item": `${modName}:${blockName}_${i}`,
                    "count": 8
                }
            }, null, 4)
        )
    }

    fs.writeFileSync(
        `${pathToDataModName}/recipes/${blockName}_${i}_from_stonecutting.json`,
        JSON.stringify({
            "type": "minecraft:stinecutting",
            "ingredient": {
                "tag": `${modName}:${fileName}`
            },
            "result": `${modName}:${blockName}_${i}`
        }, null, 4)
    )
}