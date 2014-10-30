package org.mondo.editor.graphiti.diagram.properties.edit;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

/**
 * Class to support the edition of EAnnotation values.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AnnotationValueSupport extends EditingSupport {

	 private final TableViewer viewer;
	  private final CellEditor editor;

	  public AnnotationValueSupport(TableViewer viewer) {
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
	    return ((EStringToStringMapEntryImpl) element).getValue();
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {		  
		final String oldValue = ((EStringToStringMapEntryImpl) element).getValue();
		if (oldValue.compareTo(String.valueOf(userInputValue))!=0){
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EStringToStringMapEntryImpl) element);
	        domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					((EStringToStringMapEntryImpl) element).setValue(String.valueOf(userInputValue));
				}
	        });
		  viewer.update(element, null);
		}
	  }

}
