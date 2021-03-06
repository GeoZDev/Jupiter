package cn.nukkit.network.protocol;

public class AddBehaviorTreePacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.ADD_BEHAVIOR_TREE_PACKET;

    public String unknown;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putString(unknown);
    }
}
