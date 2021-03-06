package cn.nukkit.entity.mob;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemPrismarineCrystals;
import cn.nukkit.item.ItemPrismarineShard;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.AddEntityPacket;

public class EntityGuardian extends EntityMob {
    public static final int NETWORK_ID = 49;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntityGuardian(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public void initEntity(){
    	this.setMaxHealth(30);
    	super.initEntity();
    }

    @Override
    public String getName() {
        return "Guardian";
    }

    @Override
    public void spawnTo(Player player) {
        AddEntityPacket pk = new AddEntityPacket();
        pk.type = this.getNetworkId();
        pk.entityUniqueId = this.getId();
        pk.entityRuntimeId = this.getId();
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.speedX = (float) this.motionX;
        pk.speedY = (float) this.motionY;
        pk.speedZ = (float) this.motionZ;
        pk.metadata = this.dataProperties;
        player.dataPacket(pk);

        super.spawnTo(player);
    }

    @Override
    public Item[] getDrops() {
        Item drops[] = new Item[3];
        drops[0] = new ItemPrismarineCrystals(0, random.nextRange(0, 1));
        drops[1] = new ItemPrismarineShard(0, random.nextRange(0, 2));
        //TODO: 60%の確率で生魚、25%の確率で生鮭、2%の確率でクマノミ、13%の確率でフグ、また焼死時には焼き魚、焼き鮭をドロップ
        return drops;
    }
}
