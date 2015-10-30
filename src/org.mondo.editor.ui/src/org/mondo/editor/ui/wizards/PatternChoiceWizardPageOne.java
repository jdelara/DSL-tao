package org.mondo.editor.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IProject;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.mondo.editor.ui.utils.patterns.PatternUtils;
import dslPatterns.PatternMetaModel;
import dslPatterns.Variant;

public class PatternChoiceWizardPageOne extends WizardPage {
  private Composite container;
  private Group group;
  private Label patternImg ;
  private IProject project = null;
  private List<PatternMetaModel> metamodels;
  private PatternMetaModel currentMetamodel;

  public PatternChoiceWizardPageOne(List<PatternMetaModel> metamodels, IProject project, PatternMetaModel currentMetaModel) {
    super("Pattern Wizard");
    setTitle("Select Pattern");
    this.metamodels = metamodels;
    this.project = project;
    this.currentMetamodel = currentMetaModel;
  }

  @Override
  public void createControl(Composite parent) {
    	  
	container = new Composite(parent, SWT.NONE);
    GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
    container.setLayout(new GridLayout(2,false));//2 
    container.setLayoutData(gd);
    
    group = new Group(container, SWT.NONE); 
    group.setText("Patterns"); 
    group.setLayout(new GridLayout(1,false));
    GridData gd2 = new GridData(SWT.FILL, SWT.FILL, false, false);
    group.setLayoutData(gd2);

    Group group2 = new Group(container, SWT.NONE); 
    group2.setLayout(new GridLayout());
    patternImg = new Label(group2, SWT.CENTER);
    
    boolean isCurrentMetamodel = false;
    for (PatternMetaModel pmm : this.metamodels){
    	Button button = new Button(group, SWT.LEFT | SWT.RADIO); 
    	
    	if (pmm.eContainer() instanceof Variant){
        	button.setText(((Variant)pmm.eContainer()).getName());
    	} 
    	button.setData(pmm);
    	button.setSelection(areEqualsPatternMetamodels(currentMetamodel, pmm));
		if (areEqualsPatternMetamodels(currentMetamodel, pmm)){
			isCurrentMetamodel = true;
			patternImg.setImage(PatternUtils.getImagePatternMetamodels(pmm, project));
		}

    	button.setEnabled(true);
		button.addSelectionListener(new SelectionListener() {	
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (((Button)e.getSource()).getSelection()){ 					
				if (((Button)e.getSource()).getData() instanceof PatternMetaModel) {
	    	   		PatternMetaModel pmm = (PatternMetaModel)((Button)e.getSource()).getData();
	    	    	patternImg.setImage(PatternUtils.getImagePatternMetamodels(pmm, project));
				}
			}	
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
    }
    
    Button button = new Button(group, SWT.LEFT | SWT.RADIO); 
    if ((currentMetamodel == null) || (! isCurrentMetamodel)) {
    	patternImg.setImage(PatternUtils.getImagePatternMetamodels(null, project));
    	button.setSelection(true);
    }
    button.setText("No pattern");
    button.addSelectionListener(new SelectionListener() {	
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (((Button)e.getSource()).getSelection()){ 					
	    	    patternImg.setImage(PatternUtils.getImagePatternMetamodels(null, project));
			}	
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
        
    setControl(container);
  }

  private boolean areEqualsPatternMetamodels (PatternMetaModel pmm1, PatternMetaModel pmm2){
	  if ((pmm1 != null) && (pmm2 != null)){
		  String name1= ((Variant)pmm1.eContainer()).getName();
		  String name2 = ((Variant)pmm2.eContainer()).getName();
		  return name1.equals(name2);
		  
	  } else return pmm1 == pmm2;
  }
  
  public  PatternMetaModel getSelection() {     
	  
	  for (Control control : group.getChildren()){
		  if (control instanceof Button)
			  if (((Button)control).getSelection()) 
			  	return (PatternMetaModel)((Button)control).getData();
	  }		    
	  return null;
	}
}
