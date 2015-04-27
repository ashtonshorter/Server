package server.controller;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

public class LoginServerDecoder extends FrameDecoder
{
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
		ChannelBufferInputStream inputStream = new ChannelBufferInputStream(buffer);
		
		// TODO: login
		String username = inputStream.readUTF();	//reads username
		String password = inputStream.readUTF();	//reads password
		
		System.out.println("Username = " + username);
		System.out.println("Password = " + password);
		// TODO: SQL Login Check
		// if true - Create a new account
		// Remove the LoginServerDecoder, setup GameServerDecoder
		// Return the account
		
		return null;
	}
}
