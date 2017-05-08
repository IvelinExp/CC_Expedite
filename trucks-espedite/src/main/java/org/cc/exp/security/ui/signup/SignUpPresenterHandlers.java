package org.cc.exp.security.ui.signup;

import org.cc.exp.security.sql.setup.Account;
import org.vaadin.spring.mvp.MvpPresenterHandlers;

public interface SignUpPresenterHandlers extends MvpPresenterHandlers {
	
	void tryCreateAccount(Account account);

}
