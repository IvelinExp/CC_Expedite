package org.cc.exp.security.ui.signup;

import org.cc.exp.domain.Account;
import org.vaadin.spring.mvp.MvpPresenterHandlers;

public interface SignUpPresenterHandlers extends MvpPresenterHandlers {
	
	void tryCreateAccount(Account account);

}
