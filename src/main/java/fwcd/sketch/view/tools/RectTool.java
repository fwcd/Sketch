package fwcd.sketch.view.tools;

import javax.swing.ImageIcon;

import fwcd.fructose.geometry.Rectangle2D;
import fwcd.fructose.geometry.Vector2D;
import fwcd.fructose.swing.ResourceImage;
import fwcd.sketch.model.BrushProperties;
import fwcd.sketch.model.items.ColoredRect;

public class RectTool extends DrawTool<ColoredRect> {
	private static final ImageIcon ICON = new ResourceImage("/rectToolIcon.png").getAsIcon();
	
	@Override
	public ImageIcon getIcon() {
		return ICON;
	}

	@Override
	protected ColoredRect getSketchItem(Vector2D startPos, BrushProperties props) {
		return new ColoredRect(new Rectangle2D(startPos, startPos), props);
	}

	@Override
	protected ColoredRect updateItem(ColoredRect item, Vector2D start, Vector2D last, Vector2D pos) {
		return new ColoredRect(new Rectangle2D(start, pos), getBrushProperties());
	}
}
