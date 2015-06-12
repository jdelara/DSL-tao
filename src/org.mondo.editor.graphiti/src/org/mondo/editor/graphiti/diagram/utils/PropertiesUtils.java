package org.mondo.editor.graphiti.diagram.utils;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.mondo.editor.graphiti.diagram.properties.edit.AnnotationKeySupport;
import org.mondo.editor.graphiti.diagram.properties.edit.AnnotationSourceSupport;
import org.mondo.editor.graphiti.diagram.properties.edit.AnnotationValueSupport;

/**
 * Class of utility functions to work with the properties tab of the editor.
 * 
 * @author miso partner AnaPescador
 *
 */
public class PropertiesUtils {

	private final static int SEPARACION_VERTICAL = 30;
	private final static int MARGEN_IZQ = 15;
	private final static int ANCHO_LST = 190;
	private final static int ALTO_LST = 180;

	/**
	 * Static class that creates a TableViewer for sources
	 * @param parent
	 * @return TableViewer
	 */
	public static TableViewer createViewerSources(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	
		addColumnsSources(parent, viewer);
	    final Table table2 = viewer.getTable();
	    table2.setHeaderVisible(true);
	    table2.setLinesVisible(true);
	    table2.setBounds(MARGEN_IZQ, SEPARACION_VERTICAL,ANCHO_LST, ALTO_LST);
	    
	    viewer.setContentProvider(new ArrayContentProvider());
	
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	    return viewer;
	}
	

	/**
	 * Static method that adds source columns in the specified tableviewer
	 * @param parent
	 * @param viewer
	 */
	private static void addColumnsSources(final Composite parent,final TableViewer viewer) {
	    String[] titles = { "Source" };
	    int[] bounds = { ANCHO_LST - 4};
	
	    TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        EAnnotation a = (EAnnotation) element;
	        return a.getSource();
	      }
	    });
	    col.setEditingSupport(new AnnotationSourceSupport(viewer));
	}
	
	
	
	/**
	 * Static method that created a tableViewer for values
	 * @param parent
	 * @return tableViewer
	 */
	public static TableViewer createViewerValues(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	
		addColumnsValues(parent, viewer);
	    final Table table2 = viewer.getTable();
	    table2.setHeaderVisible(true);
	    table2.setLinesVisible(true);
	    table2.setBounds(MARGEN_IZQ, SEPARACION_VERTICAL,ANCHO_LST*2, ALTO_LST);
	    
	    viewer.setContentProvider(new ArrayContentProvider());
	
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	    return viewer;
	}
		
	/**
	 * Static method that adds value columns in the specified tableviewer
	 * @param parent
	 * @param viewer
	 */
	private static void addColumnsValues(final Composite parent,final TableViewer viewer) {
	    String[] titles = { "Key", "Value" };
	    int[] bounds = { ANCHO_LST - 4, ANCHO_LST - 4 };
	
	    TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  EStringToStringMapEntryImpl a = (EStringToStringMapEntryImpl) element;
	        return a.getKey();
	      }
	    });
	    col.setEditingSupport(new AnnotationKeySupport(viewer));
	    
	    TableViewerColumn col2 = createTableViewerColumn(viewer, titles[1], bounds[1],1);
	    col2.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  EStringToStringMapEntryImpl a = (EStringToStringMapEntryImpl) element;
	        return a.getValue();
	      }
	    });
	    col2.setEditingSupport(new AnnotationValueSupport(viewer));
	}
	  
	  
	/**
	 * Static method that creates a tableViewer column with the specified title, width and column number.
	 * @param viewer
	 * @param title
	 * @param bound - width
	 * @param colNumber
	 * @return TableViewerColumn
	 */
	public static TableViewerColumn createTableViewerColumn(final TableViewer viewer, String title, int bound, final int colNumber) {
	    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
	        SWT.NONE);
	    final TableColumn column = viewerColumn.getColumn();
	    column.setText(title);
	    column.setWidth(bound);
	    column.setResizable(true);
	    column.setMoveable(true);
	    return viewerColumn;
	}
	
	/**
	 * Static method that creates a table viewer for eattributes.
	 * @param parent
	 * @return TableViewer
	 */
	public static TableViewer createViewerAttributes(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	
		addColumnsAttributes(parent, viewer);
	    final Table table2 = viewer.getTable();
	    table2.setHeaderVisible(false);
	    table2.setLinesVisible(true);
	    table2.setBounds(MARGEN_IZQ, SEPARACION_VERTICAL,ANCHO_LST, ALTO_LST);
	    
	    viewer.setContentProvider(new ArrayContentProvider());
	
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	    return viewer;
	}
		

	/**
	 * Static method that adds eattribute columns in the specified viewer
	 * @param parent
	 * @param viewer
	 */
	private static void addColumnsAttributes(final Composite parent,final TableViewer viewer) {
	    String[] titles = { "Name" };
	    int[] bounds = { ANCHO_LST - 4};
	
	    TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        EAttribute a = (EAttribute) element;
	        return a.getName();
	      }
	    });
	}
 
	/**
	 * Static method that creates a table viewer for ereferences.
	 * @param parent
	 * @return TableViewer
	 */
	public static TableViewer createViewerReferences(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	
		addColumnsReferences(parent, viewer);
	    final Table table2 = viewer.getTable();
	    table2.setHeaderVisible(false);
	    table2.setLinesVisible(true);
	    table2.setBounds(MARGEN_IZQ, SEPARACION_VERTICAL,ANCHO_LST, ALTO_LST);
	    
	    viewer.setContentProvider(new ArrayContentProvider());
	
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	    return viewer;
	}
			
	/**
	 * Static method that adds ereference columns in the specified viewer.
	 * @param parent
	 * @param viewer
	 */
	private static void addColumnsReferences(final Composite parent,final TableViewer viewer) {
	    String[] titles = { "Name" };
	    int[] bounds = { ANCHO_LST - 4};
	
	    TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  EReference r = (EReference) element;
		        return r.getName();
		      }
		 });
	}
		  	  
	/**
	 * Static method that creates a table viewer for eclasses.
	 * @param parent
	 * @return TableViewer
	 */	  
	public static TableViewer createViewerClasses(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
		    | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		
		addColumnsClasses(parent, viewer);
		final Table table2 = viewer.getTable();
		table2.setHeaderVisible(false);
		table2.setLinesVisible(true);
		table2.setBounds(MARGEN_IZQ, SEPARACION_VERTICAL,ANCHO_LST, ALTO_LST);
		
		viewer.setContentProvider(new ArrayContentProvider());
		
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	    return viewer;
	}
			
	/**
	 * Static method that adds eclass columns in the specified viewer.
	 * @param parent
	 * @param viewer
	 */
	private static void addColumnsClasses(final Composite parent,final TableViewer viewer) {
	    String[] titles = { "Name" };
	    int[] bounds = { ANCHO_LST - 4};
	
	    TableViewerColumn col = createTableViewerColumn(viewer, titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        EClass a = (EClass) element;
	        return a.getName();
	      }
	    });
	}

}
