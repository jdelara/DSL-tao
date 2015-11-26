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
 * Class to support the edition of EAnnotation keys.
 * 
 * @author miso partner AnaPescador
 *
 */
public class AnnotationKeySupport extends EditingSupport {

	  private final TableViewer viewer;
	  private final CellEditor editor;
	  //private Diagram diagram;

	  public AnnotationKeySupport(TableViewer viewer) {
	    super(viewer);
	    this.viewer = viewer;
	    this.editor = new TextCellEditor(viewer.getTable());
	    //this.diagram = diagram;
	  }

	  @Override
	  protected CellEditor getCellEditor(Object element) {
	    return editor;
	  }

	  @Override
	  protected boolean canEdit(Object element) {
		  return element instanceof EStringToStringMapEntryImpl;  
	  }

	  @Override
	  protected Object getValue(Object element) {
	    return ((EStringToStringMapEntryImpl) element).getKey();
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {		  
		final String oldValue = ((EStringToStringMapEntryImpl) element).getKey();
		if (oldValue.compareTo(String.valueOf(userInputValue))!=0){
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EStringToStringMapEntryImpl) element);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					((EStringToStringMapEntryImpl) element).setKey(String.valueOf(userInputValue));
				}
	      });
		  viewer.update(element, null);
		}
	  }

}
