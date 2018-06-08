package com.android.jc.mp_android_chat.line;

import android.support.annotation.ColorInt;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.List;

/**
 * @author Mr.Hu(Jc)
 * @create 2018/6/8 10:05
 * @organize
 * @describe
 * @update
 */
public class LineDataSetBean {
    private List<Entry> entryList;
    private String label="";
    private @ColorInt int color;
    private @ColorInt int highLightColor;
    private LineDataSet.Mode lineDataSetMode=LineDataSet.Mode.LINEAR;
    private boolean showDrawCircles=true;
    private boolean showDrawValues=true;
    private boolean showHighlightEnabled=true;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getHighLightColor() {
        return highLightColor;
    }

    public void setHighLightColor(int highLightColor) {
        this.highLightColor = highLightColor;
    }

    public LineDataSet.Mode getLineDataSetMode() {
        return lineDataSetMode;
    }

    public void setLineDataSetMode(LineDataSet.Mode lineDataSetMode) {
        this.lineDataSetMode = lineDataSetMode;
    }

    public boolean isShowDrawCircles() {
        return showDrawCircles;
    }

    public void setShowDrawCircles(boolean showDrawCircles) {
        this.showDrawCircles = showDrawCircles;
    }

    public boolean isShowDrawValues() {
        return showDrawValues;
    }

    public void setShowDrawValues(boolean showDrawValues) {
        this.showDrawValues = showDrawValues;
    }

    public boolean isShowHighlightEnabled() {
        return showHighlightEnabled;
    }

    public void setShowHighlightEnabled(boolean showHighlightEnabled) {
        this.showHighlightEnabled = showHighlightEnabled;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
}
