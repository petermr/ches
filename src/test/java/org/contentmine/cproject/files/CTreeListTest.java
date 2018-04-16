package org.contentmine.cproject.files;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.contentmine.CHESConstants;
import org.contentmine.cproject.CMineFixtures;
import org.contentmine.cproject.files.CProject;
import org.contentmine.cproject.files.CTreeList;
import org.junit.Assert;
import org.junit.Test;


public class CTreeListTest {

	private static final Logger LOG = Logger.getLogger(CTreeListTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}

	@Test
	public void testFileOrder() {
		CProject cProject = new CProject(CMineFixtures.TEST_SAMPLE);
		CTreeList cTreeList = cProject.getResetCTreeList();
//		LOG.debug(cTreeList.getCTreeDirectoryList());
		String SAMPLE_DIR = ""+CHESConstants.SRC_TEST_RESOURCES + "/" + CHESConstants.ORG_CM_CPROJECT + "/download/sample";
		Assert.assertEquals("ctrees",  "["
				+       SAMPLE_DIR+"/PMC4678086,"
				+ " " + SAMPLE_DIR+"/PMC4686705,"
				+ " " + SAMPLE_DIR+"/PMC4691483,"
				+ " " + SAMPLE_DIR+"/PMC4706908,"
				+ " " + SAMPLE_DIR+"/PMC4706911,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1001_jama.2016.7992,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1007_s13201-016-0429-9,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1016_s0096-0217(16)30238-2,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1017_s1816383116000278,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1021_jacs.6b05099,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1024_2296-4924_a000010,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1027_0227-5910_a000389,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1029_2016eo053239,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1038_srep27030,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1039_c6tc01003b,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1042_bsr20160124,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1051_metal_2016016,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1053_j.ajkd.2016.04.015,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1055_s-006-31518,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1057_udi.2016.10,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1061_(asce)is.1943-555x.0000314,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1063_pt.3.3183,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1080_1533015x.2016.1181014,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1111_spsr.12213,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1158_2326-6066.cir-16-0089,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1166_jctn.2016.4873,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1177_1755738016647282,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.14387_jkspth.2016.49.67,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1515_fjsb-2010-0305,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.15611_pn.2016.422.14,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.1590_s0103-21862016000100014,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.16962_eapjpmc_issn.2394-9376_2015_v1i1.05,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.20448_journal.510_2016.3.1_510.1.32.37,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.21528_cbic2011-905,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.3161_15081109acc2016.18.1.017,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.3324_haematol.2016.148015,"
				+ " " + SAMPLE_DIR+"/http_dx.doi.org_10.4000_geocarrefour.9765"
				+ "]",
				cTreeList.getCTreeDirectoryList().toString());
	}
}
