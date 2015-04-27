package server.model;

import java.util.ArrayList;
import java.util.List;

import org.jboss.netty.channel.Channel;

public class Account
{
	private final Channel channel;
	public static List<Account> OnlineAccounts = new ArrayList<Account>();
	
	public Account(Channel channel) {
		this.channel = channel;
		login("Test");
	}
	
	/**
	 * Logs in the user passed in by adding to the OnlineAccounts array
	 * @param username Username to add to OnlineAccounts
	 */
	public void login(String username) {
		OnlineAccounts.add(this);	//adds the user the the OnlineAccounts array
	}
	
	/**
	 * Returns the channel
	 * @return Returns channel
	 */
	public Channel getChannel() {
		return channel;
	}
	
	/**
	 * Gets the account by channel and returns it, otherwise null
	 * @param channel channel to check for account on
	 * @return Returns the account found, or null
	 */
	public static Account getAccountByChannel(Channel channel)
	{
		for(Account account : OnlineAccounts) {
			if(account.getChannel().equals(channel)) {
				return account;
			}
		}
		
		return null;
	}
}
