package org.antlr.intellij.plugin.preview;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseMotionAdapter;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.HighlighterTargetArea;
import com.intellij.openapi.editor.markup.MarkupModel;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.BalloonBuilder;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import com.intellij.ui.awt.RelativePoint;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PreviewEditorMouseListener extends EditorMouseMotionAdapter {
	protected Balloon lastBalloon;
	protected Point lastPoint;

	@Override
	public void mouseMoved(EditorMouseEvent e){
		MouseEvent mouseEvent=e.getMouseEvent();
		if(mouseEvent.isMetaDown()){
			Point point=new Point(mouseEvent.getPoint());
			Editor editor=e.getEditor();
			LogicalPosition pos=editor.xyToLogicalPosition(point);
			int offset=editor.logicalPositionToOffset(pos);
			int selStart=editor.getSelectionModel().getSelectionStart();
			int selEnd=editor.getSelectionModel().getSelectionEnd();


//						highlighter.setErrorStripeTooltip(highlightInfo);
//			ToolTipManager toolTipManager=ToolTipManager.sharedInstance();
//						toolTipManager.setEnabled(true);
//						editor.getComponent().setToolTipText("fooo");
//						toolTipManager.mouseEntered(mouseEvent);

			if ( lastPoint==null || Math.abs(lastPoint.getX() - point.getX())>=8 ) {
				MarkupModel markupModel=editor.getMarkupModel();
				markupModel.removeAllHighlighters();
				if ( lastBalloon!=null ) {
					lastBalloon.hide();
				}
				final TextAttributes attr=new TextAttributes();
				attr.setForegroundColor(JBColor.BLUE);
				attr.setEffectColor(JBColor.BLUE);
				attr.setEffectType(EffectType.LINE_UNDERSCORE);
				RangeHighlighter highlighter=
					markupModel.addRangeHighlighter(offset,offset+1,0,attr, HighlighterTargetArea.EXACT_RANGE);
//				HighlightInfo.Builder highlightInfo = HighlightInfo.newHighlightInfo(HighlightInfoType.WARNING);
//				highlighter.setErrorStripeTooltip(highlightInfo);
				BalloonBuilder builder =
					JBPopupFactory.getInstance().createHtmlTextBalloonBuilder("hello", MessageType.INFO, null);
				Balloon balloon = builder.createBalloon();
				System.out.println("show at " + point);
				RelativePoint where = new RelativePoint(mouseEvent.getComponent(), point);
				balloon.show(where, Balloon.Position.above);
				lastBalloon = balloon;
				lastPoint = point;
			}
		}
	}
}
