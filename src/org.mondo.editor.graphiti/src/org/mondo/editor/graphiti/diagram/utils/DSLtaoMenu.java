package org.mondo.editor.graphiti.diagram.utils;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

public class DSLtaoMenu extends ExtensionContributionFactory {

	public DSLtaoMenu() {
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		MenuManager menu = new MenuManager();
		menu.setMenuText("DSL-tao");
		menu.add(new DSLtaoMenuOption());
		additions.addContributionItem(menu, null);
	}
	
	
	

}
