package org.mondo.editor.analysis.graphiti.diagram.wizards;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.Wizard;

/**
 * Wizard to create dsl-tao diagrams from an ecore file.
 * 
 * @author miso  partner AnaPescador
 *
 */
public class MindMapMondoDiagramWizard extends Wizard {

  protected MindMapMondoDiagramWizardPageOne one;
  protected MindMapMondoDiagramWizardPageTwo two;
  Map<String, Boolean> options = new HashMap<String, Boolean>();
  protected String diagramName= "";
  public MindMapMondoDiagramWizard(String defaultName) {
    super();
    diagramName= defaultName;
  }

  @Override
  public void addPages() {
    one = new MindMapMondoDiagramWizardPageOne();
    two = new MindMapMondoDiagramWizardPageTwo(diagramName, options);

    addPage(one);
    addPage(two);
  }
  
  
  @Override
  public boolean performFinish() {
	  diagramName = two.getNameText();
	  return true;
  }

	  
  public String getDiagramName(){
	  return diagramName;
  }
  
  public Map<String, Boolean> getOptions(){	  
	  return options;
  }	

}
 