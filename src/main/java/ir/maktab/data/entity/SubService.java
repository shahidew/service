package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subservice")
public class SubService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 50)
    private double basePrice;

    @Column(nullable = false, length = 50)
    private String description;

    @ManyToOne(targetEntity = SuperService.class, cascade = CascadeType.ALL)
    private SuperService superService;

    @OneToMany(mappedBy = "subService")
    private List<Order> orders = new ArrayList<>();


    @ManyToMany(mappedBy = "subServices")
    private List<Expert> experts = new ArrayList<>();

    public SubService() {
    }

    public String getName() {
        return name;
    }

    public SubService setName(String name) {
        this.name = name;
        return this;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public SubService setBasePrice(double basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubService setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SubService setId(Long id) {
        this.id = id;
        return this;
    }

    public SuperService getSuperService() {
        return superService;
    }

    public SubService setSuperService(SuperService superService) {
        this.superService = superService;
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public SubService setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public List<Expert> getExperts() {
        return experts;
    }

    public SubService setExperts(List<Expert> experts) {
        this.experts = experts;
        return this;
    }

}
