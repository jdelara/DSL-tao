package org.mondo.editor.graphiti.diagram.properties;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.CreateEAnnotationCustomFeature;
import org.mondo.editor.graphiti.diagram.CreateEAnnotationEntryFeature;
import org.mondo.editor.graphiti.diagram.CreateEAnnotationFeature;
import org.mondo.editor.graphiti.diagram.DeleteEAnnotationFeature;
import org.mondo.editor.graphiti.diagram.utils.ModelUtils;
import org.mondo.editor.graphiti.diagram.utils.PropertiesUtils;

/**
 * Section to modify EAnnotations properties.
 * 
 * @author miso partner AnaPescador
 * 
 */
public class EAnnotationSection extends GFPropertySection implements ITabbedPropertyConstants {
	
	private TableViewer viewerSources;
	private TableViewer viewerValues;
	private Button btnDeleteAnnotation;
	private Button btnDeleteValue;
	
	private Composite compositeParent; //Eopposite
	private Composite compositeOP = null;
	private TableViewer viewerSourcesOP = null;
	private TableViewer viewerValuesOP = null;
	private Button btnDeleteAnnotationOP = null;
	private Button btnDeleteValueOP = null;
	 
	private final int MARGEN_TOP = 10;
	private final int ALTO_GRUPO = 220;
	private final int ANCHO_GRUPO = 550;
	private final int ALTO_BTN = 30;
	private final int ANCHO_BTN = 60;
	private final int SEPARACION_VERTICAL = 30;
	private final int MARGEN_IZQ = 15;
	private final int ALTO_LST = 180;
	private final int ANCHO_LST = 300;


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		compositeParent = parent;
		compositeParent.setLayout(new FillLayout(SWT.VERTICAL));

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(compositeParent);

		Group grpValues = factory.createGroup(composite, "Values: ");
		grpValues.redraw();
		FormData data = new FormData();
		data.left = new FormAttachment(0, ANCHO_GRUPO);
		data.top = new FormAttachment(0, MARGEN_TOP);
		data.width = ANCHO_GRUPO*3/2;
		data.height = ALTO_GRUPO;
		grpValues.setLayoutData(data);
		grpValues.setLayout(null);
		viewerValues = PropertiesUtils.createViewerValues(grpValues);
		
