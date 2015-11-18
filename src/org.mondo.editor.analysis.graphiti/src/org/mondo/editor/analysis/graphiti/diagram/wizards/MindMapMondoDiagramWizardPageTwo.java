package org.mondo.editor.analysis.graphiti.diagram.wizards;

import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.mondo.editor.analysis.graphiti.diagram.utils.TransformationOption;
import org.mondo.editor.analysis.graphiti.diagram.utils.TransformationUtils;
import org.osgi.framework.Bundle;

/**
 * Page two of the wizard to create a DSL-tao diagram. 
 * This asks for the diagram name.
 * 
 * @author miso partner AnaPescador
 *
 */
public class MindMapMondoDiagramWizardPageTwo extends WizardPage {
  private Text nameText;
  private Composite container;
  private String defaultName = "";
  private Map<String,Boolean> options = null;
  private Label image;

  public MindMapMondoDiagramWizardPageTwo(String name, Map<String, Boolean> options) {
    super("Diagram Wizard");
    setTitle("Customize your meta-model");
    this.defaultName = name;
    this.options = options;
  }

  @Override
  public void createControl(Composite parent) {
	container = new Composite(parent, SWT.NONE);
	GridLayout layout = new GridLayout(4, false);
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
	gd.horizontalSpan = 4;
	nameText.setLayoutData(gd);
	
	GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
	gd2.horizontalSpan = 3;
	
	Label label2 = new Label(container, SWT.NONE);
	label2.setText("General rules:");
	label2.setLayoutData(gd);
		
	Button bNamesToSingular = new Button(container, SWT.CHECK);
	bNamesToSingular.setText(TransformationUtils.IDEA_TO_SINGULAR.getText());
	bNamesToSingular.setSelection(true);
	bNamesToSingular.setData(TransformationUtils.IDEA_TO_SINGULAR);
	options.put(TransformationUtils.IDEA_TO_SINGULAR.getKey(), new Boolean(true));

	bNamesToSingular.setLayoutData(gd2);
	bNamesToSingular.addSelectionListener(listenerActiveOption);
	bNamesToSingular.setEnabled(true);
	bNamesToSingular.addMouseTrackListener(listenerChangeImage);
	
	GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
	gd3.verticalSpan = 8;
	image = new Label(container, SWT.CENTER);
	image.setText("imagen");
	image.setLayoutData(gd3);
	
	Bundle plugin = Platform.getBundle("org.mondo.editor.analysis.graphiti");
    URL url = FileLocator.find(plugin, new Path(((TransformationOption)bNamesToSingular.getData()).getImgPath()), null);
	ImageDescriptor desc =  ImageDescriptor.createFromURL(url);
	
	if (desc != null)  
		image.setImage(desc.createImage());

	Label labelFeatures = new Label(container, SWT.NONE);
	labelFeatures.setText("Features to:  ");
	labelFeatures.setData(TransformationUtils.FEATURE_TO);
	labelFeatures.addMouseTrackListener(listenerChangeImage);
	options.put(TransformationUtils.FEATURE_TO.getKey(), new Boolean(true));
 
	Button buttonFeatureToAttributes = new Button(container, SWT.LEFT | SWT.RADIO); 
	buttonFeatureToAttributes.setText("attributes");
	buttonFeatureToAttributes.setSelection(true);
	buttonFeatureToAttributes.setData(TransformationUtils.FEATURE_TO);
	buttonFeatureToAttributes.addSelectionListener(listenerActiveOption);
	buttonFeatureToAttributes.addMouseTrackListener(listenerChangeImage);
 
	Button buttonFeatureToClasses = new Button(container, SWT.LEFT | SWT.RADIO); 
	buttonFeatureToClasses.setText("classes");
	buttonFeatureToClasses.setData(TransformationUtils.FEATURE_TO);
	buttonFeatureToClasses.addMouseTrackListener(listenerChangeImage);

	Button bContainment = new Button(container, SWT.CHECK);
	bContainment.setText(TransformationUtils.BIDIRECTIONAL_CONTAINMENT.getText());
	bContainment.setData(TransformationUtils.BIDIRECTIONAL_CONTAINMENT);
	options.put(TransformationUtils.BIDIRECTIONAL_CONTAINMENT.getKey(), new Boolean(true));

	bContainment.setLayoutData(gd2);
	bContainment.setEnabled(true);
	bContainment.setSelection(true);
	bContainment.addSelectionListener(listenerActiveOption);
	bContainment.addMouseTrackListener(listenerChangeImage);

	Button bOptionalReference = new Button(container, SWT.CHECK);
	bOptionalReference.setText(TransformationUtils.OPTIONAL_REFERENCE.getText());
	bOptionalReference.setData(TransformationUtils.OPTIONAL_REFERENCE);
	options.put(TransformationUtils.OPTIONAL_REFERENCE.getKey(), new Boolean(true));

	bOptionalReference.setLayoutData(gd2);
	bOptionalReference.setEnabled(true);
	bOptionalReference.setSelection(true);
	bOptionalReference.addSelectionListener(listenerActiveOption);
	bOptionalReference.addMouseTrackListener(listenerChangeImage);

	Button bMultiplicityReference = new Button(container, SWT.CHECK);
	bMultiplicityReference.setText(TransformationUtils.MULTIPLICITY.getText());
	bMultiplicityReference.setData(TransformationUtils.MULTIPLICITY);
	options.put(TransformationUtils.MULTIPLICITY.getKey(), new Boolean(true));

	bMultiplicityReference.setLayoutData(gd2);
	bMultiplicityReference.setEnabled(true);
	bMultiplicityReference.setSelection(true);
	bMultiplicityReference.addSelectionListener(listenerActiveOption);
	bMultiplicityReference.addMouseTrackListener(listenerChangeImage);

	Button bInheritance = new Button(container, SWT.CHECK);
	bInheritance.setText(TransformationUtils.INHERITANCE.getText());
	bInheritance.setData(TransformationUtils.INHERITANCE);
	options.put(TransformationUtils.INHERITANCE.getKey(), new Boolean(true));

	bInheritance.setLayoutData(gd2);
	bInheritance.setEnabled(true);
	bInheritance.setSelection(true);
	bInheritance.addSelectionListener(listenerActiveOption);
	bInheritance.addMouseTrackListener(listenerChangeImage);

	Button bNote = new Button(container, SWT.CHECK);
	bNote.setText(TransformationUtils.NOTE_TO_ANNOTATION.getText());
	bNote.setData(TransformationUtils.NOTE_TO_ANNOTATION);
	options.put(TransformationUtils.NOTE_TO_ANNOTATION.getKey(), new Boolean(true));
	
	bNote.setLayoutData(gd2);
	bNote.setEnabled(true);
	bNote.setSelection(true);
	bNote.addSelectionListener(listenerActiveOption);
	bNote.addMouseTrackListener(listenerChangeImage);

	setControl(container);
	setPageComplete(true);
  }

  public String getNameText(){
	  return nameText.getText();
  }
  
  private SelectionListener listenerActiveOption = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			Button button = (Button)e.getSource();
			if (button.getData() instanceof TransformationOption){
				TransformationOption to = (TransformationOption)button.getData();
				options.replace(to.getKey(), (Boolean) button.getSelection());
			}
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	};
	
	private MouseTrackListener listenerChangeImage = new MouseTrackListener() {
		
		@Override
		public void mouseHover(MouseEvent e) {		
		}
		
		@Override
		public void mouseExit(MouseEvent e) {
		}
		
		@Override
		public void mouseEnter(MouseEvent e) {	
			if (e.getSource() instanceof Control){
				Control button = (Control)e.getSource();
			
				if (button.getData() instanceof TransformationOption){
					TransformationOption to = (TransformationOption)button.getData();
					
					Bundle plugin = Platform.getBundle("org.mondo.editor.analysis.graphiti");
					URL url = FileLocator.find(plugin, new Path(to.getImgPath()), null);
					ImageDescriptor desc =  ImageDescriptor.createFromURL(url);
					
					if (desc != null)  
						image.setImage(desc.createImage());
				}
			}
		}
	};
}
