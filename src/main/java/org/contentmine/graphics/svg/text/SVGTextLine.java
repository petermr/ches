package org.contentmine.graphics.svg.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.contentmine.eucl.euclid.Real;
import org.contentmine.eucl.euclid.Real2Range;
import org.contentmine.graphics.html.HtmlElement;
import org.contentmine.graphics.html.HtmlSpan;
import org.contentmine.graphics.svg.SVGElement;
import org.contentmine.graphics.svg.SVGG;
import org.contentmine.graphics.svg.SVGText;
import org.contentmine.graphics.svg.SVGTextComparator;

import nu.xom.Element;
import nu.xom.Elements;

/** holds a line for text, including subscripts, etc.
 * 
 * assembles SVGText with equal Y into a single line.
 * 
 * CHECK WHETHER PHRASE DOES THIS.
 * or see if Phrase should be moved into TextCache
 * @author pm286
 *
 */
public class SVGTextLine extends SVGG implements List<SVGText> {
	private static final Logger LOG = Logger.getLogger(SVGTextLine.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	private final static String TAG = "textLine";
	private final static double YEPS = 0.0001;
	private static final double FONT_EPS = 0.1;
	private static final double SUS_EPS = 0.1;
	public static final String COLUMN_SPAN = "columnSpan";

	private List<SVGText> lineTexts;
	private Double fontSize;
	private String fontName;

	public SVGTextLine() {
		super(TAG);
		this.lineTexts = new ArrayList<SVGText>();
	}

	public SVGTextLine(List<SVGText> lineTexts) {
		this();
		this.lineTexts = new ArrayList<SVGText>(lineTexts);
		sortAndGetCommonValues();
	}

	private void sortAndGetCommonValues() {
		Collections.sort(lineTexts, new SVGTextComparator(SVGTextComparator.TextComparatorType.X_COORD));
		getOrCreateCommonFontSize();
		getOrCreateCommonFontName();
	}
	
	public Double getOrCreateCommonFontSize() {
		fontSize = null;
		for (SVGText lineText : lineTexts) {
			Double fs = lineText.getFontSize();
			if (fontSize == null) {
				fontSize = fs;
			} else if (fs == null) {
				fontSize = null;
			} else if (!fontSize.equals(fs)) {
				fontSize = null;
			}
			if (fontSize == null) {
				break;
			}
		}
		return fontSize;
	}

	public String getOrCreateCommonFontName() {
		fontName = null;
		for (SVGText lineText : lineTexts) {
			String fn = lineText.getSVGXFontName();
			if (fontName == null) {
				fontName = fn;
			} else if (fn == null) {
				fontName = null;
			} else if (!fontName.equals(fn)) {
				fontName = null;
			}
			if (fontName == null) {
				break;
			}
		}
		return fontName;
	}

	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(""+fontName+"; "+fontSize+"\n");
		sb.append(getLineTextString());
		return sb.toString();
	}
	
	public String getLineTextString() {
		return lineTexts == null ? null : lineTexts.toString();
	}

	public String getTextValue() {
		StringBuilder sb = new StringBuilder();
		for (SVGText lineText : lineTexts) {
			sb.append(lineText.getText()+"|");
		}
		return sb.toString();
	}

	public Double getLeftX() {
		return lineTexts == null || lineTexts.size() == 0 ? null : lineTexts.get(0).getX();
	}

	public boolean isLeftIndented(double minimumIndent, double minimumLeftX) {
		Double leftX = getLeftX();
		return leftX - minimumLeftX > minimumIndent;
	}

	public int size() {
		return lineTexts.size();
	}

	public boolean isEmpty() {
		return lineTexts.isEmpty();
	}

	public boolean contains(Object o) {
		return lineTexts.contains(o);
	}

	public Iterator<SVGText> iterator() {
		return lineTexts.iterator();
	}

	public Object[] toArray() {
		return lineTexts.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return lineTexts.toArray(a);
	}

	public boolean add(SVGText e) {
		return lineTexts.add(e);
	}

	public boolean remove(Object o) {
		return lineTexts.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return lineTexts.containsAll(c);
	}

	public boolean addAll(Collection<? extends SVGText> c) {
		return lineTexts.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends SVGText> c) {
		return lineTexts.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return lineTexts.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return retainAll(c);
	}

	public void clear() {
		lineTexts.clear();
	}

	public SVGText get(int index) {
		return lineTexts.get(index);
	}

	public SVGText set(int index, SVGText element) {
		return lineTexts.set(index, element);
	}

	public void add(int index, SVGText element) {
		lineTexts.add(index, element);
	}

