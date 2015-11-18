package org.mondo.editor.analysis.graphiti.diagram.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Page one of the wizard to create a DSL-tao diagram from an ecore.
 * It's a simple wizard page.
 * 
 * @author miso  partner AnaPescador
 *
 */
public class MindMapMondoDiagramWizardPageOne extends WizardPage {
  private Composite container;

  public MindMapMondoDiagramWizardPageOne() {
    super("DSL-tao Diagram Wizard");
    setTitle("DSL-tao Diagram Wizard");
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout();
    container.setLayout(layout);
    layout.numColumns = 1;
    Label label1 = new Label(container, SWT.NONE);
    label1.setText("Welcome to DSL-tao Diagram Wizard\n");
   
    setControl(container);
    setPageComplete(true);
  }
}