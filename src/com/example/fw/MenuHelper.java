package com.example.fw;

import javax.swing.JMenuBar;

import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper extends HelperBase {

	public MenuHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public void pushFolderCreation() {
	JMenuBarOperator menu = new JMenuBarOperator(mainFrame);	
	menu.pushMenuNoBlock("File|New folder...");	
	}

}
