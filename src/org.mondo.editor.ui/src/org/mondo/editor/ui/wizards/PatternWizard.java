package org.mondo.editor.ui.wizards;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.Wizard;
import org.mondo.editor.ui.utils.dragdrop.MMInterfaceRelDiagram;

import dslPatterns.Pattern;
import dslPatterns.PatternMetaModel;
import dslPatterns.PatternMetaModelAttached;

/**
 * Wizard to apply patterns to metamodels.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternWizard extends Wizard {

  protected PatternWizardPageOne one;
  protected PatternWizardPageTwo two;
  protected PatternWizardPageThree three;
  private Pattern pattern;
  private EPackage ecoreDiagram = null;
  private List<PatternMetaModel> metamodels = new ArrayList<PatternMetaModel>();
  private List<PatternMetaModelAttached> metamodelsAt;
  private List<MMInterfaceRelDiagram> patternRelDiagram;
  private IProject project = null;

  public PatternWizard(Pattern pattern, EPackage ecoreDiagram, List<MMInterfaceRelDiagram> patternRelDiagram, List<PatternMetaModelAttached> attachs, IProject project) {
    super();
    setNeedsProgressMonitor(true);
    this.pattern = pattern;
    this.ecoreDiagram = ecoreDiagram;
    this.patternRelDiagram = patternRelDiagram;
    this.project = project;
    this.metamodelsAt = attachs;
  }

  @Override
  public void addPages() {
    one = new PatternWizardPageOne(pattern.getName(), pattern.getDescription());
    two = new PatternWizardPageTwo(pattern.getRootVariant(), metamodels, project,metamodelsAt);
    three = new PatternWizardPageThree(ecoreDiagram, metamodels, patternRelDiagram, pattern.getName());
    addPage(one);
    addPage(two);
    addPage(three);
  }

	@Override
	public boolean performFinish() {
		return true;
	}

}
 