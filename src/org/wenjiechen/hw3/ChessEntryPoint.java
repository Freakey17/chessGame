package org.wenjiechen.hw3;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import org.shared.chess.State;
import org.wenjiechen.hw6.client.ChessGameService;
import org.wenjiechen.hw6.client.ChessGameServiceAsync;
import org.wenjiechen.hw6.client.LoginInfo;
import org.wenjiechen.hw6.client.LoginService;
import org.wenjiechen.hw6.client.LoginServiceAsync;

public class ChessEntryPoint implements EntryPoint {

	private LoginInfo loginInfo = null;
	private Label loginLabel = new Label(
			"Use your Google Account to sign in the Chess Game by wenjie chen.");
	private Anchor signInLink = new Anchor("Sign In");
	
	private VerticalPanel fakeLoginPanel = new VerticalPanel();
	private PopupPanel popupLoginPanel  = new PopupPanel();
	private TextBox emailBox = new TextBox();
	private Button submit = new Button();
	private HTML likebtt = new HTML();

//	SuggestBox emailMatchSuggestBox = new SuggestBox();	
//    private final MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	
	@Override
	public void onModuleLoad() {
		submit.setText("Login");
		likebtt.setHTML("<iframe src=\"https://www.facebook.com/plugins/like.php?href=http://chess-wenjie.appspot.com/wenjiechen.html\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; width:450px; height:80px\"></iframe>");
		fakeLoginPanel.add(new Label("Enter your email to login"));
		fakeLoginPanel.add(emailBox);
		fakeLoginPanel.add(submit);
		fakeLoginPanel.add(likebtt);
//		popupLoginPanel.add(fakeLoginPanel);
//		popupLoginPanel.center();
		Graphics graphics = new Graphics();
		final Graphics finalgraphics = graphics;
		RootPanel.get().add(fakeLoginPanel);
		RootPanel.get().add(graphics);
		graphics.initial();
		Presenter presenter = new Presenter();
		presenter.setView(graphics);
		graphics.setPresenter(presenter);
		presenter.viewBinder();
		presenter.setState(new State());

		submit.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("click login");
				String email = emailBox.getText();
				finalgraphics.getPlayerEmail(email);
//				popupLoginPanel.hide();
			}
		});
		
//		presenter.getContacts();
		
//		LoginServiceAsync loginService = GWT.create(LoginService.class);
//		loginService.login(GWT.getHostPageBaseURL()+ "wenjiechen.html",
//				
//				new AsyncCallback<LoginInfo>() {
//					@Override
//					public void onFailure(Throwable error) {
//						Window.alert("Login page failure!");
//					}
//
//					@Override
//					public void onSuccess(LoginInfo result) {
////						Window.alert("Login page success!");
//						loginInfo = result;
//						if (loginInfo.isLoggedIn()) {
//							loadModule();
//						} else {
//							loadLogin();
//						}
//					}
//				});
		
	}

//	private void loadModule() {
//		submit.setText("Login");
//		fakeLoginPanel.add(new Label("Enter your email to login"));
//		fakeLoginPanel.add(emailBox);
//		fakeLoginPanel.add(submit);
////		popupLoginPanel.add(fakeLoginPanel);
////		popupLoginPanel.center();
////		Button test = new Button();
////		test.setText("test1");
////		test.setVisible(true);
//		Graphics graphics = new Graphics();
//		final Graphics finalgraphics = graphics;
//		RootPanel.get().add(fakeLoginPanel);
//		RootPanel.get().add(graphics);
//		graphics.initial();
//		Presenter presenter = new Presenter();
////		final Presenter finalPresenter = presenter;
//		presenter.setView(graphics);
//		graphics.setPresenter(presenter);
////		graphics.setLogoutURL(loginInfo.getLogoutUrl());		
//		presenter.viewBinder();
//		presenter.setState(new State());
//		presenter.getContacts();
//
//		
////		submit.addClickHandler(new ClickHandler() {
////			@Override
////			public void onClick(ClickEvent event) {
////			 String email = emailBox.getText();				
////			 finalgraphics.getPlayerEmail(email);
////			 popupLoginPanel.hide();
////			}
////		});
//
//	}

//	private void loadLogin() {
//		// Assemble login panel.
////		System.out.println("loadModule(): loadLogin");
//		signInLink.setHref(loginInfo.getLoginUrl());
//		loginPanel.add(loginLabel);
//		loginPanel.add(signInLink);
//		RootPanel.get().add(loginPanel);
//	}
	
}