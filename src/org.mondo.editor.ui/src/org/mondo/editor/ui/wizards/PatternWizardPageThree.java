package org.mondo.editor.ui.wizards;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.mondo.editor.ui.utils.dragdrop.DragAndDropUtils;
import org.mondo.editor.ui.utils.dragdrop.MyDropListener;
import org.mondo.editor.ui.utils.patterns.MMInterfaceRelDiagram;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

import dslPatterns.ClassInterface;
import dslPatterns.FeatureInstance;
import dslPatterns.FeatureInterface;
import dslPatterns.FeatureType;
import dslPatterns.PatternMetaModel;
import dslPatterns.ReferenceInterface;

/**
 * Page three of the pattern wizard, 
 * this allows to apply pattern elements to the metamodel elements of the diagram.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternWizardPageThree extends WizardPage {
  private Composite container;
  private TreeViewer diagramModel;
  private EPackage ecoreDiagram;
  private TreeViewer patternTable;
  private List<PatternMetaModel> metamodels;
  private List<MMInterfaceRelDiagram> patternRelDiagram;
  private MyDropListener mdl ;
  private String patternName;
  

  public PatternWizardPageThree(EPackage ecoreDiagram, List<PatternMetaModel> metamodels, List<MMInterfaceRelDiagram> patternRelDiagram, String patternName) {
    super("Pattern Wizard");
    setTitle("Pattern Wizard");
    setDescription("Drag the diagram eObjects onto the pattern elements.");
    this.ecoreDiagram = ecoreDiagram;
    this.metamodels = metamodels;
    this.patternRelDiagram = patternRelDiagram;
    this.patternName = patternName;
    
  }

  @Override
  public void createControl(Composite parent) {
	  
	  FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
	  fillLayout.marginHeight = 0;
	  fillLayout.marginWidth = 0;
	  
	  container = new Composite(parent, SWT.NONE);
	  container.setLayout( fillLayout  );
	  
	  Composite outer = new Composite( container, SWT.NONE);

	  FormLayout formLayout = new FormLayout();
	  formLayout.marginHeight = 0;
	  formLayout.marginWidth = 0;
	  formLayout.spacing = 0;
	  outer.setLayout( formLayout );

	  Composite innerLeft = new Composite( outer, SWT.NONE );
	  innerLeft.setLayout( fillLayout);

	  FormData fData = new FormData();
	  fData.top = new FormAttachment( 0 );
	  fData.left = new FormAttachment( 0 );
	  fData.right = new FormAttachment( 30 );
	  fData.bottom = new FormAttachment( 90 );
	  innerLeft.setLayoutData( fData );
    
	  Composite innerRight = new Composite( outer, SWT.NONE );
	  innerRight.setLayout( fillLayout );

	  fData = new FormData();
	  fData.top = new FormAttachment( 0 );
	  fData.left = new FormAttachment( innerLeft );
	  fData.right = new FormAttachment( 100 );
	  fData.bottom = new FormAttachment( 90 );
	  innerRight.setLayoutData( fData );
	  
	  Composite innerBottom = new Composite( outer, SWT.NONE );
	  innerBottom.setLayout( fillLayout );

	  fData = new FormData();
	  fData.top = new FormAttachment( innerRight );
	  fData.left = new FormAttachment( 0 );
	  fData.right = new FormAttachment( 100 );
	  fData.bottom = new FormAttachment( 100 );
	  innerBottom.setLayoutData( fData );
	 
	  Composite dragMode = new Composite(innerBottom, SWT.NONE);
	  GridLayout gridLayout = new GridLayout();
	  gridLayout.numColumns = 3;
	  dragMode.setLayout(gridLayout);

	  Label labelDragMode = new Label(dragMode, SWT.NONE);
	  labelDragMode.setText("Drag Mode:  ");
	  
	  Button buttonReplace = new Button(dragMode, SWT.LEFT | SWT.RADIO); 
	  buttonReplace.setText("Replace element");
	  buttonReplace.setSelection(true);
  	  
  	  Button buttonDuplicate = new Button(dragMode, SWT.LEFT | SWT.RADIO); 
  	  buttonDuplicate.setText("Duplicate element");

	  diagramModel = DragAndDropUtils.createTreeViewerDrag(innerLeft);
   
	  patternTable = DragAndDropUtils.createTableViewerDrop(innerRight, ecoreDiagram, diagramModel, patternName);
    
	  mdl = new MyDropListener(patternTable, ecoreDiagram, null, buttonReplace);
	  int operations = DND.DROP_COPY| DND.DROP_MOVE;
	  Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
	  patternTable.addDropSupport(operations, transferTypes, mdl);
    
	  List<ENamedElement> dml = new ArrayList<>();
	  if (this.ecoreDiagram != null) {    	 	
    	for (EClassifier classif : ecoreDiagram.getEClassifiers()){
    		if (classif instanceof EClass){   			
    			dml.add(classif);				
    		}
    	}
	  }
	  diagramModel.setInput(dml);
	  setControl(container);
	  setPageComplete(true);
  }
  
  void onEnterPage(){
	  if (metamodels != null){    	 		  
		  patternRelDiagram.clear();
		  for (PatternMetaModel metamodel: metamodels){
			  if (metamodel!=null){
				  for (ClassInterface ci: metamodel.getClassInterfaces()){ 
					  if (PatternUtils.existsEClass(ci)){
						  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(ci, "", patternRelDiagram);
						  patternRelDiagram.add(relElement);
					  }
				  }
				  for (FeatureInterface fi: metamodel.getAttrInterfaces()){  
					  if (PatternUtils.existsEAttribute(fi))
						  if (fi instanceof FeatureType){
							  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(fi, "", patternRelDiagram);
							  patternRelDiagram.add(relElement);
						  }else {//FeatureInstance
							  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(fi, PatternUtils.getDefaultValue((FeatureInstance)fi), patternRelDiagram);
							  patternRelDiagram.add(relElement);
						  }
				  }
				  for (ReferenceInterface ri: metamodel.getRefInterfaces())	 {   	
					  if (PatternUtils.existsEReference(ri)){
						  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(ri, "", patternRelDiagram);
						  patternRelDiagram.add(relElement);
					  }
				  }
		    	}
		  }
		  patternTable.setInput(patternRelDiagram); 
		  
		  mdl.setContent(patternRelDiagram);  
	    }
  }
  
  /**
   * Method that returns the data selected by the user.
   * @return List of MMInterfaceRelDiagram
   */
  @SuppressWarnings("unchecked")
  public List<MMInterfaceRelDiagram>  getSelected (){
	  return (List<MMInterfaceRelDiagram>) patternTable.getInput();
  }

  
}