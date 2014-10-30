package org.mondo.editor.ui.wizards;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Group;
import org.mondo.editor.ui.utils.PatternUtils;

import dslPatterns.ComplexFeature;
import dslPatterns.FeatureKind;
import dslPatterns.PatternMetaModel;
import dslPatterns.SimpleFeature;
import dslPatterns.Variant;

/**
 * Page two of the pattern wizard, 
 * this allows the user to select the features of the chosen pattern type.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternWizardPageTwo extends WizardPage {
  private Composite container;
  private Group group;
  private ComplexFeature cf;
  private HashMap<Button, Control> dependencies = new HashMap<Button, Control>();
  private String messageError;
  private List<Button> andButtons = new ArrayList<Button>();
  private Label patternImg ;
  
  private List<PatternMetaModel> metamodels;

  public PatternWizardPageTwo(ComplexFeature cf, List<PatternMetaModel> metamodels) {
    super("Pattern Wizard");
    setTitle("Select Features");
    this.cf = cf;
    this.metamodels = metamodels;
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NONE);
    container.setLayout(new FillLayout()); 
    
    group = new Group(container, SWT.NONE); 
    group.setText("Features"); 
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    group.setLayout(layout); 
    
    patternImg = new Label(container, SWT.NONE);
    
    if (cf.getAndChildren().size() > 0) createButtons(group,cf.getAndChildren(), SWT.CHECK, false, true);
    if (cf.getOrChildren().size() > 0) createButtons(group,cf.getOrChildren(), SWT.CHECK, true, false);
    if (cf.getXorChildren().size() > 0) createButtons(group,cf.getXorChildren(), SWT.RADIO, true, false);

    dialogChanged();
    setControl(container);
  }
  
  /**
   * Recursive method to create controls related to the pattern selected features.
   * @param group - Group of controls
   * @param vars - list of features to create
   * @param style - button type (SWT.CHECK, SWT.RADIO)
   * @param enabled - enabled control or not.
   * @param checked - checked control or not.
   */
  private void createButtons(Group group, EList<Variant> vars, int style, boolean enabled, boolean checked){
	  for (Variant var : vars){
    	Button button = new Button(group, SWT.LEFT | style); 
    	button.setText(var.getName());
    	button.setEnabled(enabled);
    	
    	if ((style == SWT.RADIO) && (var.equals(vars.get(0)))){
    		button.setSelection(true);
    	}
    	else button.setSelection(checked);
    	//AND
    	if ((!enabled)&&(checked))
    		this.andButtons.add(button);

    	
    	if (var instanceof SimpleFeature){ 	
    		Control control;
    		GridData gd = new GridData();
    		gd.widthHint = 100;
    	    switch (((SimpleFeature)var).getFeatureKind()) {
    	    case DOUBLE_FEATURE:
    	    	control = new Text(group, SWT.None);
    	    	((Text)control).setText("0.0");
				break;
			case INTEGER_FEATURE:
				control = new Text(group, SWT.None);
				((Text)control).setText("0");
				break;
			case STRING_FEATURE:
				control = new Text(group, SWT.None);
			break;	
			default:
				control = new Label(group, SWT.None);
				break;
			}
    	    control.setLayoutData(gd);
    	    if (control instanceof Text)
    	    	((Text)control).addModifyListener(new ModifyListener() {
				
				@Override
				public void modifyText(ModifyEvent e) {
					dialogChanged();
				}
			});
    	    control.setData(((SimpleFeature)var).getFeatureKind().toString());
    	    control.setEnabled(button.getSelection());
    	    dependencies.put(button, control);
    	}else {
    		//ComplexFeature
    		Group groupCf = new Group(group, SWT.NONE); 
    	    GridLayout layout = new GridLayout();
    	    layout.numColumns = 2;
    	    groupCf.setLayout(layout);
    	    dependencies.put(button, groupCf);
    	    
    	    //PaternMetamodel
    	    if (((ComplexFeature)var).getMetaModel()!= null){
    	    	button.setData(((ComplexFeature)var).getMetaModel());
    	    	if (button.getSelection()) {
    	    		PatternMetaModel pmm = ((ComplexFeature)var).getMetaModel();
    	    		patternImg.setImage(PatternUtils.getImagePatternMetamodels(pmm));
    	    	}
    	    }
    	    
    	    if (((ComplexFeature)var).getAndChildren().size() > 0) createButtons(groupCf,((ComplexFeature)var).getAndChildren(), SWT.CHECK, false, true);
    	    if (((ComplexFeature)var).getOrChildren().size() > 0) createButtons(groupCf,((ComplexFeature)var).getOrChildren(), SWT.CHECK, button.getSelection(), false);
    	    if (((ComplexFeature)var).getXorChildren().size() > 0) createButtons(groupCf,((ComplexFeature)var).getXorChildren(), SWT.RADIO, button.getSelection(), false);
    	}
    	
	    button.addSelectionListener(new SelectionListener() {	
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (((Button)e.getSource()).getSelection()){ 
					recursiveSetEnabled(dependencies.get(((Button)e.getSource())));		
					
					if (((Button)e.getSource()).getData() instanceof PatternMetaModel) {
	    	    		PatternMetaModel pmm = (PatternMetaModel)((Button)e.getSource()).getData();
	    	    		patternImg.setImage(PatternUtils.getImagePatternMetamodels(pmm));
	    	    	}
					
					
				}else{ 
					recursiveSetUnenabled(dependencies.get(((Button)e.getSource())));
				}
				dialogChanged();
			}	
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	  }
  }
  
  public void recursiveSetUnenabled(Control ctrl) {
	   if (ctrl instanceof Composite) {
	      Composite comp = (Composite) ctrl;
	      for (Control c : comp.getChildren())
	         recursiveSetUnenabled(c);
	   } else {
	      ctrl.setEnabled(false);
	   }
	}
  
  public void recursiveSetEnabled(Control ctrl) {
	   if (ctrl instanceof Composite) {
	      Composite comp = (Composite) ctrl;
	      for (Control c : comp.getChildren())
	         if (c instanceof Button) {	 
	        	 recursiveSetEnabled(c);
	         }
	   } else {
		   if (!(ctrl instanceof Button)) {
			   ctrl.setEnabled(true);
		   }
		   else {  
			   if (!this.andButtons.contains((Button)ctrl))
				   ctrl.setEnabled(true);
			   if (((Button)ctrl).getSelection())
				  recursiveSetEnabled(dependencies.get(((Button)ctrl))); 
		   }	   
	   }
	}

  
  
  /**
   * Method that returns the data provided by the user.
   * @return string list with the values.
   */
  public List<String> getSelected (){
	  return getSelection(container);
  }
  
  /**
   * Recursive method that returns the control fields content.
   * @param ctrl
   * @return string list with the values of the active controls (text and label)
   */
  private  List<String> getSelection(Control ctrl) {     
	  List<String> selected = null;
	  if (ctrl.getEnabled()){
		  if (ctrl instanceof Composite) {
		      Composite comp = (Composite) ctrl;
		      selected = new ArrayList<String>(); 
		      for (Control c : comp.getChildren()){
		    	List<String> ll = getSelection(c);
		      	if (ll != null) selected.addAll(ll);	
		      }
		   } else if (ctrl instanceof Text){		  
			   selected = new ArrayList<String>();
			   selected.add(((Text)ctrl).getText());
		   }  else if (ctrl instanceof Label){
			   selected = new ArrayList<String>();	  
			   selected.add(((Label) ctrl).getText());
		   }  else if (ctrl instanceof Button){
			   if (((Button)ctrl).getSelection()){
				   selected = new ArrayList<String>();	
				   selected.add(((Button) ctrl).getText());  
			   }
		   }
	   }
	  return selected;
	}
  
  
  private  void fillMetamodels(Control ctrl) {     
	  if (ctrl.getEnabled()){
		  if (ctrl instanceof Composite) {
		      Composite comp = (Composite) ctrl;
		      for (Control c : comp.getChildren()){
		    	fillMetamodels(c);
		      }
		   } else if (ctrl instanceof Button){
			   if (((Button)ctrl).getSelection()){
				   if (((Button)ctrl).getData()!=null) {
					   this.metamodels.add((PatternMetaModel)((Button)ctrl).getData());
				   }
			   }
		   }
	   } else if (ctrl instanceof Button){
		   if (this.andButtons.contains(ctrl)){
			   this.metamodels.add((PatternMetaModel)((Button)ctrl).getData());
		   }  
	   }
	}
  
  
  
  /**
   * Method that checks the page content and update its status depending on the result.
   */
  private void dialogChanged() {
	  messageError = null;
	  reviseValidTexts(container);  
	  updateStatus(messageError);
  }

  /**
   * Recursive method that check the page content to know if the filled fields are ok or not. 
   * @param ctrl
   */
  private void reviseValidTexts(Control ctrl) {     
	  if (ctrl.getEnabled() && (messageError==null)){
		  if (ctrl instanceof Composite) {
		      Composite comp = (Composite) ctrl;
		      for (Control c : comp.getChildren())
		         reviseValidTexts(c);
		   } else if (ctrl instanceof Text){
			   if (((String)((Text)ctrl).getData()).compareTo(FeatureKind.DOUBLE_FEATURE.toString())==0){
				  String string = ((Text)ctrl).getText();
				  try{
						Double.parseDouble(string);
				  }catch (NumberFormatException e){
					  messageError = ((Text)ctrl).getText()+" not Valid (double)";
					  ctrl.setFocus();
				  }
			   } else if (((String)((Text)ctrl).getData()).compareTo(FeatureKind.INTEGER_FEATURE.toString())==0){
				  String string = ((Text)ctrl).getText();
				  try{
					  Integer.parseInt(string);
				  }catch (NumberFormatException e){
					  messageError = ((Text)ctrl).getText()+" not Valid (integer)";
					  ctrl.setFocus();
				  }
			   }
		   }    
	   }
	}


  /**
   * Method that updates the page status depending on the message var.
   * @param message - null if the page doesn't have errors.
   */
  private void updateStatus(String message) {
	setErrorMessage(message);
	setPageComplete(message == null);
  }
  
  	private boolean areEquals(List<PatternMetaModel> metamodels, List<PatternMetaModel> metamodelsCopy){
	  boolean ok = metamodels.size()== metamodelsCopy.size();
	  for (PatternMetaModel pmm : metamodels){
		  if (!existsElement(metamodelsCopy, pmm)) return false;
	  }
	  return ok;
  	}
  
  	private boolean existsElement(List<PatternMetaModel> metamodels,PatternMetaModel element){
  		for (PatternMetaModel pmm : metamodels){
  		  if (pmm.equals(element)) return true;
  		}
  		return false;
  	}

  
	@Override
	public IWizardPage getNextPage() {
		List<PatternMetaModel> metamodelsCopy = new LinkedList<PatternMetaModel>();
		for (PatternMetaModel pmm : metamodels){
			metamodelsCopy.add(pmm);
		}
		metamodels.clear();
		fillMetamodels(container);
		PatternWizardPageThree page = ((PatternWizard)getWizard()).three;
		if (!areEquals(metamodels, metamodelsCopy))page.onEnterPage();
		return page;
	}
  
}