		Button btnAddValue = factory.createButton(grpValues, "Add", SWT.PUSH);
		btnAddValue.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4, ANCHO_BTN, ALTO_BTN);
			
		btnDeleteValue = factory.createButton(grpValues, "Delete", SWT.PUSH);
		btnDeleteValue.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4+ALTO_BTN*3/2, ANCHO_BTN, ALTO_BTN);

        Group grpAnnotations = factory.createGroup(composite, "Annotations: ");
		FormData data2 = new FormData();
		data2.left = new FormAttachment(0, 0);
		data2.right = new FormAttachment(grpValues, -HSPACE);
		data2.top = new FormAttachment(grpValues, 0, SWT.CENTER);
		data2.width = ANCHO_GRUPO;
		data2.height = ALTO_GRUPO;
		grpAnnotations.setLayoutData(data2);
		grpAnnotations.setLayout(null);
		
		Button btnAddAnnotation = factory.createButton(grpAnnotations, "Add", SWT.PUSH);
		btnAddAnnotation.setBounds(MARGEN_IZQ*2+ANCHO_LST,SEPARACION_VERTICAL+ALTO_LST/4, ANCHO_BTN, ALTO_BTN);
		btnAddAnnotation.addSelectionListener(listenerAddSourceAction);
		
		btnDeleteAnnotation = factory.createButton(grpAnnotations, "Delete", SWT.PUSH);
 		btnDeleteAnnotation.setBounds(MARGEN_IZQ*2+ANCHO_LST,SEPARACION_VERTICAL+ALTO_LST/4+ALTO_BTN*3/2, ANCHO_BTN, ALTO_BTN);
 		

		viewerSources = PropertiesUtils.createViewerSources(grpAnnotations);
        viewerSources.addSelectionChangedListener(new SelectionAnnotationChange(viewerValues));
        
		btnAddValue.addSelectionListener(new AddValueAction(viewerSources, viewerValues));
		btnDeleteValue.addSelectionListener(new DeleteValueAction(viewerSources, viewerValues));
        btnDeleteAnnotation.addSelectionListener(new DeleteAnnotationAction(viewerSources));

	}
	
	private void createControlsOpposite(){
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		compositeOP = factory.createFlatFormComposite(compositeParent);

		Group grpValues = factory.createGroup(compositeOP, "Values: ");
		grpValues.redraw();
		FormData data = new FormData();
		data.left = new FormAttachment(0, ANCHO_GRUPO);
		data.top = new FormAttachment(0, MARGEN_TOP);
		data.width = ANCHO_GRUPO*3/2;
		data.height = ALTO_GRUPO;
		grpValues.setLayoutData(data);
		grpValues.setLayout(null);
		viewerValuesOP = PropertiesUtils.createViewerValues(grpValues);
		
		Button btnAddValue = factory.createButton(grpValues, "Add", SWT.PUSH);
		btnAddValue.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4, ANCHO_BTN, ALTO_BTN);

		btnDeleteValueOP = factory.createButton(grpValues, "Delete", SWT.PUSH);
		btnDeleteValueOP.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4+ALTO_BTN*3/2, ANCHO_BTN, ALTO_BTN);
		
        Group grpAnnotations = factory.createGroup(compositeOP, "Annotations Opposite: ");
		FormData data2 = new FormData();
		data2.left = new FormAttachment(0, 0);
		data2.right = new FormAttachment(grpValues, -HSPACE);
		data2.top = new FormAttachment(grpValues, 0, SWT.CENTER);
		data2.width = ANCHO_GRUPO;
		data2.height = ALTO_GRUPO;
		grpAnnotations.setLayoutData(data2);
		grpAnnotations.setLayout(null);
		
		Button btnAddAnnotation = factory.createButton(grpAnnotations, "Add", SWT.PUSH);
		btnAddAnnotation.setBounds(MARGEN_IZQ*2+ANCHO_LST,SEPARACION_VERTICAL+ALTO_LST/4, ANCHO_BTN, ALTO_BTN);
		btnAddAnnotation.addSelectionListener(listenerAddSourceActionOP);
		
		btnDeleteAnnotationOP = factory.createButton(grpAnnotations, "Delete", SWT.PUSH);
 		btnDeleteAnnotationOP.setBounds(MARGEN_IZQ*2+ANCHO_LST,SEPARACION_VERTICAL+ALTO_LST/4+ALTO_BTN*3/2, ANCHO_BTN, ALTO_BTN);

		viewerSourcesOP = PropertiesUtils.createViewerSources(grpAnnotations);
        viewerSourcesOP.addSelectionChangedListener(new SelectionAnnotationChange(viewerValuesOP));
        
		btnAddValue.addSelectionListener(new AddValueAction(viewerSourcesOP, viewerValuesOP));
		btnDeleteValueOP.addSelectionListener(new DeleteValueAction(viewerSourcesOP, viewerValuesOP));
 		btnDeleteAnnotationOP.addSelectionListener(new DeleteAnnotationAction(viewerSourcesOP));
		
	}
	
	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	    	Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	    	
	        if (bo == null)
	            return;
	       
	        viewerSources.setInput(((EModelElement)bo).getEAnnotations());
	        if (!((EModelElement)bo).getEAnnotations().isEmpty())viewerSources.setSelection(new StructuredSelection(viewerSources.getElementAt(0)),true);
	        
	        viewerSources.refresh();

	        //Crear aqui las anotaciones de eopposite porque solo queremos que aparezca cuando sea una referencia y tiene eopposite.	        
	        if (bo instanceof EReference){
	        	if (compositeOP == null)
	        		createControlsOpposite();
	        	if (((EReference)bo).getEOpposite()!= null) {
	        		viewerSourcesOP.setInput(((EReference)bo).getEOpposite().getEAnnotations());
	    	        if (!((EReference)bo).getEOpposite().getEAnnotations().isEmpty())viewerSourcesOP.setSelection(new StructuredSelection(viewerSourcesOP.getElementAt(0)),true);
	        	}
	        	compositeOP.setEnabled(((EReference)bo).getEOpposite() != null);
	        } else if (compositeOP != null){
	        	compositeOP.dispose(); //Garbage collector.
        		compositeOP=null;
	        }
	    }
	}
	
	public TableViewer getViewer() {
	    return viewerSources;
	}
	
	public void setFocus() {
	    viewerSources.getControl().setFocus();
	}
	  	
	class SelectionAnnotationChange implements ISelectionChangedListener{
		private TableViewer viewerTarget; 
		
		public SelectionAnnotationChange(TableViewer viewerTarget){
			this.viewerTarget = viewerTarget;
		}
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) { 
		        TableViewer control = (TableViewer)event.getSource();    
		        ISelection selection = control.getSelection();
		        if (selection != null && selection instanceof IStructuredSelection) {
		        	IStructuredSelection sel = (IStructuredSelection) selection; 
		            EAnnotation annotation = (EAnnotation)sel.getFirstElement();            
		            if (annotation!=null){
		            	viewerTarget.setInput(annotation.getDetails());        
		            }else  viewerTarget.setInput(null);
		            viewerTarget.refresh();
		        }
		    }
	}
					
	class DeleteAnnotationAction implements SelectionListener {
		
		private TableViewer viewer;
		
		public DeleteAnnotationAction (TableViewer viewerSource){
			this.viewer = viewerSource;
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			ISelection selection = this.viewer.getSelection();
	
	        if (selection != null && selection instanceof IStructuredSelection) {
	        	
	            IStructuredSelection sel = (IStructuredSelection) selection; 
	           
	            PictogramElement pe = getSelectedPictogramElement();
				if (pe != null) {
			        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			        if (bo == null)
			            return;
	
		            for (@SuppressWarnings("unchecked")
					Iterator<EAnnotation> iterator = sel.iterator(); iterator.hasNext();) {
		                final EAnnotation annotation = iterator.next();
		               
		                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EModelElement)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								 DeleteEAnnotationFeature df = new DeleteEAnnotationFeature(getDiagramTypeProvider().getFeatureProvider(), annotation);
								 df.delete(null);
							}
				        });
		              }
		            this.viewer.setSelection(StructuredSelection.EMPTY);
		            this.viewer.refresh();
				}
	        }
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {				
		}
	};

	class AddValueAction implements SelectionListener {
		
		private TableViewer sourceViewer;
		private TableViewer valueViewer;
		
		public AddValueAction(TableViewer sourceViewer, TableViewer valueViewer){
			this.sourceViewer = sourceViewer;
			this.valueViewer = valueViewer;
		}

		
		@Override
		public void widgetSelected(SelectionEvent e) {
			ISelection selectionAn = this.sourceViewer.getSelection();

	        if (selectionAn != null && selectionAn instanceof IStructuredSelection) {
	            IStructuredSelection selAn = (IStructuredSelection) selectionAn; 
	           
	            PictogramElement pe = getSelectedPictogramElement();
				if (pe != null) {
			        Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			        if (bo == null)
			            return;

	            	final EAnnotation annotation = (EAnnotation)selAn.getFirstElement();            
		            if (annotation!=null){
		                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EModelElement)bo);
				        domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {
								CreateEAnnotationEntryFeature cae = new CreateEAnnotationEntryFeature(getDiagramTypeProvider().getFeatureProvider(),annotation, ModelUtils.getAnnotationKeyValid(annotation));
								if (cae.canCreate(new CreateContext()))
										cae.create(new CreateContext());	
							}
				        });
		            }
		            this.valueViewer .setSelection(StructuredSelection.EMPTY);
		            this.valueViewer .refresh();
				}
	        }
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {				
		}
	};
	
	class DeleteValueAction implements SelectionListener {
		
		private TableViewer sourceViewer;
		private TableViewer valueViewer;
		
		public DeleteValueAction(TableViewer sourceViewer, TableViewer valueViewer){
			this.sourceViewer = sourceViewer;
			this.valueViewer = valueViewer;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			ISelection selectionAn = this.sourceViewer.getSelection();
			ISelection selectionVal = this.valueViewer.getSelection();

	        if (selectionAn != null && selectionAn instanceof IStructuredSelection && selectionVal != null && selectionVal instanceof IStructuredSelection) {
	            IStructuredSelection sel = (IStructuredSelection) selectionVal; 
	            IStructuredSelection selAn = (IStructuredSelection) selectionAn; 
	            final EAnnotation annotation = (EAnnotation)selAn.getFirstElement(); 

	            for (@SuppressWarnings("unchecked")
				Iterator<EAnnotation> iterator = sel.iterator(); iterator.hasNext();) {
	                final EStringToStringMapEntryImpl value = (EStringToStringMapEntryImpl)iterator.next();
	                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EAnnotation)annotation);
			        domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							annotation.getDetails().remove(value);
						}
			        });
	              }
	            this.valueViewer.setSelection(StructuredSelection.EMPTY);
	            this.valueViewer.refresh();
	        }
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
	};
	
	private SelectionListener listenerAddSourceAction = new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent e) {
            final PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
		        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		        if (bo == null)
		            return;
              
		        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EModelElement)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
					    CreateEAnnotationFeature caf = new CreateEAnnotationFeature(getDiagramTypeProvider().getFeatureProvider());
					    CreateContext cc = new CreateContext();
					    if (pe instanceof ContainerShape) cc.setTargetContainer((ContainerShape)pe);
					    else cc.setTargetConnection((Connection)pe);
					    caf.execute(cc);
				        viewerSources.refresh();
					}
		        });
			}
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {				
		}
	};
	
	private SelectionListener listenerAddSourceActionOP = new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent e) {
	        PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
		        final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		        if (bo == null)
		            return;
	          
		        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EModelElement)bo);
		        domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						EReference opp = ((EReference)bo).getEOpposite();
						CreateEAnnotationCustomFeature cacf = new CreateEAnnotationCustomFeature(getDiagramTypeProvider().getFeatureProvider(), opp); 
					    CustomContext cc = new CustomContext();
					    cacf.execute(cc);
				        viewerSourcesOP.refresh();
					}
		        });
		       
			}
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {				
		}
	};
} 
