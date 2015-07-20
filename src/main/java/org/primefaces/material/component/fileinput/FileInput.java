package org.primefaces.material.component.fileinput;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UINamingContainer;
import javax.faces.component.html.HtmlInputFile;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "fileinput/fileInput.js")
})
public class FileInput extends HtmlInputFile implements Widget{
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.FileInput";
	static final String PRE_ADDON_FACET_NAME = "preAddon";
	static final String POST_ADDON_FACET_NAME = "postAddon";	
	
	public FileInput() {
		setRendererType(FileInputRenderer.RENDERER_TYPE);
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	
	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}
	
	@Override
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");

	}
	
	protected enum PropertyKeys {		
		widgetVar;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}

}
