package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.fw.Folders;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
public class TestFolderCreation extends TestBase {
	@Test
	public void TestFolderCreation(){
String folder="newfolder";
Folders oldFolders=app.getFolderHelper().getFolders();
assertThat(app.getFolderHelper().createFolder(folder),is(nullValue()));
Folders newFolders=app.getFolderHelper().getFolders();
assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));

	}
	@Test
	public void TestFolderWithSameNameCreation(){
		String folder="newfolder3";
		Folders oldFolders1=app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder),is(nullValue()));
		Folders newFolders1=app.getFolderHelper().getFolders();
		assertThat(newFolders1,equalTo(oldFolders1.withAdded(folder)));
		Folders oldFolders2=app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder), containsString("Duplicated folder name"));
		Folders newFolders2=app.getFolderHelper().getFolders();
		assertThat(newFolders2,equalTo(oldFolders2));
	}
	@Test
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
	
}
