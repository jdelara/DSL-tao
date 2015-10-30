package org.mondo.editor.analysis.graphiti.diagram.utils;

/**
 * Model class to work with transformation options.
 * key
 * text
 * 
 * @author miso partner AnaPescador
 * */
public class TransformationOption {
		
	private String key;
	private String text;
	private String imgPath;

	
	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public TransformationOption(String key, String text, String imgPath) {
		super();
		this.key = key;
		this.text = text;
		this.imgPath = imgPath;
	}

}
