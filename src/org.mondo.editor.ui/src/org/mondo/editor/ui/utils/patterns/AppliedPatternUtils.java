package org.mondo.editor.ui.utils.patterns;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.mondo.editor.graphiti.diagram.utils.PropertiesUtils;

import runtimePatterns.InstanceFeatureRoleInstance;

public final class AppliedPatternUtils {

	private final static int SEPARACION_VERTICAL = 30;
	private final static int MARGEN_IZQ = 15;
	private final static int ANCHO_LST = 190;
	private final static int ALTO_LST = 180;
	
	/**
	 * Static method that created a tableViewer for values
	 * @param parent
	 * @return tableViewer
	 */
	public static TableViewer createViewerFeatureInstanceRoles(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	
		addColumnsFeatureInstanceRoles(parent, viewer);
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
	private static void addColumnsFeatureInstanceRoles(final Composite parent,final TableViewer viewer) {
	    String[] titles = { "Feature Instance", "Value" };
	    int[] bounds = { ANCHO_LST - 4, ANCHO_LST - 4 };
	
	    TableViewerColumn col = PropertiesUtils.createTableViewerColumn(viewer, titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  InstanceFeatureRoleInstance a = (InstanceFeatureRoleInstance) element;
	    	  return RuntimePatternsModelUtils.getPatternRoleName(a);
	      }
	    });
	    
	    TableViewerColumn col2 = PropertiesUtils.createTableViewerColumn(viewer, titles[1], bounds[1],1);
	    col2.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  InstanceFeatureRoleInstance a = (InstanceFeatureRoleInstance) element;
	    	  return a.getValue();
	    	  	
	      }
	    });
	    //col2.setEditingSupport(new InstanceFeatureSupport(viewer, db));
	}
}
