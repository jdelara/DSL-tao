package org.mondo.editor.analysis.graphiti.diagram.properties.edit;

import mindMapDSML.Feature;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

/**
 * Class to support the edition of features values.
 * 
 * @author miso partner AnaPescador
 *
 */
public class FeatureValueSupport extends EditingSupport {

	 private final TableViewer viewer;
	  private final CellEditor editor;

	  public FeatureValueSupport(TableViewer viewer) {
	    super(viewer);
	    this.viewer = viewer;
	    this.editor = new TextCellEditor(viewer.getTable());
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
	    return ((Feature) element).getValue();
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {		  
		final String oldValue = ((Feature) element).getValue();
		if (oldValue.compareTo(String.valueOf(userInputValue))!=0){
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((Feature) element);
	        domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					((Feature) element).setValue(String.valueOf(userInputValue));
				}
	        });
		  viewer.update(element, null);
		}
	  }
}
