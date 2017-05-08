package org.cc.exp.security.ui.signin;

import org.vaadin.spring.mvp.MvpPresenterHandlers;

public interface SignInPresenterHandlers extends MvpPresenterHandlers {

	void doSignIn(String username, String password, boolean rememberMe);
	
}
