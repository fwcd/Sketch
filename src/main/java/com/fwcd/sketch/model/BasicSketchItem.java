package com.fwcd.sketch.model;

import java.util.Optional;

import com.fwcd.fructose.geometry.DoubleMatrix;
import com.fwcd.fructose.geometry.Rectangle2D;
import com.fwcd.fructose.geometry.Vector2D;
import com.fwcd.sketch.view.tools.EditingTool;

public abstract class BasicSketchItem implements SketchItem {
	private static final long serialVersionUID = 97843987534L;
	
	@Override
	public SketchItem resizedBy(Vector2D delta) {
		Rectangle2D hb = getHitBox().getBoundingBox();
		double scaleX = (hb.width() + delta.getX()) / hb.width();
		double scaleY = (hb.height() + delta.getY()) / hb.height();
		
		return movedBy(hb.getTopLeft().invert())
				.transformedBy(new DoubleMatrix(new double[][] {
					{scaleX, 0},
					{0, scaleY}
				}))
				.movedBy(hb.getTopLeft());
	}

	@Override
	public Optional<EditingTool<?>> getEditingTool() {
		return Optional.empty();
	}
}
