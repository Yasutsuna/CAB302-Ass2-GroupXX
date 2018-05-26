package project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GUITestCase {
	
	Store store;
	List<Store> storeList = new ArrayList<Store>();

	@Test
	public void testInitialFunction() {
		String testName = "tomatoes";
		String getTestName = "tomatoes";
		
		store = new Store("tomatoes", 0, 1, 2, 325, 400, 10);
		storeList.add(store);
		
		try {
			for (Store st: storeList) {
				getTestName = st.getName(); 
			}
		} catch (Exception e) {	
			}
		}

	
	@Test
	public void testmanifestFunction() {
		//todo
	}
	
	public void testReadFile() {
		//CSV test file are done manually
	}
	
	public void testExportManifest() {
		//Export Manifest file are done manually
	}
	
	public void testDisplay() {
		//Display related files are tested manually
	}

}
