const fs = require("fs");
const modName = "xtonesreworkedextended"
const pathToAssetsModName = `src/main/resources/assets/${modName}/`
const pathToDataModName = `src/main/resources/data/${modName}/`
const color = "pink"
var dummyArray = []

for (var i = 0; i < 16; i++) {
    fs.writeFileSync(
        `${pathToAssetsModName}/blockstates/lave_block_${color}_${i}.json`,
        JSON.stringify({
            "variants": {
                "": {
                    "model": `${modName}:block/lave_block_${color}_${i}`
                }
            }
        }, null, 4)
    )

    fs.writeFileSync(
        `${pathToAssetsModName}/models/block/lave_block_${color}_${i}.json`,
        JSON.stringify({
            "parent": "block/cube_all",
            "textures": {
                "all": `${modName}:block/lave_${color}/${i}`
            }
        }, null, 4)
    )

    fs.writeFileSync(
        `${pathToAssetsModName}/models/item/lave_block_${color}_${i}.json`,
        JSON.stringify({
            "parent": `${modName}:block/lave_block_${color}_${i}`
        }, null, 4)
    )

    fs.writeFileSync(
        `${pathToDataModName}/loot_tables/blocks/lave_block_${color}_${i}.json`,
        JSON.stringify({
            "type": "minecraft:block",
            "pools": [
                {
                    "rolls": 1,
                    "entries": [
                        {
                            "type": "minecraft:item",
                            "name": `${modName}:lave_block_${color}_${i}`
                        }
                    ]
                }
            ]
        }, null, 4)
    )

    if (i === 0) {
        fs.writeFileSync(
            `${pathToDataModName}/recipes/lave_block_${color}_${i}.json`,
            JSON.stringify({
                "type": "minecraft:crafting_shaped",
                "key": {
                    "B": {
                        "tag": "xtonesreworked:lave"
                    },
                    "C": {
                        "item": `minecraft:${color}_dye`
                    }
                },
                "pattern": ["BBB", "BCB", "BBB"],
                "result": {
                    "item": `${modName}:lave_block_${color}_${i}`,
                    "count": 8
                }
            }, null, 4)
        )
    }

    fs.writeFileSync(
        `${pathToDataModName}/recipes/lave_block_${color}_${i}_from_stonecutting.json`,
        JSON.stringify({
            "type": "minecraft:stonecutting",
            "count": 1,
            "ingredient": {
                "tag": `${modName}:lave_${color}`
            },
            "result": `${modName}:lave_block_${color}_${i}`
        }, null, 4)
    )

    dummyArray.push(`${modName}:lave_block_${color}_${i}`)
}

fs.writeFileSync(
    `${pathToDataModName}/tags/items/lave_${color}.json`,
    JSON.stringify({
        "replace": false,
        values: dummyArray
    }, null, 4)
)