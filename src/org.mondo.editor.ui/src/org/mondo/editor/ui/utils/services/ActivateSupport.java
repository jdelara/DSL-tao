package org.mondo.editor.ui.utils.services;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.mondo.editor.ui.utils.PatternUtils;

/**
 * Class to support the edition of Activation combo-box.
 * 
 * @author miso partner AnaPescador
 *
 */
public class ActivateSupport extends EditingSupport {

	  private final TableViewer viewer;
	  private  final CellEditor editor;
	  private final Resource intModel;

	  public ActivateSupport(TableViewer viewer, Resource intModel) {
	    super(viewer);
	    this.viewer = viewer;
	    //this.editor = new TextCellEditor(this.viewer.getTable());
	    String[] ops = new String[]{"Yes", "No"};
	    this.editor = new ComboBoxCellEditor(this.viewer.getTable(), ops);
	    this.intModel = intModel;
	  }

	  @Override
	  protected CellEditor getCellEditor(Object element) {
	    return editor;
	  }

	  @Override
	  protected boolean canEdit(Object element) {
		  return ((PatternServiceInfo)element).getMissing().isEmpty();  
	  }

	  @Override
	  protected Object getValue(Object element) {
		  return ((((PatternServiceInfo)element).getMissing().isEmpty()?(((PatternServiceInfo)element).isActivated()?0:1):""));
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {		  
		if (userInputValue instanceof Integer){
			Integer choice = (Integer)userInputValue;
			if (choice == 0){
				((PatternServiceInfo)element).setActivated(true);
				PatternUtils.addCheckActivableServiceForUpdates((List<PatternServiceInfo>)viewer.getInput(), ((PatternServiceInfo)element).getPattern());
			} else {
				((PatternServiceInfo)element).setActivated(false);
				if (intModel!= null)PatternUtils.deleteCheckActivableServiceForUpdates((List<PatternServiceInfo>)viewer.getInput(), (Resource) intModel);
			}
			viewer.refresh();
		}
	  }

}
