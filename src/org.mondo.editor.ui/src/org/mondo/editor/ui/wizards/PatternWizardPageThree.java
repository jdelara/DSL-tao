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
import org.eclipse.swt.widgets.Composite;
import org.mondo.editor.ui.utils.PatternUtils;
import org.mondo.editor.ui.utils.dragdrop.DragAndDropUtils;
import org.mondo.editor.ui.utils.dragdrop.MMInterfaceRelDiagram;
import org.mondo.editor.ui.utils.dragdrop.MyDropListener;

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
	  
	  container = new Composite(parent, SWT.NONE);
    
	  FillLayout fillLayout = new FillLayout();
	  fillLayout.marginHeight = 5;
	  fillLayout.marginWidth = 5;
	  container.setLayout( fillLayout );
	  
	  Composite outer = new Composite( container, SWT.BORDER );

	  FormLayout formLayout = new FormLayout();
	  formLayout.marginHeight = 5;
	  formLayout.marginWidth = 5;
	  formLayout.spacing = 5;
	  outer.setLayout( formLayout );
	  
	  Composite innerLeft = new Composite( outer, SWT.BORDER );
	  innerLeft.setLayout( fillLayout);

	  FormData fData = new FormData();
	  fData.top = new FormAttachment( 0 );
	  fData.left = new FormAttachment( 0 );
	  fData.right = new FormAttachment( 30 );
	  fData.bottom = new FormAttachment( 100 );
	  innerLeft.setLayoutData( fData );
    
	  Composite innerRight = new Composite( outer, SWT.BORDER );
	  innerRight.setLayout( fillLayout );

	  fData = new FormData();
	  fData.top = new FormAttachment( 0 );
	  fData.left = new FormAttachment( innerLeft );
	  fData.right = new FormAttachment( 100 );
	  fData.bottom = new FormAttachment( 100 );
	  innerRight.setLayoutData( fData );

	  diagramModel = DragAndDropUtils.createTreeViewerDrag(innerLeft);
   
	  patternTable = DragAndDropUtils.createTableViewerDrop(innerRight, ecoreDiagram, diagramModel, patternName);
    
	  mdl = new MyDropListener(patternTable, ecoreDiagram, null);
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
			  for (ClassInterface ci: metamodel.getClassInterfaces()){
				  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(ci, "");
				  patternRelDiagram.add(relElement);
			  }
			  for (FeatureInterface fi: metamodel.getAttrInterfaces()){
				  if (fi instanceof FeatureType){
					  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(fi, "");
					  patternRelDiagram.add(relElement);
				  }else {//FeatureInstance
					  MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(fi, PatternUtils.getDefaultValue((FeatureInstance)fi));
					  patternRelDiagram.add(relElement);
				  }
			  }
			  for (ReferenceInterface ri: metamodel.getRefInterfaces())	 {   	
				 MMInterfaceRelDiagram relElement = new MMInterfaceRelDiagram(ri, "");
				 patternRelDiagram.add(relElement);
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