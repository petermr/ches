package org.contentmine.graphics.svg.math;

import java.awt.geom.Line2D;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.contentmine.eucl.euclid.Line2;
import org.contentmine.graphics.AbstractCMElement;
import org.contentmine.graphics.svg.SVGG;

import nu.xom.Element;

/** currently represents a line of math.
 * may be assembled in Math Cache
 * 
 * @author pm286
 *
 */
public class SVGMath extends SVGG {
	private static final Logger LOG = Logger.getLogger(SVGMath.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}

	public final static String CLASS ="math";
	
	/** constructor
	 */
	public SVGMath() {
		super();
		this.setSVGClassName(CLASS);
	}

	public SVGMath(AbstractCMElement svgText) {
		this.appendChild(svgText.copy());
	}

	
	
}
