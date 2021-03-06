package org.wenjiechen.hw6.client;

import org.shared.chess.Move;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface ChessGameServiceAsync {
	/**
	 * check if user logged in, and return token to create Channel 
	 * @return
	 */
	public void creatChannelForLoggedInUser(String playerEmail,AsyncCallback<String> callback);
	/**
	 * generate logout URL
	 */
	public void LogOutLinkGenerator(String redirectURL, AsyncCallback<String> callback);
	
	public void LogInLinkGenerator(String redirectURL, AsyncCallback<String> callback);
	
	public void sendMoveAndState(String email, String move, AsyncCallback<Void> callback);
	
	/**
	 * if user logged in and matched, delete the matched pairs
	 */
	public void deleteMatch(String matchid, AsyncCallback<Void> callback);
	
	public void autoMatch(String email,AsyncCallback<Void> callback);
	
//	public void removeUserFromWaitinglist(AsyncCallback<Void> callback);
	
	public void fetchMatchList(String email,AsyncCallback<String> callback);
	public void emailMatch(String plyaerEmail,String inputemail,AsyncCallback<Void> callback);
	public void getLoginPlayerInfo(AsyncCallback<Void> callback);
	public void calculateRank(String matchid,String gameResult, AsyncCallback<Void> callback);
}
