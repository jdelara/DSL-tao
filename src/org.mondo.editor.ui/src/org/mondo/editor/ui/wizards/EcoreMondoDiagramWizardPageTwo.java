package org.mondo.editor.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Page two of the wizard to create a DSL-tao diagram. 
 * This asks for the diagram name.
 * 
 * @author miso partner AnaPescador
 *
 */
public class EcoreMondoDiagramWizardPageTwo extends WizardPage {
  private Text nameText;
  private Composite container;
  private String defaultName = "";

  public EcoreMondoDiagramWizardPageTwo(String name) {
    super("Diagram Wizard");
    setTitle("Customize your meta-model");
    this.defaultName = name;
  }

  @Override
  public void createControl(Composite parent) {
	container = new Composite(parent, SWT.NONE);
	GridLayout layout = new GridLayout(3, false);
	container.setLayout(layout);

	Label label1 = new Label(container, SWT.NONE);
	label1.setText("Diagram name:");
	
	nameText = new Text(container, SWT.BORDER | SWT.SINGLE);
	nameText.setText(this.defaultName);
	nameText.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (!nameText.getText().isEmpty()) {
			          setPageComplete(true);
			    }else setPageComplete(false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}	
	});
	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	gd.horizontalSpan = 2;
	nameText.setLayoutData(gd);
	  
	setControl(container);
	setPageComplete(true);
  }

  public String getNameText(){
	  return nameText.getText();
  }

}
