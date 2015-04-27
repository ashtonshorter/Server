package server.controller;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelPipeline;

public class PipelineFactory implements ChannelPipelineFactory
{
	/**
	 * Gets the pipeline and adds encoders/decoders
	 */
	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = new DefaultChannelPipeline();
		pipeline.addLast("encoder", new Encoder());
		pipeline.addLast("decoder", new LoginServerDecoder());
		
		System.out.println("Pipeline constructed");
		
		return pipeline;
	}
}
