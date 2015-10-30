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
 * Page one of the pattern wizard, 
 * this shows the name and description of the selected pattern.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PatternWizardPageOne extends WizardPage {
  private Composite container;
  private Text nameText;
  private String patternNameInstance = "";

  public PatternWizardPageOne(String name, String description, String patternNameInstance) {
    super("Pattern Wizard");
    setTitle("Welcome to "+name+" Wizard");
    setDescription(description==null?"":description);

    this.patternNameInstance = patternNameInstance;
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout();
    container.setLayout(layout);
    layout.numColumns = 2;
    //Label label1 = new Label(container, SWT.NONE);
    //label1.setText("Welcome to "+name+" Wizard.\n"+(description==null?"":description+"\n"));
   
	Label label2 = new Label(container, SWT.NONE);
	label2.setText("Pattern instance name:");

	nameText = new Text(container, SWT.BORDER | SWT.SINGLE);
	nameText.setText(this.patternNameInstance);
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
	 nameText.setLayoutData(gd);

	 setControl(container);
	 setPageComplete(true);

  }
  public String getNameText(){
	  return nameText.getText();
  }
}