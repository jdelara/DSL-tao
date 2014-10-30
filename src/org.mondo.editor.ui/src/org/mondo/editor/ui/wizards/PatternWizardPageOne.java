package org.mondo.editor.ui.wizards;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Page one of the pattern wizard, 
 * this shows the name and description of the selected pattern.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternWizardPageOne extends WizardPage {
  private Composite container;
  private String name;
  private String description;

  public PatternWizardPageOne(String name, String description) {
    super("Pattern Wizard");
    setTitle("Pattern Wizard");
    this.name = name;
    this.description = description;
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout();
    container.setLayout(layout);
    layout.numColumns = 1;
    Label label1 = new Label(container, SWT.NONE);
    label1.setText("Welcome to "+name+" Wizard.\n"+(description==null?"":description+"\n"));
   
    setControl(container);
    setPageComplete(true);
  }
}