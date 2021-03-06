package cn.nukkit.entity.mob;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemAxeIron;
import cn.nukkit.item.ItemEmerald;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.AddEntityPacket;

public class EntityVindicator extends EntityMob {
    public static final int NETWORK_ID = 57;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntityVindicator(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
    @Override
    protected void initEntity() {
    	this.setMaxHealth(24);
        super.initEntity();
    }
    
    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getLength() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 1.95f;
    }

    @Override
    public String getName() {
        return "Vindicator";
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
        if (random.nextRange(1, 100) <= 15) {
            return new Item[]{new ItemEmerald(0, random.nextRange(0, 1)), new ItemAxeIron()};
        } else {
            return new Item[]{new ItemEmerald(0, random.nextRange(0, 1))};
        }
    }
}
