package br.edu.ufersa.pw.sigillsback.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_entry")
public class Entry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_accont")
    private Account acconta;

    private int category;
    private LocalDateTime criate_at;
    private Float value;
    private String descricao;
    private LocalDateTime date;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Account getAcconta() {
        return acconta;
    }
    public void setAcconta(Account acconta) {
        this.acconta = acconta;
    }
    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public LocalDateTime getCriate_at() {
        return criate_at;
    }
    public void setCriate_at(LocalDateTime criate_at) {
        this.criate_at = criate_at;
    }
    public Float getValue() {
        return value;
    }
    public void setValue(Float value) {
        this.value = value;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
   
   
   

    

}
