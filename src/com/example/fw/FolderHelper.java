package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTextField;

import org.netbeans.jemmy.operators.DialogOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
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
	protected String waitDialog(String title, int timeout) {
		long start=System.currentTimeMillis();
		long  currentTime=start;
		while (currentTime<start+timeout){
			JDialog dialog = JDialogOperator.findJDialog(mainFrame.getOwner(),title,false,false);
			if (dialog !=null) {
				DialogOperator dialogOp = new DialogOperator(dialog);
				String message=new JLabelOperator(dialogOp).getText();
				dialogOp.requestClose();
				return message;
			}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		currentTime=System.currentTimeMillis();
		}
		return null;
	}
}
