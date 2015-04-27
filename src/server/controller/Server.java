package server.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class Server
{
	private static final String BIND_ADDRESS = "127.0.0.1";
	private static final int PORT = 5055;
	
	public Server() {
		try {	//try to start the server
			startup();	
		} catch(IOException currentException) {	//otherwise give error
			currentException.printStackTrace();
		}
	}
	
	private void startup() throws IOException{
		ServerBootstrap serverBootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
		serverBootstrap.setPipelineFactory(new PipelineFactory());
		serverBootstrap.bind(new InetSocketAddress(BIND_ADDRESS, PORT));
		
		System.err.println("Server initialized...");
	}
	
	public static void main(String[] args) {
		new Server();	//start the server
	}
}
