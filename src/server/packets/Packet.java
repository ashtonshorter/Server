package server.packets;

import org.jboss.netty.buffer.ChannelBuffer;

import server.model.Account;

public abstract class Packet
{
	private static Packet[] packets = new Packet[0];
	public abstract void decode(Account account, ChannelBuffer buffer);
	
	/**
	 * Adds the decoder and prints any errors
	 * @param packet Used to get the classes and values
	 */
	public static void addDecoder(Packet packet) {
		if(packet.getClass().getAnnotation(PacketOpcodeHeader.class) == null) {
			System.out.print("ERROR: "); 
			System.err.print("Packet OPCode not found for: " + packet + "\n");
		}
		
		int packetOpcodes[] = packet.getClass().getAnnotation(PacketOpcodeHeader.class).value();
		
		for(int opcode : packetOpcodes) {
			packets[opcode] = packet;
		}
	}
	
	/**
	 * Returns packets
	 * @return
	 */
	public static Packet[] getPackets() {
		return packets;
	}
	
	/**
	 * Loads the decoders
	 * @throws Exception
	 */
	public static void loadDecoders() throws Exception {
		//Packet.addDecoder((Packet)new PacketClass());
	}
}
