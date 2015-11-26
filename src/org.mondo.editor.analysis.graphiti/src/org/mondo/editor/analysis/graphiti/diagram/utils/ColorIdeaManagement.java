package org.mondo.editor.analysis.graphiti.diagram.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mindMapDSML.Idea;

import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class ColorIdeaManagement {

	//Default color configuration
	private static List<ColorIdeaInfo> colors = new ArrayList<ColorIdeaInfo>(Arrays.asList(
			new ColorIdeaInfo(new ColorConstant(255,153,153),new ColorConstant(255,153,153),(ColorConstant) IColorConstant.BLACK, new ColorConstant(255,153,153)),
			new ColorIdeaInfo(new ColorConstant(255,204,153),new ColorConstant(255,204,153),(ColorConstant) IColorConstant.BLACK, new ColorConstant(255,204,153)),
			new ColorIdeaInfo(new ColorConstant(204,255,153),new ColorConstant(204,255,153),(ColorConstant) IColorConstant.BLACK, new ColorConstant(204,255,153)),
			new ColorIdeaInfo(new ColorConstant(153,255,153),new ColorConstant(153,255,153),(ColorConstant) IColorConstant.BLACK, new ColorConstant(153,255,153)),
			new ColorIdeaInfo(new ColorConstant(153,255,204),new ColorConstant(153,255,204),(ColorConstant) IColorConstant.BLACK, new ColorConstant(153,255,204)),
			new ColorIdeaInfo(new ColorConstant(153,204,255),new ColorConstant(153,204,255),(ColorConstant) IColorConstant.BLACK, new ColorConstant(153,204,255)),
			new ColorIdeaInfo(new ColorConstant(153,153,255),new ColorConstant(153,153,255),(ColorConstant) IColorConstant.BLACK, new ColorConstant(153,153,255)),
			new ColorIdeaInfo(new ColorConstant(204,153,255),new ColorConstant(204,153,255),(ColorConstant) IColorConstant.BLACK, new ColorConstant(204,153,255)),
			new ColorIdeaInfo(new ColorConstant(255,153,255),new ColorConstant(255,153,255),(ColorConstant) IColorConstant.BLACK, new ColorConstant(255,153,255)),
			new ColorIdeaInfo(new ColorConstant(224,224,224),new ColorConstant(224,224,224),(ColorConstant) IColorConstant.BLACK, new ColorConstant(224,224,224)),
			new ColorIdeaInfo(new ColorConstant(255,255,153),new ColorConstant(255,255,153),(ColorConstant) IColorConstant.BLACK, new ColorConstant(255,255,153))
			));
	
	
	/**
	 * To obtain the color of the idea, depends on its parent.
	 * @param parentIdea
	 * @param diagram
	 * @return ColorIdeaInfo
	 */
	public static ColorIdeaInfo getColorIdea (Idea parentIdea, Diagram diagram){
		if (parentIdea != null)			
			if (ModelUtils.isFirstLevel(parentIdea))
				return getColorChildFree(diagram, parentIdea);
			 else return getColor(diagram, parentIdea);
		//doesn't have parent.
		return getDefaultColor();
	}
	
	
	/**
	 * To obtain the color free for a child.
	 * @param diagram
	 * @param parentIdea
	 * @return ColorIdeaInfo
	 */
	private static ColorIdeaInfo getColorChildFree (Diagram diagram, Idea parentIdea){
		boolean first = true;
		for (ColorIdeaInfo color: colors){
			if (!first){
				if (!isUsedColor(diagram, parentIdea, color))return color;
			}else first = false;
		}
		//Run out of default colors -> random.
		ColorConstant randomColor = getRandomColor();
		return new ColorIdeaInfo(randomColor, randomColor,(ColorConstant)ColorConstant.BLACK, randomColor);
	}
	
	/**
	 * Static method that returns the default color (the first, in the default color configuration.
	 * @return ColorIdeaInfo object.
	 */
	public static ColorIdeaInfo getDefaultColor(){
		return colors.get(0);
	}
	
	/**
	 * to know if the color is being using for a child of the idea.
	 * @param diagram
	 * @param idea for this idea for its children.
	 * @param cii
	 * @return true if it's used, false if not.
	 */
	public static boolean isUsedColor (Diagram diagram, Idea idea, ColorIdeaInfo cii){
		for (Idea child : idea.getContains()){
			ColorIdeaInfo colorChild = getColor(diagram, child);
			if (colorChild == null) return false;
			else if (getColor(diagram, child).equals(cii))
				return true;
		}
		return false;
	}
	
	/**
	 * Static method to know if the color is being using for a "brother" of the idea.
	 * @param diagram
	 * @param idea 
	 * @param cii
	 * @return true if it's, false if not.
	 */
	public static boolean isUsedColorForAnotherIdea (Diagram diagram, Idea idea){
		if (idea.eContainer() instanceof Idea) {
			Idea ideaParent = (Idea)idea.eContainer(); 
			ColorIdeaInfo cii = ColorIdeaManagement.getColor(diagram, idea);
			for (Idea child : ideaParent.getContains()){
				if (!child.equals(idea)){
					ColorIdeaInfo colorChild = getColor(diagram, child);
					if (colorChild == null) return false;
					else if (getColor(diagram, child).equals(cii))
						return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Static method that returns if the color of the idea is the same as the color of its parent.
	 * @param diagram
	 * @param idea
	 * @return true if it´s, false if not.
	 */
	public static boolean isUsedColorForMyParent (Diagram diagram, Idea idea){
		if (idea.eContainer() instanceof Idea) {
			Idea ideaParent = (Idea)idea.eContainer(); 
			ColorIdeaInfo cii = ColorIdeaManagement.getColor(diagram, idea);
			ColorIdeaInfo ciiParent = ColorIdeaManagement.getColor(diagram, ideaParent);
			return sameColor(cii, ciiParent);
			
		}
		return false;
	}
	

	/**
	 * To obtain the color of an idea.
	 * @param diagram
	 * @param idea
	 * @return ColorIdeaInfo
	 */
	public static ColorIdeaInfo getColor (Diagram diagram, Idea idea){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, idea);
		for (PictogramElement pe : pes){
			if (pe instanceof ContainerShape){
				Color color = ((ContainerShape)pe).getGraphicsAlgorithm().getBackground();
				for (ColorIdeaInfo cii : colors){
					if (sameColor(color, cii.getBackground()))
						return cii;
				}
				ColorConstant colorC = new ColorConstant(color.getRed(), color.getGreen(), color.getBlue());
				return new ColorIdeaInfo(colorC, colorC, (ColorConstant)ColorConstant.BLACK, colorC);
			}
		}
		return null;
	}
	
	/**
	 * Static method that returns a random color.
	 * @return ColorConstant object
	 */
	private static ColorConstant getRandomColor(){
		Random random = new Random();
	    int red = random.nextInt(256);
	    int green = random.nextInt(256);
	    int blue = random.nextInt(256);

	    ColorConstant color = new ColorConstant(red, green, blue);
	    return color;
	}
	
	/**
	 * Static method to know if the idea color is the default color.
	 * @param diagram
	 * @param idea
	 * @return true if it's, false if not.
	 */
	public static boolean isDefaultColor (Diagram diagram, Idea idea){
		List<PictogramElement> pes = Graphiti.getLinkService().getPictogramElements(diagram, idea);
		for (PictogramElement pe : pes){
			if (pe instanceof ContainerShape){
				Color color = ((ContainerShape)pe).getGraphicsAlgorithm().getBackground();
				return sameColor(color, getDefaultColor().getBackground());	
			}
		}
		return false;
	}
	
	/**
	 * Static method to know if the colors are the same.
	 * @param color
	 * @param colorConstant
	 * @return true if it's, false it not.
	 */
	private static boolean sameColor (Color color, IColorConstant colorConstant){
		return (color.getBlue()== colorConstant.getBlue()) && (color.getGreen() == colorConstant.getGreen()) && (color.getRed() == colorConstant.getRed());
	}
	
	/**
	 * Static method to know if the colors are the same.
	 * @param ColorConstant
	 * @param colorConstant
	 * @return true if it's, false it not.
	 */
	private static boolean sameColor (ColorIdeaInfo color1, ColorIdeaInfo color2){
		ColorConstant color1C = null;
		ColorConstant color2C = null;
		if (color1 != null) color1C = color1.getBackground(); else return false;
		if (color2 != null) color2C = color2.getBackground(); else return false;
		
		return (color1C.getBlue()== color2C.getBlue()) && (color1C.getGreen() == color2C.getGreen()) && (color1C.getRed() == color2C.getRed());
	}

}
