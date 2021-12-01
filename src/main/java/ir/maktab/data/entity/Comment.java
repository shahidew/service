package ir.maktab.data.entity;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String text;

    private Double score;

    @ManyToOne(targetEntity = Expert.class, cascade = CascadeType.ALL)
    private Expert expert;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private Customer customer;


    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public Comment setScore(Double score) {
        this.score = score;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public Comment setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Comment setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }


}
