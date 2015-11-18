package com.example.fw;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

import java.io.IOException;
public class ApplicationManager {

	private FolderHelper folderHelper;
	private JFrameOperator mainFrame;
	private MenuHelper menuHelper;
	public  ApplicationManager() throws IOException{
		start();
	}
		public void stop() {	
getApplication().requestClose();
		}
	
		public void start() throws IOException {	

		}
	
		
		public FolderHelper getFolderHelper() {

			if (folderHelper==null){
			folderHelper=new FolderHelper(this);
						}
				return folderHelper;
	
		}
		public JFrameOperator getApplication() {
			if (mainFrame==null) {
				
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				 mainFrame = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			}
			return mainFrame;
			
		}
		public MenuHelper getMenuHelper() {
			if (menuHelper==null) {
			menuHelper=new MenuHelper(this);
			}
			return menuHelper;
		}
	
		}


