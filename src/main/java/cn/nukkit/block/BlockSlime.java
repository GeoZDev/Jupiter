package cn.nukkit.block;

import cn.nukkit.utils.BlockColor;

/**
 * Created by Pub4Game on 21.02.2016.
 */
public class BlockSlime extends BlockSolid {

    public BlockSlime() {
        this(0);
    }

    public BlockSlime(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Slime Block";
    }

    @Override
    public int getId() {
        return SLIME_BLOCK;
    }

    @Override
    public double getResistance() {
        return 0;
    }
    
    @Override
    public BlockColor getColor(){
    	return BlockColor.GREEN_BLOCK_COLOR;
    }
}
