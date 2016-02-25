package org.mondo.editor.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.mondo.editor.graphiti.diagram.utils.IResourceUtils;
import org.mondo.editor.ui.utils.patterns.PatternUtils;

import dslPatterns.Category;
import dslPatterns.Pattern;
import dslPatterns.PatternMetaModel;
import dslPatterns.PatternSet;
import dslPatterns.Variant;

public class PatternChoiceWizardPageOne extends WizardPage {

  private Label patternImg ;
  private IProject project = null;
  private List<PatternMetaModel> metamodels;
  private PatternMetaModel currentMetamodel;
  private Label patternSelectedLabel;
  private TreeViewer viewer;
  private TreeObject selected;

  public PatternChoiceWizardPageOne(List<PatternMetaModel> metamodels, IProject project, PatternMetaModel currentMetaModel) {
    super("Pattern Wizard");
    setTitle("Select Pattern");
    this.metamodels = metamodels;
    this.project = project;
    this.currentMetamodel = currentMetaModel;
  }

  @Override
  public void createControl(Composite parent) {
	  FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
	  fillLayout.marginHeight = 0;
	  fillLayout.marginWidth = 0;
	  
	  Composite container = new Composite(parent, SWT.NONE);
	  container.setLayout( fillLayout  );
	  
	  Composite outer = new Composite( container, SWT.NONE);

	  FormLayout formLayout = new FormLayout();
	  formLayout.marginHeight = 0;
	  formLayout.marginWidth = 0;
	  formLayout.spacing = 0;
	  outer.setLayout( formLayout );

	  Composite innerLeft = new Composite( outer, SWT.NONE );
	  innerLeft.setLayout( fillLayout);

	  FormData fData = new FormData();
	  fData.top = new FormAttachment( 0 );
	  fData.left = new FormAttachment( 0 );
	  fData.right = new FormAttachment( 40 );
	  fData.bottom = new FormAttachment( 90 );
	  innerLeft.setLayoutData( fData );
    
	  Composite innerRight = new Composite( outer, SWT.NONE );
	  innerRight.setLayout( fillLayout );

	  fData = new FormData();
	  fData.top = new FormAttachment( 0 );
	  fData.left = new FormAttachment( innerLeft );
	  fData.right = new FormAttachment( 100 );
	  fData.bottom = new FormAttachment( 90 );
	  innerRight.setLayoutData( fData );
	  
	  Composite innerBottom = new Composite( outer, SWT.NONE );
	  innerBottom.setLayout( fillLayout );

	  fData = new FormData();
	  fData.top = new FormAttachment( innerRight );
	  fData.left = new FormAttachment( 0 );
	  fData.right = new FormAttachment( 100 );
	  fData.bottom = new FormAttachment( 100 );
	  innerBottom.setLayoutData( fData );
    
	  Composite drag = new Composite(innerLeft, SWT.NONE);
	  GridLayout gridLayout = new GridLayout();
	  gridLayout.numColumns = 1;
	  gridLayout.marginHeight = gridLayout.marginWidth = 2;
	  gridLayout.horizontalSpacing = gridLayout.verticalSpacing = 0;
	  drag.setLayout(gridLayout);

	  Label treeScopeLabel = new Label(drag, SWT.BORDER);
	  treeScopeLabel.setText("PATTERNS");
	  treeScopeLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	       | GridData.VERTICAL_ALIGN_FILL));
	  treeScopeLabel.setAlignment(SWT.CENTER);
	    
	  viewer = new TreeViewer(drag, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
	        | SWT.SINGLE);
	  viewer.getTree().setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	        | GridData.FILL_VERTICAL));
	  viewer.addSelectionChangedListener(new ISelectionChangedListener() {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			TreeViewer control = (TreeViewer)event.getSource();    
	        ISelection selection = control.getSelection();
	        if (selection != null && selection instanceof IStructuredSelection) {
	        	IStructuredSelection sel = (IStructuredSelection) selection; 
	        	if (sel.getFirstElement() instanceof TreeObject){
	        		TreeObject element = (TreeObject) sel.getFirstElement();
	        		PatternMetaModel pmm = element.getPattern();
	        		if (pmm != null){
	        			patternImg.setImage(PatternUtils.getImagePatternMetamodels(pmm, project));
	        			patternSelectedLabel.setData(pmm);
	        			patternSelectedLabel.setText(element.getName());
	        		}
	        		else if (element.getName().compareToIgnoreCase("No pattern")==0) {
	        			patternImg.setImage(PatternUtils.getImagePatternMetamodels(null, project));
	        			patternSelectedLabel.setData(null);
	        			patternSelectedLabel.setText("No pattern");
	        		}
	        	}	
	        }
		}
	  });
	  
	  viewer.setContentProvider(new ViewContentProvider());
	  viewer.setAutoExpandLevel(2);
	  viewer.setInput(this.metamodels);

	  Composite selection = new Composite(innerRight, SWT.NONE);
	  GridLayout gridLayoutR = new GridLayout();
	  gridLayoutR.numColumns = 1;
	  gridLayoutR.marginHeight = gridLayoutR.marginWidth = 2;
	  gridLayoutR.horizontalSpacing = gridLayoutR.verticalSpacing = 0;
	  selection.setLayout(gridLayoutR);

	  patternSelectedLabel = new Label(selection, SWT.BORDER);
	  patternSelectedLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	      | GridData.VERTICAL_ALIGN_FILL));
	  patternSelectedLabel.setAlignment(SWT.CENTER);
	  
	  patternSelectedLabel.setText("Pattern Selected");
	  patternSelectedLabel.setData(null);

	  patternImg = new Label(selection, SWT.BORDER);
	  patternImg.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	        | GridData.FILL_VERTICAL));
	  patternImg.setAlignment(SWT.CENTER);
    
	  viewer.setSelection(new StructuredSelection(selected));

	  setControl(container);
  	}

  	public  PatternMetaModel getSelection() {     
	  return (PatternMetaModel)patternSelectedLabel.getData();
  	}


  	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		private PatternMetaModel pattern;
		
		public TreeObject(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public void setPattern(PatternMetaModel pattern) {
			this.pattern = pattern;
		}
		public PatternMetaModel getPattern() {
			return pattern;
		}
		
		public String toString() {
			return getName();
		}

		public Object getAdapter(Class key) {
			return null;
		}
		public boolean isLeaf(){
			return !(this instanceof TreeParent);
		}
	}
	
	class TreeParent extends TreeObject {
		private ArrayList<TreeObject> children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList<TreeObject>();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}
		
	class ViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {
		public ViewContentProvider() {
		}

		private TreeParent invisibleRoot;
		private List<PatternMetaModel> patterns;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			this.patterns = (List<PatternMetaModel>)newInput;
			invisibleRoot = null;
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (invisibleRoot==null) initialize();
			return getChildren(invisibleRoot);

		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}

		private void loadTree (TreeParent parent, Category cat, List<PatternMetaModel> patterns){
			TreeParent catParent = new TreeParent(cat.getName());
			for (Category subCat: cat.getSubcategories()){
				loadTree (catParent, subCat, patterns);
			}
			for (Pattern pat : cat.getPatterns()){
				loadTree (catParent, pat,  patterns);
			}

			parent.addChild(catParent);
		}
		private void loadTree (TreeParent parent, Pattern pattern,  List<PatternMetaModel> patterns){
			TreeParent patternParent = new TreeParent(pattern.getName());
			parent.addChild(patternParent);
			TreeObject to = null;
			for (PatternMetaModel pmm: PatternUtils.getPatternMetamodel(pattern)){
				if (!PatternUtils.containsPatternMetamodel(patterns, pmm)){
					if (pmm.eContainer() instanceof Variant){
						////SOLAMENTE AÑADIMOS AQUELLOS QUE NO HAN SIDO RECOMENDADOS.
						to = new TreeObject(((Variant)pmm.eContainer()).getName());
						to.setPattern(pmm);
						patternParent.addChild(to);
						if (PatternUtils.areEqualsPatternMetamodels(pmm, currentMetamodel))
							selected = to;
			    	}
				}
			}	
		}
		
		private void loadTree (TreeParent parent,  List<PatternMetaModel> patterns){
			TreeObject to = null;
			
			for (PatternMetaModel pmm : patterns){
				if (pmm.eContainer() instanceof Variant){
					to = new TreeObject(((Variant)pmm.eContainer()).getName());
					to.setPattern(pmm);
					parent.addChild(to);
					if (PatternUtils.areEqualsPatternMetamodels(pmm, currentMetamodel))
						selected = to;
		    	}
			}
		}

		private void initialize() {			
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IDiagramContainerUI editor = (IDiagramContainerUI)activePage.getActiveEditor();
			
			PatternSet patternModel = PatternUtils.getPatternSetModel(IResourceUtils.getProject(editor.getDiagramTypeProvider().getDiagram().eResource()));	
			if (patternModel != null){
				
				TreeParent rootRecom = new TreeParent("Recommended");
				loadTree (rootRecom,  patterns);
				TreeParent root = new TreeParent("Rest of patterns");
				for (Category cat: patternModel.getCategories()){
					loadTree (root, cat, patterns);
				}
				invisibleRoot = new TreeParent("");
				invisibleRoot.addChild(rootRecom);
				invisibleRoot.addChild(root);
				TreeObject noPattern = new TreeObject("No pattern");
				invisibleRoot.addChild(noPattern);
				if ( selected == null) selected = noPattern;
			}
		}
	}
}
