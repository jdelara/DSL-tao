package org.mondo.editor.ui.utils.services;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

import dslPatterns.Pattern;

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
	  private final List<Pattern> allPatterns;

	  public ActivateSupport(TableViewer viewer, Resource intModel, List<Pattern> allPatterns) {
	    super(viewer);
	    this.viewer = viewer;
	    String[] ops = new String[]{"Yes", "No"};
	    this.editor = new ComboBoxCellEditor(this.viewer.getTable(), ops);
	    this.intModel = intModel;
	    this.allPatterns = allPatterns;
	  }

	  @Override
	  protected CellEditor getCellEditor(Object element) {
	    return editor;
	  }

	  @Override
	  protected boolean canEdit(Object element) {
		  return (((PatternServiceInfo)element).getMissing().isEmpty() && (intModel != null));  
	  }

	  @Override
	  protected Object getValue(Object element) {
		  return ((((PatternServiceInfo)element).getMissing().isEmpty()?(((PatternServiceInfo)element).isActivated()?0:1):""));
	  }

	  @Override
	  protected void setValue(final Object element, final Object userInputValue) {		  
		if (userInputValue instanceof Integer){
			final Integer choice = (Integer)userInputValue;
		
			if (((PatternServiceInfo)element).isActivated()!=(choice==0)){
			
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(((PatternServiceInfo) element).getServiceInstance());
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						if (choice == 0){
							((PatternServiceInfo)element).setActivated(true);
							PatternUtils.addCheckActivableServiceForUpdates((List<PatternServiceInfo>)viewer.getInput(), ((PatternServiceInfo)element).getPattern());
						} else {
							((PatternServiceInfo)element).setActivated(false);
							if (intModel!= null)PatternUtils.deleteCheckActivableServiceForUpdates((List<PatternServiceInfo>)viewer.getInput(), (Resource) intModel, allPatterns);
						}
						viewer.refresh();
					}
		      });
			}
		}
	  }
}
