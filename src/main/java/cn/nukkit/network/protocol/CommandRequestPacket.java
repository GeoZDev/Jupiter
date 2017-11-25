package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.CommandOriginData;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class CommandRequestPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.COMMAND_REQUEST_PACKET;

    public static final int TYPE_PLAYER = 0;
    public static final int TYPE_COMMAND_BLOCK = 1;
    public static final int TYPE_MINECART_COMMAND_BLOCK = 2;
    public static final int TYPE_DEV_CONSOLE = 3;
    public static final int TYPE_AUTOMATION_PLAYER = 4;
    public static final int TYPE_CLIENT_AUTOMATION = 5;
    public static final int TYPE_DEDICATED_SERVER = 6;
    public static final int TYPE_ENTITY = 7;
    public static final int TYPE_VIRTUAL = 8;
    public static final int TYPE_GAME_ARGUMENT = 9;
    public static final int TYPE_INTERNAL = 10;

    public String command;
    
    public CommandOriginData originData;
    
    public boolean isInternal;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        this.command = this.getString();
        this.originData = this.getCommandOriginData();
        this.isInternal = this.getBoolean();
    }

    @Override
    public void encode() {
    	this.putString(this.command);
    	this.putCommandOriginData(this.originData);
    	this.putBoolean(this.isInternal);
    }

}
