package com.chandra.flexlayout;

public class FlexItemDto {

    private String label = "";
    private boolean isSelect;

    public FlexItemDto(String label, boolean isSelect) {
        this.label = label;
        this.isSelect = isSelect;
    }

    public String getLabel() {
        return label;
    }

    public FlexItemDto setLabel(String label) {
        this.label = label;
        return this;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public FlexItemDto setSelect(boolean select) {
        isSelect = select;
        return this;
    }

    @Override
    public String toString() {
        return "FlexItemDto{" +
                "label='" + label + '\'' +
                ", isSelect=" + isSelect +
                '}';
    }
}
