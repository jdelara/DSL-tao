package org.mondo.editor.graphiti.diagram.utils;

import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

/**
 * Class of utility functions to define the diagram styles.
 * 
 * @author miso partner AnaPescador
 *
 */
public class DiagramStyles {
	
	public static final int PACKAGE_WIDTH = 185;
	public static final int PACKAGE_HEIGHT = 100;

	public static final int CLASS_MIN_WIDTH = 185;
	public static final int CLASS_WIDTH = 200;
	
	public static final int CLASS_MIN_HEIGHT = 80;
	public static final int CLASS_HEIGHT = 100;
	public static final int CLASS_DEF_HEIGHT = 45;

	
	public static final int ENUM_MIN_WIDTH = 100;
	public static final int ENUM_WIDTH = 120;
	
	public static final int ENUM_MIN_HEIGHT = 80;
	public static final int ENUM_HEIGHT = 100;
	
	public static final int EXTRA_BIG_SIZE_FONT = /*9*/12;
	public static final int BIG_SIZE_FONT = /*8*/11;
	public static final int MEDIUM_SIZE_FONT = /*7*/10;
	public static final int SMALL_SIZE_FONT = /*6*/9;
	
	public static final IColorConstant PACKAGE_BACKGROUND = new ColorConstant(194, 148, 166);
	public static final IColorConstant PACKAGE_FOREGROUND = ColorConstant.BLACK;
	public static final IColorConstant PACKAGE_TEXT_FOREGROUND = ColorConstant.BLACK;
	
	public static final IColorConstant CLASS_TEXT_FOREGROUND =	ColorConstant.BLACK;
	public static final IColorConstant CLASS_FOREGROUND = ColorConstant.BLACK;
	public static final IColorConstant CLASS_BACKGROUND = new ColorConstant(148, 177, 194);
	
	public static final IColorConstant ELEMENT_EMPHASIZED = new ColorConstant(244,242,102);
	
	public static final IColorConstant ENUM_TEXT_FOREGROUND = ColorConstant.BLACK;
	public static final IColorConstant ENUM_FOREGROUND = ColorConstant.BLACK;
	public static final IColorConstant ENUM_BACKGROUND = ColorConstant.ORANGE;
	
	public static final IColorConstant TAG_TEXT = ColorConstant.DARK_GRAY;

	public static final IColorConstant ANNOTATION_FOREGROUND =  /*new ColorConstant(15,132,102)*/ColorConstant.BLACK;
	
}
