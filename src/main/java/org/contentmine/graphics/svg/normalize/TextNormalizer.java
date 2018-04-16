package org.contentmine.graphics.svg.normalize;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.contentmine.eucl.euclid.RealArray;
import org.contentmine.graphics.svg.SVGG;
import org.contentmine.graphics.svg.SVGText;

/** normalizes (compacts) texts.
 * will extract common y coordinates  and create x-array
 * 
 * creates chunks whenever style attribute changes
 * 
 * @author pm286
 *
 */
public class TextNormalizer {
	private static final Logger LOG = Logger.getLogger(TextNormalizer.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
}
