package br.edu.ufersa.pw.sigillsback.DTO;

import br.edu.ufersa.pw.sigillsback.entity.User;

public class CreditCardDto {

    private String name;
    private User user;
    private int closeDate;
    private int dueDate;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getCloseDate() {
        return closeDate;
    }
    public void setCloseDate(int closeDate) {
        this.closeDate = closeDate;
    }
    public int getDueDate() {
        return dueDate;
    }
    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    
    
}
