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
 * Class to support the edition of Features keys.
 * 
 * @author miso partner AnaPescador
 *
 */
public class FeatureKeySupport extends EditingSupport {

	  private final TableViewer viewer;
	  private final CellEditor editor;

	  public FeatureKeySupport(TableViewer viewer) {
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
		  return element instanceof Feature;  
	  }

	  @Override
	  protected Object getValue(Object element) {
	    return ((Feature) element).getKey();
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {		  
		final String oldValue = ((Feature) element).getKey();
		if (oldValue.compareTo(String.valueOf(userInputValue))!=0){
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((Feature) element);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					((Feature) element).setKey(String.valueOf(userInputValue));
				}
	      });
		  viewer.update(element, null);
		}
	  }

}
