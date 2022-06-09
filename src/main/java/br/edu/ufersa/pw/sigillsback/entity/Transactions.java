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
@Table(name = "tb_transactions")
public class Transactions {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_accont_origin")
    private Account origin;

    @ManyToOne
    @JoinColumn(name = "id_conta_destiny")
    private Account destiny;
    
    private String description;
    private Float value;
    private LocalDateTime criate_at;
    private LocalDateTime date;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Account getOrigin() {
        return origin;
    }
    public void setOrigin(Account origin) {
        this.origin = origin;
    }
    public Account getDestiny() {
        return destiny;
    }
    public void setDestiny(Account destiny) {
        this.destiny = destiny;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getValue() {
        return value;
    }
    public void setValue(Float value) {
        this.value = value;
    }
    public LocalDateTime getCriate_at() {
        return criate_at;
    }
    public void setCriate_at(LocalDateTime criate_at) {
        this.criate_at = criate_at;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    
    
    
    

}
