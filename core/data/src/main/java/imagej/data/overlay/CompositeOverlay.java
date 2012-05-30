/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2012 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of any organization.
 * #L%
 */

package imagej.data.overlay;

import imagej.ImageJ;
import net.imglib2.roi.CompositeRegionOfInterest;

/**
 * A composite of several overlays.
 * 
 * @author Lee Kamentsky
 */
public class CompositeOverlay extends
	AbstractROIOverlay<CompositeRegionOfInterest>
{

	public CompositeOverlay(final ImageJ context) {
		this(context, 2);
	}

	public CompositeOverlay(final ImageJ context, final int numDimensions) {
		super(context, new CompositeRegionOfInterest(numDimensions));
	}

	public CompositeOverlay(final ImageJ context,
		final CompositeRegionOfInterest roi)
	{
		super(context, roi);
	}

	@Override
	public Overlay duplicate() {
		throw new UnsupportedOperationException("must implement");
		/*
		CompositeRegionOfInterest origRoi = getRegionOfInterest();
		CompositeOverlay overlay = new CompositeOverlay(getContext());
		CompositeRegionOfInterest newRoi = overlay.getRegionOfInterest();
		// TODO ITS UNKNOWN WHAT TO DO HERE. I THINK ROIS MUST HAVE .duplicate()
		overlay.setAlpha(getAlpha());
		overlay.setAxis(Axes.X, Axes.X.ordinal());
		overlay.setAxis(Axes.Y, Axes.Y.ordinal());
		overlay.setFillColor(getFillColor());
		overlay.setLineColor(getLineColor());
		overlay.setLineEndArrowStyle(getLineEndArrowStyle());
		overlay.setLineStartArrowStyle(getLineStartArrowStyle());
		overlay.setLineStyle(getLineStyle());
		overlay.setLineWidth(getLineWidth());
		overlay.setName(getName());
		return overlay;
		*/
	}

	@Override
	public void move(double[] deltas) {
		getRegionOfInterest().move(deltas);
	}

}
