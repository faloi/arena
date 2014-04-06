package org.uqbar.lacar.ui.impl.jface.builder

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Link
import org.uqbar.lacar.ui.impl.jface.JFaceContainer
import org.uqbar.lacar.ui.impl.jface.JFaceSkinnableControlBuilder
import org.uqbar.lacar.ui.impl.jface.bindings.JFaceBindingBuilder
import org.uqbar.lacar.ui.impl.jface.builder.traits.JFaceClickable
import org.uqbar.lacar.ui.impl.jface.swt.observables.CaptionObservableValue
import org.uqbar.lacar.ui.model.builder.LinkBuilder

/**
 * @author jfernandes
 */
class JFaceLinkBuilder(context : JFaceContainer) 
	extends JFaceSkinnableControlBuilder[Link](context, new Link(context.getJFaceComposite(), SWT.NONE)) 
	with LinkBuilder
	with JFaceClickable {
  
	def setCaption(caption: String) : LinkBuilder = {
		getWidget.setText(caption)
		this
	}
  
	// Esto no tiene sentido. Pasar a traits y que no este en e link
	override def observeValue() = 
	  throw new UnsupportedOperationException("Se intentó observar la propiedad 'value' de un Link, que no tiene dicha propiedad")
	
	override def observeCaption() = 
	  new JFaceBindingBuilder(this, new CaptionObservableValue(getWidget))
  
}