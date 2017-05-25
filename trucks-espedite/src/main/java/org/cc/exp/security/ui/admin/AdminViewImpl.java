package org.cc.exp.security.ui.admin;

import org.vaadin.spring.VaadinComponent;
import org.cc.exp.security.ui.admin.AdminPresenter.AdminView;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.mvp.view.AbstractMvpView;

import com.vaadin.data.Item;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@UIScope
@VaadinComponent
public class AdminViewImpl extends AbstractMvpView implements AdminView {
	
	private CssLayout layout;
	
	@Override
	public void postConstruct() {	
		super.postConstruct();
		setSizeFull();
		layout = new CssLayout();
		layout.setSizeFull();
		setCompositionRoot(layout);
		
		
		final Label label = new Label("This is admin only view");
		label.addStyleName(ValoTheme.LABEL_H2);
		

		
		final Table table = new Table("The Brightest Stars");
	    Label label2 = new Label("<pre>First line\rSecond line\nThird line</pre>", Label.CONTENT_XHTML);
	    
		// Define two columns for the built-in container
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("Mag",  Double.class, null);

		// Add a row the hard way
		Object newItemId = table.addItem();
		Item row1 = table.getItem(newItemId);
		row1.getItemProperty("Name").setValue("Sirius");
		row1.getItemProperty("Mag").setValue(-1.46);
		 
		// Add a few other rows using shorthand addItem()
		table.addItem(new Object[]{"Canopus",        -0.72}, 2);
		table.addItem(new Object[]{"Arcturus",       -0.04}, 3);
		table.addItem(new Object[]{"Alpha Centauri", -0.01}, 4);
		        
		// Show 5 rows 
		table.setPageLength(5);
		layout.addComponents(label2,label, table );		
	}
}
