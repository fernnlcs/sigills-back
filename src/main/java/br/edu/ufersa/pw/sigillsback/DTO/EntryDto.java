package br.edu.ufersa.pw.sigillsback.DTO;

import java.util.Calendar;

import br.edu.ufersa.pw.sigillsback.support.transition.EntryCategory;

public class EntryDto {
    
    private Double value;
    private Calendar date;
    private String description;
    private EntryCategory category = EntryCategory.OUTRO;
    
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public Calendar getDate() {
        return date;
    }
    public void setDate(Calendar date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public EntryCategory getCategory() {
        return category;
    }
    public void setCategory(EntryCategory category) {
        this.category = category;
    }



}
