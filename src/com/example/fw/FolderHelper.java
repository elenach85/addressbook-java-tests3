package com.example.fw;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JToolBar;

import org.netbeans.jemmy.operators.DialogOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JLabelOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.fw.Folders;

public class FolderHelper extends HelperBase {

	public FolderHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public Folders getFolders() {
		List<String> list=new ArrayList<String>();
		JTreeOperator tree=new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		tree.getChildCount(tree.getRoot());
		for (Object child : children) {
			list.add(""+ child);
		}
		return new Folders(list);
	}

	public String createFolder(String folderName) {
		manager.getMenuHelper().pushFolderCreation();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
	new JTextFieldOperator(dialog).setText(folderName);
	new JButtonOperator(dialog, "OK").push();
	return waitDialog("Warning",3000);
	}
	 
	public void deleteFolder(int index){
		JTreeOperator tree=new JTreeOperator(mainFrame);
		tree.selectRow(index);
		manager.getMenuHelper().pushFolderDeletion();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JButtonOperator(dialog, "Yes").push();
		
	}
	
	public Integer getFolderListSize(){
		JTreeOperator tree=new JTreeOperator(mainFrame);
		int childCount = tree.getChildCount(tree.getRoot());
		return childCount;
	
	}
}
