package org.mondo.editor.ui.utils.dragdrop;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.mondo.editor.ui.utils.patterns.MMInterfaceRelDiagram;

import dslPatterns.FeatureInstance;

/**
 * Class that implements the support for drop elements.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ElementDiagramSupport extends EditingSupport {

	 private final TreeViewer viewer;
	  private final CellEditor editor;

	  public ElementDiagramSupport(TreeViewer viewer) {
	    super(viewer);
	    this.viewer = viewer;
	    this.editor = new TextCellEditor(viewer.getTree());
	  }

	  @Override
	  protected CellEditor getCellEditor(Object element) {
	    return editor;
	  }

	  @Override
	  protected boolean canEdit(Object element) {
	    if (((MMInterfaceRelDiagram)element).getMmInterface() instanceof FeatureInstance)
		  return true;
	    else return false;
	  }

	  @Override
	  protected Object getValue(Object element) {
	    return ((MMInterfaceRelDiagram) element).getElementDiagram();
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {		  
		  ((MMInterfaceRelDiagram) element).setElementDiagram((String)userInputValue);
		  viewer.refresh();
	  }

}