	public SVGText remove(int index) {
		return lineTexts.remove(index);
	}

	public int indexOf(Object o) {
		return lineTexts.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return lineTexts.lastIndexOf(o);
	}

	public ListIterator<SVGText> listIterator() {
		return lineTexts.listIterator();
	}

	public ListIterator<SVGText> listIterator(int index) {
		return lineTexts.listIterator(index);
	}

	public List<SVGText> subList(int fromIndex, int toIndex) {
		return subList(fromIndex, toIndex);
	}

	/** appends one text line, and increments its X coordinates.
	 * this should  result in a single new line
	 * @param appendTextLine
	 */
	public void append(SVGTextLine appendTextLine, double deltaX) {
		List<SVGText> appendLineTexts = new ArrayList<SVGText>(appendTextLine.lineTexts);
		double xOffset = this.getRightX() + deltaX - appendTextLine.getLeftX();
		double yOffset = appendTextLine.getY();
		for (SVGText appendText : appendLineTexts) {
			SVGText textCopy = (SVGText) appendText.copy();
			// end of "this" + space and relative position in appendLine
			textCopy.setX(textCopy.getXArray().plus(xOffset));
			textCopy.setY(this.getY() + textCopy.getY() - yOffset);
			this.lineTexts.add(textCopy);
		}
		clearVariables();
	}

	public Double getY() {
		return lineTexts.size() == 0 ? null : lineTexts.get(0).getY();
	}

	private double getRightX() {
		SVGText text = lineTexts.get(lineTexts.size() - 1);
		double xMax = text.getBoundingBox().getXMax();
		return xMax;
	}

	private void clearVariables() {
		fontSize = null;
		fontName = null;
	}

	/** copy text into child elements.
	 * 
	 * @return
	 */
	public SVGElement forceFullSVGElement() {
		Elements childElements = this.getChildElements();
		removeAllChildTextElements(childElements);
		getOrCreateFullSVGElement();
		return this;
	}

	private void removeAllChildTextElements(Elements childElements) {
		for (int i = childElements.size() - 1; i >= 0; i--) {
			Element childElement = childElements.get(i);
			if (childElement instanceof SVGText) {
				childElement.detach();
			}
		}
	}
	
	/** copy text into child elements.
	 * 
	 * @return
	 */
	public SVGElement getOrCreateFullSVGElement() {
		if (this.getChildElements().size() == 0) {
			for (SVGText text : lineTexts) {
				LOG.trace("appending text: "+text.toXML());
				this.appendChild(text.copy());
			}
		}
		return this;
	}
	
	public Real2Range getBoundingBox() {
		getOrCreateFullSVGElement();
		Real2Range bbox = lineTexts.size() == 0 ? null : lineTexts.get(0).getBoundingBox();
		if (bbox != null) {
			for (int i = 1; i < lineTexts.size(); i++) {
				bbox = bbox.plus(lineTexts.get(i).getBoundingBox());
				LOG.trace("textLine "+bbox);
			}
		}
//		LOG.debug("box "+bbox);
		return bbox;
	}

	/** compares textLines
	 * first uses getY(), then compares getTextValue()
	 * @param line1
	 * @return
	 */
	public int compareTo(SVGTextLine line2) {
		String textValue = this.getTextValue();
		String textValue2 = line2.getTextValue();
		Double y = this.getY();
		Double y2 = line2.getY();
		if (Real.isEqual(y, y2, YEPS)) {
			int textDiff = textValue.compareTo(textValue2);
			if (textDiff != 0) {
				return textDiff;
			}
			return 0;
		} else {
			return (this.getY() - line2.getY()) < 0 ? -1 : 1;
		}
		
	}

	public void mergeLine(SVGTextLine textLine) {
		lineTexts.addAll(textLine.lineTexts);
		forceFullSVGElement();
		this.sortAndGetCommonValues();
	}

	/** create an HtmlSpan element for complete line.
	 * will contain suscripts if they occur
	 * @param clazz 
	 * 
	 * @return
	 */
	public HtmlSpan createLineSpan(String clazz) {
		HtmlSpan span = new HtmlSpan();
		span.setClassAttribute(clazz);
		for (SVGText text : lineTexts) {
			
			double tSize = text.getFontSize();
			Double textY = text.getY();
			Double thisY = this.getY();
			if (textY - thisY > SUS_EPS) {
				span.appendChild(text.createSubscript());
			} else if (thisY - textY  > SUS_EPS) {
				span.appendChild(text.createSuperscript());
			} else {
				span.appendChild(text.getText());
			}
		}
		return span;
	}
}
