package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.util.Random;

import org.netbeans.jemmy.operators.JTreeOperator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.fw.Folders;

public class TestFolderDeletion extends TestBase{
	@BeforeTest
	public void TestFolderWithVariousNamesCreation(){
		String folder1="newfolder1";
		String folder2="newfolder2";
		Folders oldFolders1=app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1),is(nullValue()));
		Folders newFolders1=app.getFolderHelper().getFolders();
		assertThat(newFolders1,equalTo(oldFolders1.withAdded(folder1)));
		Folders oldFolders2=app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder2),is(nullValue()));
		Folders newFolders2=app.getFolderHelper().getFolders();
		assertThat(newFolders2,equalTo(oldFolders2.withAdded(folder2)));
	}
	@Test
	public void TestFolderDeletion(){
		Folders oldFolders=app.getFolderHelper().getFolders();
		Random rnd=new Random();
	Integer folderListSize = app.getFolderHelper().getFolderListSize();
	int index=rnd.nextInt(folderListSize-1);
	app.getFolderHelper().deleteFolder(index);
	Folders newFolders=app.getFolderHelper().getFolders();
	assertThat(newFolders,equalTo(oldFolders.without(index)));	
	}

}
