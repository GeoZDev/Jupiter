package cn.nukkit.block;

import java.util.concurrent.ThreadLocalRandom;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemPrismarineCrystals;
import cn.nukkit.utils.BlockColor;


public class BlockSeaLantern extends BlockTransparent {
    public BlockSeaLantern() {
        this(0);
    }

    public BlockSeaLantern(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Sea Lantern";
    }

    @Override
    public int getId() {
        return SEA_LANTERN;
    }

    @Override
    public double getResistance() {
        return 1.5;
    }

    @Override
    public double getHardness() {
        return 0.3;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isSilkTouch()){
            return new Item[]{
                this.toItem()
            };
        } else {
            return new Item[]{
                    new ItemPrismarineCrystals(0, ThreadLocalRandom.current().nextInt(2, 4))
            };
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.AIR_BLOCK_COLOR;
    }
}
