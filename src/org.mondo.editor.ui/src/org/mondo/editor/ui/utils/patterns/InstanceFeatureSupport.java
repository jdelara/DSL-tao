package org.mondo.editor.ui.utils.patterns;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import runtimePatterns.InstanceFeatureRoleInstance;

/**
 * Class that implements the support for drop elements.
 * 
 * @author miso partner AnaPescador
 *
 */
public class InstanceFeatureSupport extends EditingSupport {

	 private final TableViewer viewer;
	 private final CellEditor editor;
	 private final DiagramBehavior db;

	  public InstanceFeatureSupport(TableViewer viewer, DiagramBehavior db) {
	    super(viewer);
	    this.viewer = viewer;
	    this.editor = new TextCellEditor(viewer.getTable());
	    this.db = db;
	  }

	  @Override
	  protected CellEditor getCellEditor(Object element) {
	    return editor;
	  }

	  @Override
	  protected boolean canEdit(Object element) {
	    return true;
	  }

	  @Override
	  protected Object getValue(Object element) {
		  InstanceFeatureRoleInstance a = (InstanceFeatureRoleInstance) element;
    	  return a.getValue();
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {
		  
		  db.getEditingDomain().getCommandStack().execute(new RecordingCommand(db.getEditingDomain()) {
				@Override
				protected void doExecute() {
					 ((InstanceFeatureRoleInstance) element).setValue((String)userInputValue);
				}	
			});
		  viewer.refresh();
	  }
}
