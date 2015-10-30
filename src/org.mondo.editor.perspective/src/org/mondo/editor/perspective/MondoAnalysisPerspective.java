package org.mondo.editor.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class MondoAnalysisPerspective implements IPerspectiveFactory {

	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
	    defineLayout(layout);
	}
	
	public void defineActions(IPageLayout layout) {
		 layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
	        layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");

	        layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
	        layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
	}
	
	public void defineLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();

        IFolderLayout left =
                layout.createFolder("left", IPageLayout.LEFT, (float) 0.15, editorArea);
        left.addView(IPageLayout.ID_PROJECT_EXPLORER);
        
        IFolderLayout bottom =
                layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.70, editorArea);
        bottom.addView(IPageLayout.ID_PROP_SHEET);
	}
}
