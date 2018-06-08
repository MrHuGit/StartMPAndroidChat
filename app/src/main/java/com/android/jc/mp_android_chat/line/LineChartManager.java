package com.android.jc.mp_android_chat.line;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;

/**
 * @author Mr.Hu(Jc)
 * @create 2018/6/8 11:03
 * @organize
 * @describe
 * @update
 */
public class LineChartManager {
//
//    public LineChartManager(LineChart lineChart,LineChartConfiguration configuration){
//        if (lineChart==null || configuration==null){
//            return;
//        }
//        lineChart.setGridBackgroundColor(configuration.gridBackgroundColor);
//        lineChart.setNoDataText(configuration.noDataText);
//        lineChart.setDrawGridBackground(configuration.showDrawGridBackground);
//        lineChart.setGridBackgroundColor(configuration.gridBackgroundColor);
//    }
//    public void initLineChart(LineChart lineChart,LineChartConfiguration configuration) {
//        if (lineChart==null || configuration==null){
//            return;
//        }
//        lineChart.setGridBackgroundColor(configuration.gridBackgroundColor);
//        lineChart.setNoDataText(configuration.noDataText);
//        lineChart.setDrawGridBackground(configuration.showDrawGridBackground);
//        lineChart.setGridBackgroundColor(configuration.gridBackgroundColor);
//
//    }

    public static class LineChartConfiguration {
        public static LineChartConfiguration create(){
            return new LineChartConfiguration();
        }
        private boolean showDescription = true;
        /**
         * 没有数据的时候显示的内容{@link LineChart#setNoDataText(String)}
         */
        private String noDataText = "No chart data available.";
        /**
         * 是否显示LineChart的背景颜色{@link LineChart#setDrawGridBackground(boolean)}
         */
        private boolean showDrawGridBackground=true;
        /**
         * 设置LineChart背景颜色
         */
        private @ColorInt int gridBackgroundColor= Color.rgb(240, 240, 240);


        public LineChartConfiguration setNoDataText(String noDataText){
            this.noDataText=noDataText;
            return this;
        }



        public void initLineChart(LineChart lineChart){
            lineChart.getDescription().setEnabled(showDescription);
            lineChart.setNoDataText(noDataText);
            lineChart.setDrawGridBackground(showDrawGridBackground);
            lineChart.setGridBackgroundColor(gridBackgroundColor);
            YAxis leftYAxis=lineChart.getAxisLeft();
            YAxis rightYAxis=lineChart.getAxisRight();
        }

    }
}
