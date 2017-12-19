package cn.nukkit.item.enchantment;

import java.util.Random;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityHumanType;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityDamageEvent.DamageCause;
import cn.nukkit.item.Item;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class EnchantmentThorns extends Enchantment {

    protected EnchantmentThorns() {
        super(ID_THORNS, "thorns", 2, EnchantmentType.ARMOR_TORSO);
    }

    @Override
    public int getMinEnchantAbility(int level) {
        return 10 + (level - 1) * 20;
    }

    @Override
    public int getMaxEnchantAbility(int level) {
        return this.getMinEnchantAbility(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(Entity attacker, Entity entity) {
        if (!(entity instanceof EntityHumanType)) {
            return;
        }

        EntityHumanType human = (EntityHumanType) entity;

        int thornsDamage = 0;
        Random rnd = new Random();

        for (Item armor : human.getInventory().getArmorContents()) {
            Enchantment thorns = armor.getEnchantment(Enchantment.ID_THORNS);

            if (thorns != null && thorns.getLevel() > 0) {
                int chance = thorns.getLevel() * 15;

                if (chance > 90) {
                    chance = 90;
                }

                if (rnd.nextInt(100) + 1 <= chance) {
                    thornsDamage += rnd.nextInt(4) + 1;
                }
            }
        }

        if (thornsDamage > 0) {
            attacker.attack(new EntityDamageEvent(attacker, DamageCause.MAGIC, rnd.nextInt(4) + 1));
        }
    }

    public int getRepairCost(boolean isBook) {
        if (isBook) {
            return 4 * this.getLevel();
        } else {
            return 8 * this.getLevel();
        }
    }

}