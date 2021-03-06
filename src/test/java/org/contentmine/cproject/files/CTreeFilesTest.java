package org.contentmine.cproject.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.contentmine.cproject.CMineFixtures;
import org.contentmine.cproject.files.CTree.TableFormat;
import org.contentmine.cproject.util.CMineGlobber;
import org.contentmine.cproject.util.CMineTestFixtures;
import org.contentmine.graphics.svg.SVGElement;
import org.contentmine.graphics.svg.SVGText;
import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * @author pm286
 *
 */
public class CTreeFilesTest {

	;
	private static final Logger LOG = Logger.getLogger(CTreeFilesTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	@Test
	public void testAddFile() {
		CTree cTree = new CTree(new File("zz/cTree"));
		CTreeFiles cTreeFiles = new CTreeFiles(cTree);
		cTreeFiles.add(new File("a/b.xml"));
		cTreeFiles.add(new File("c/d.txt"));
		cTreeFiles.add(new File("b/e.pdf"));
		Assert.assertEquals("cTreeFiles", ""
				+ "<cTreeFiles cTree=\"zz/cTree\">"
				+ "<file name=\"a/b.xml\" />"
				+ "<file name=\"c/d.txt\" />"
				+ "<file name=\"b/e.pdf\" />"
				+ "</cTreeFiles>", 
				cTreeFiles.toString());
	}
	
	@Test
	public void testAddFileAndSort() {
		CTree cTree = new CTree(new File("zz/cTree"));
		CTreeFiles cTreeFiles = new CTreeFiles(cTree);
		cTreeFiles.add(new File("a/b.xml"));
		cTreeFiles.add(new File("c/d.txt"));
		cTreeFiles.add(new File("b/e.pdf"));
		cTreeFiles.sort();
		Assert.assertEquals("cTreeFiles", ""
				+ "<cTreeFiles cTree=\"zz/cTree\">"
				+ "<file name=\"a/b.xml\" />"
				+ "<file name=\"b/e.pdf\" />"
				+ "<file name=\"c/d.txt\" />"
				+ "</cTreeFiles>", 
				cTreeFiles.toString());
	}
	
	@Test
	/** makes list of SVG files in project.
	 * 
	 */
	
	public void testMakeSVGList() {
		File targetDir = new File("target/pdfsvg/");
		CMineTestFixtures.createCleanedCopiedDirectory(CMineFixtures.TEST_PDF_SVG_DIR, targetDir);
		CProject cProject = new CProject(targetDir);
		CTreeList cTreeList = cProject.getResetCTreeList();
		Assert.assertEquals("svgDirs ", 3, cTreeList.size());
		int[] svgCounts = {13, 14, 9};
		int[] textCounts = {3782, 3681, 4305}; // may be fragile
		for (int i = 0; i < cTreeList.size(); i++) {
			CTree cTree = cProject.getResetCTreeList().get(i);
			File[] files = cTree.getDirectory().listFiles();
			Assert.assertEquals("files ", 2, files.length); // has fulltext.pdf as well as svg
			File svgDir = cTree.getExistingSVGDir();
			Assert.assertTrue("exists", svgDir.exists());
			List<File> svgFiles = cTree.getExistingSVGFileList();
			Assert.assertEquals("svgFiles ", svgCounts[i], svgFiles.size());
			SVGElement svg = SVGElement.readAndCreateSVG(svgFiles.get(0));
			List<SVGText> texts = SVGText.extractSelfAndDescendantTexts(svg);
			Assert.assertEquals("svgTexts ", textCounts[i], texts.size());
		}
		
	}

	@Test
	/** makes list of SVG files in project.
	 * 
	 */
	
	public void testMakeSVGImagesList() {
		File targetDir = new File("target/pdfsvg/");
		CMineTestFixtures.createCleanedCopiedDirectory(CMineFixtures.TEST_PDF_SVG_DIR, targetDir);
		CProject cProject = new CProject(targetDir);
		CTreeList cTreeList = cProject.getResetCTreeList();
		Assert.assertEquals("CTrees ", 3, cTreeList.size());
		int[] svgImages = {14, 13, 10};
		for (int i = 0; i < cTreeList.size(); i++) {
			CTree cTree = cProject.getResetCTreeList().get(i);
			File[] files = cTree.getDirectory().listFiles();
			Assert.assertEquals("files ", 2, files.length); // has fulltext.pdf as well as svg
			File svgImagesDir = cTree.getExistingSVGImagesDir();
			Assert.assertTrue("exists", svgImagesDir.exists());
			List<File> svgImageFiles = cTree.getExistingSVGImagesFileList();
			Assert.assertEquals("svgFiles ", svgImages[i], svgImageFiles.size());
		}
		
	}

	@Test
	/** makes list of SVG tables in project.
	 * 
	 */
	
	public void testGetTablesList() {
		File targetDir = new File("target/pdfsvg/tables/");
		CMineTestFixtures.createCleanedCopiedDirectory(CMineFixtures.TEST_TABLES_DIR, targetDir);
		CProject cProject = new CProject(targetDir);
		CTreeList cTreeList = cProject.getResetCTreeList();
		Assert.assertEquals("CTrees ", 2, cTreeList.size());
		int[] tables = {5, 3};
		for (int i = 0; i < cTreeList.size(); i++) {
			CTree cTree = cProject.getResetCTreeList().get(i);
			File[] files = cTree.getDirectory().listFiles();
			File svgTablesDir = cTree.getExistingSVGTablesDir();
			Assert.assertTrue("exists", svgTablesDir.exists());
			List<File> svgTablesFiles = cTree.getExistingSVGTablesDirList();
			Assert.assertEquals("tables ", tables[i], svgTablesFiles.size());
		}
		
	}

	@Test
	/** makes list of SVG table subfiles.
	 * 
	 * see above test
	}
	

	 */
	
	public void testGetTablesComponents() {
		File targetDir = new File("target/pdfsvg/tables/");
		CMineTestFixtures.createCleanedCopiedDirectory(CMineFixtures.TEST_TABLES_DIR, targetDir);
		CProject cProject = new CProject(targetDir);
		CTreeList cTreeList = cProject.getResetCTreeList();
		
		String TREE239 = "_10.1038.ijo.2016.239";
		CTree tree239 = cProject.getCTreeByName(TREE239);
		Assert.assertNotNull(TREE239, tree239);
		File svgTablesDir = tree239.getExistingSVGTablesDir();
		Assert.assertTrue("exists", svgTablesDir.exists());
		File tablesFile1 = tree239.getExistingSVGTablesDirList().get(0);
		Assert.assertEquals("table1 ", "table1", tablesFile1.getName());
		File svgTable = tree239.getExistingTableFile(1, TableFormat.TABLE_SVG);
		Assert.assertNotNull(TableFormat.TABLE_SVG.toString(), svgTable);
		File svgAnnot = tree239.getExistingTableFile(1, TableFormat.TABLE_SVG__ANNOT_SVG);
		Assert.assertNull(TableFormat.TABLE_SVG__ANNOT_SVG.toString(), svgAnnot);
		
		String TREE563 = "10.1186.1471-2458-14-563";
		svgAnnot =  cProject.getCTreeByName(TREE563).
				getExistingTableFile(2, TableFormat.TABLE_SVG__ANNOT_SVG);
		Assert.assertNotNull(TREE563, svgAnnot);
	}

}
