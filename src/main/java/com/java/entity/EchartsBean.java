package com.java.entity;

import java.util.List;

/**
 - @ClassName: EchartsBean
 - @Description: TODO(图标数据包装类)
 - @author 爱琴孩
*/
public class EchartsBean {

    //表中的x轴类别
    private List<String> xAxisCategory;
    //表中的数据
    private List<Integer> datas;

    public EchartsBean(){}

    public EchartsBean(List<String> xAxisCategory,List<Integer> datas){
        this.xAxisCategory=xAxisCategory;
        this.datas=datas;
    }

    public List<String> getxAxisCategory() {
        return xAxisCategory;
    }

    public void setxAxisCategory(List<String> xAxisCategory) {
        this.xAxisCategory = xAxisCategory;
    }

    public List<Integer> getDatas() {
        return datas;
    }

    public void setDatas(List<Integer> datas) {
        this.datas = datas;
    }
}
