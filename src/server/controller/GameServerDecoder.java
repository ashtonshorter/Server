package server.controller;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import server.model.Account;
import server.packets.Packet;

public class GameServerDecoder extends FrameDecoder
{
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
		ChannelBufferInputStream inputStream = new ChannelBufferInputStream(buffer);
		
		int packetOpCode = inputStream.readByte();	//read the data that goes with packet
		
		Account account = Account.getAccountByChannel(channel);
		if(account == null) {
			System.err.println("ERROR: [GameServerDecoder] - Tried to handle data for a null account.");
			return null;
		}
		
		if(Packet.getPackets()[packetOpCode] != null) {
			Packet.getPackets()[packetOpCode].decode(account, buffer);
		} else {
			System.out.println("[Unhandled Packet] - Error, packet with the ID of { "+packetOpCode+" } was recived, but not handled.");
			return null;
		}
		
		return null;
	}
}
