package org.mondo.editor.ui.wizards;

import org.eclipse.jface.wizard.Wizard;

/**
 * Wizard to create DSL-tao diagrams from an ecore file.
 * 
 * @author miso  partner AnaPescador
 *
 */
public class EcoreMondoDiagramWizard extends Wizard {

  protected EcoreMondoDiagramWizardPageOne one;
  protected EcoreMondoDiagramWizardPageTwo two;
  protected String diagramName= "";
  public EcoreMondoDiagramWizard(String defaultName) {
    super();
    diagramName= defaultName;
  }

  @Override
  public void addPages() {
    one = new EcoreMondoDiagramWizardPageOne();
    two = new EcoreMondoDiagramWizardPageTwo(diagramName);
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

}
 