package cn.nukkit.inventory.transaction.action;

import java.util.HashSet;
import java.util.Set;

import cn.nukkit.Player;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;

/**
 * @author CreeperFace
 */
public class SlotChangeAction extends InventoryAction {

    protected Inventory inventory;
    private int inventorySlot;

    public SlotChangeAction(Inventory inventory, int inventorySlot, Item sourceItem, Item targetItem) {
        super(sourceItem, targetItem);
        this.inventory = inventory;
        this.inventorySlot = inventorySlot;
    }

    /**
     * Returns the inventory involved in this action.
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Returns the inventorySlot in the inventory which this action modified.
     */
    public int getSlot() {
        return inventorySlot;
    }

    /**
     * Checks if the item in the inventory at the specified inventorySlot is the same as this action's source item.
     */
    public boolean isValid(Player source) {
        if((this.inventorySlot >= 0) && (this.inventory.getItem(this.inventorySlot).equalsExact(this.getSourceItem()))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the item into the target inventory.
     */
    public boolean execute(Player source) {
        return this.inventory.setItem(this.inventorySlot, this.targetItem, false);
    }

    /**
     * Sends inventorySlot changes to other viewers of the inventory. This will not send any change back to the source Player.
     */
    public void onExecuteSuccess(Player source) {
        Set<Player> viewers = new HashSet<>(this.inventory.getViewers());
        viewers.remove(source);

        this.inventory.sendSlot(this.inventorySlot, viewers);
    }

    /**
     * Sends the original inventorySlot contents to the source player to revert the action.
     */
    public void onExecuteFail(Player source) {
        this.inventory.sendSlot(this.inventorySlot, source);
    }
}
