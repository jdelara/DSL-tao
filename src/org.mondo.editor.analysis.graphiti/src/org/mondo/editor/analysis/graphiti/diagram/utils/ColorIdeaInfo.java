package org.mondo.editor.analysis.graphiti.diagram.utils;

import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

/**
 * Model class to work with color idea info.
 * background
 * foreground
 * nameText
 * orderText
 * line
 * patternText
 * 
 * @author miso partner AnaPescador
 * */
public class ColorIdeaInfo {
		
	private ColorConstant background;
	private ColorConstant foreground;
	private ColorConstant nameText;
	private ColorConstant orderText;
	private ColorConstant line;
	private ColorConstant patternText;

	public ColorConstant getBackground() {
		return background;
	}

	public void setBackground(ColorConstant background) {
		this.background = background;
	}

	public ColorConstant getForeground() {
		return foreground;
	}

	public void setForeground(ColorConstant foreground) {
		this.foreground = foreground;
	}

	public ColorConstant getTextName() {
		return nameText;
	}


	public void setTextName(ColorConstant textName) {
		this.nameText = textName;
	}

	public ColorConstant getOrderText() {
		return orderText;
	}

	public void setOrderText(ColorConstant textOrder) {
		this.orderText = textOrder;
	}

	public ColorConstant getLine() {
		return line;
	}

	public void setLine(ColorConstant line) {
		this.line = line;
	}
	
	public ColorConstant getPatternText() {
		return patternText;
	}

	public void setPatternText(ColorConstant pattern) {
		this.patternText = pattern;
	}
	
	public ColorIdeaInfo(ColorConstant background, ColorConstant foreground,
			ColorConstant textOrder, ColorConstant line) {
		super();
		this.background = background;
		this.foreground = foreground;
		this.orderText = textOrder;
		this.nameText = (ColorConstant)IColorConstant.BLACK;
		this.line = line;
		this.patternText = (ColorConstant)IColorConstant.BLACK;
	}

	public ColorIdeaInfo(ColorConstant background, ColorConstant foreground,
			ColorConstant textName, ColorConstant textOrder,
			ColorConstant line) {
		super();
		this.background = background;
		this.foreground = foreground;
		this.nameText = textName;
		this.orderText = textOrder;
		this.line = line;
		this.patternText = (ColorConstant)IColorConstant.BLACK;
	}
}