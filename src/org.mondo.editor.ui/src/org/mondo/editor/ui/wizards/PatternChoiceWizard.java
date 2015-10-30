package org.mondo.editor.ui.wizards;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.Wizard;
import dslPatterns.PatternMetaModel;

/**
 * Wizard to apply patterns to metamodels.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternChoiceWizard extends Wizard {

  protected PatternChoiceWizardPageOne one;
  private List<PatternMetaModel> metamodels = new ArrayList<PatternMetaModel>();
  private PatternMetaModel patternMMSelected = null;
  private IProject project = null;
  private PatternMetaModel currentMetaModel = null;

  public PatternChoiceWizard(List<PatternMetaModel> metamodels, IProject project, PatternMetaModel currentMetaModel) {
    super();
    this.metamodels = metamodels;
    this.project = project;
    this.currentMetaModel = currentMetaModel;
    setWindowTitle("Pattern Choice");
  }

  @Override
  public void addPages() {
    one = new PatternChoiceWizardPageOne(metamodels, project, currentMetaModel);
    addPage(one);
  }

  @Override
  public boolean performFinish() {
	  patternMMSelected = one.getSelection();
	  return true;
  }

	 
  public PatternMetaModel getPatternMetaModelSelected(){
	  return patternMMSelected;
  }

}
 