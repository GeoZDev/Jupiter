package cn.nukkit.inventory.transaction.action;

import cn.nukkit.Player;
import cn.nukkit.item.Item;

public class DropItemAction extends InventoryAction {

    public DropItemAction(Item source, Item target) {
        super(source, target);
    }

    /**
     * Verifies that the source item of a drop-item action must be air. This is not strictly necessary, just a sanity
     * check.
     */
    public boolean isValid(Player source) {
        return this.sourceItem.isNull();
    }

    /**
     * Drops the target item in front of the player.
     */
    public boolean execute(Player source) {
        return source.dropItem(this.targetItem);
    }

    public void onExecuteSuccess(Player source) {

    }

    public void onExecuteFail(Player source) {

    }
}