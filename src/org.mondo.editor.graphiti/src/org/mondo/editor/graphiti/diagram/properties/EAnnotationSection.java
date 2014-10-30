package org.mondo.editor.graphiti.diagram.properties;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mondo.editor.graphiti.diagram.CreateEAnnotationEntryFeature;
import org.mondo.editor.graphiti.diagram.CreateEAnnotationCustomFeature;
import org.mondo.editor.graphiti.diagram.DeleteEAnnotationFeature;
import org.mondo.editor.graphiti.diagram.properties.edit.AnnotationKeySupport;
import org.mondo.editor.graphiti.diagram.properties.edit.AnnotationSourceSupport;
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
	 
	private final static int MARGEN_TOP = 10;
	private final int ALTO_GRUPO = 300;
	private final int ANCHO_GRUPO = 550;
	private final int ALTO_BTN = 30;
	private final int ANCHO_BTN = 60;
	private final static int SEPARACION_VERTICAL = 30;
	private final static int MARGEN_IZQ = 15;
	private final static int ALTO_LST = 180;
	private final static int ANCHO_LST = 300;


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
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
		viewerValues.addSelectionChangedListener(listenerValue);
		
		Button btnAddValue = factory.createButton(grpValues, "Add", SWT.PUSH);
		btnAddValue.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4, ANCHO_BTN, ALTO_BTN);
		btnAddValue.addSelectionListener(listenerAddValueAction);
		
		
		btnDeleteValue = factory.createButton(grpValues, "Delete", SWT.PUSH);
		btnDeleteValue.setBounds(MARGEN_IZQ*2+ANCHO_LST*2,SEPARACION_VERTICAL+ALTO_LST/4+ALTO_BTN*3/2, ANCHO_BTN, ALTO_BTN);
		btnDeleteValue.addSelectionListener(listenerDeleteValueAction);
		
		
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
 		btnDeleteAnnotation.addSelectionListener(listenerDeleteAnnotationAction);

		viewerSources = PropertiesUtils.createViewerSources(grpAnnotations);
        viewerSources.addSelectionChangedListener(listener);
	}
	

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
	    if (pe != null) {
	    	Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	    	
	        if (bo == null)
	            return;
	       
	        TableViewerColumn tvc = (TableViewerColumn)viewerSources.getTable().getColumn(0).getData(Policy.JFACE + ".columnViewer"); //No hay otra manera de obtenerlo.
	        tvc.setEditingSupport(new AnnotationSourceSupport(viewerSources, getDiagram()));
	        viewerSources.setInput(((EModelElement)bo).getEAnnotations());
	        viewerSources.refresh();
	        
	        TableViewerColumn tvcVal0 = (TableViewerColumn)viewerValues.getTable().getColumn(0).getData(Policy.JFACE + ".columnViewer");
	        tvcVal0.setEditingSupport(new AnnotationKeySupport(viewerValues, getDiagram()));
	    }
	}
	
	  public TableViewer getViewer() {
	    return viewerSources;
	  }
	
	  public void setFocus() {
	    viewerSources.getControl().setFocus();
	  }
	  
	  private ISelectionChangedListener listener = new ISelectionChangedListener() {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) { 
	        TableViewer control = (TableViewer)event.getSource();    
	        ISelection selection = control.getSelection();
	        if (selection != null && selection instanceof IStructuredSelection) {
	        	IStructuredSelection sel = (IStructuredSelection) selection; 
	            EAnnotation annotation = (EAnnotation)sel.getFirstElement();            
	            if (annotation!=null){
		            viewerValues.setInput(annotation.getDetails());        
		            btnDeleteAnnotation.setEnabled(!(Graphiti.getLinkService().getPictogramElements(getDiagram(), annotation).size()>0));
	            }else  viewerValues.setInput(null);
	            viewerValues.refresh();
	        }
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
							 CreateEAnnotationCustomFeature caf = new CreateEAnnotationCustomFeature(getDiagramTypeProvider().getFeatureProvider(), (EModelElement)bo);
						     caf.execute(new CustomContext());
					         viewerSources.refresh();
						}
			        });
			       
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
		};
		
		private SelectionListener listenerDeleteAnnotationAction = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = viewerSources.getSelection();

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
			            viewerSources.setSelection(StructuredSelection.EMPTY);
			            viewerSources.refresh();
					}
		        }
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
		};
		
	
		
	 private SelectionListener listenerAddValueAction = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selectionAn = viewerSources.getSelection();

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
			            viewerValues.setSelection(StructuredSelection.EMPTY);
			            viewerValues.refresh();
					}
		        }
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
		};
	
		
		private ISelectionChangedListener listenerValue = new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) { 
		        TableViewer control = (TableViewer)event.getSource();    
		        ISelection selection = control.getSelection();
		        if (selection != null && selection instanceof IStructuredSelection) {
		        	IStructuredSelection sel = (IStructuredSelection) selection; 
		        	EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl)sel.getFirstElement();            
		            if (entry!=null){
			            btnDeleteValue.setEnabled(!(Graphiti.getLinkService().getPictogramElements(getDiagram(), entry).size()>0));
		            }
		        }
		    }	
		  };	
		
		
	
	  private SelectionListener listenerDeleteValueAction = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selectionAn = viewerSources.getSelection();
				ISelection selectionVal = viewerValues.getSelection();

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
		            viewerValues.setSelection(StructuredSelection.EMPTY);
		            viewerValues.refresh();
		        }
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		};

} 

