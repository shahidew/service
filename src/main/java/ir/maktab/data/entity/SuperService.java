package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "superservice")
public class SuperService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER, mappedBy = "superService")
    private List<SubService> subServices = new ArrayList<>();


    public SuperService() {
    }

    public String getName() {
        return name;
    }

    public SuperService setName(String name) {
        this.name = name;
        return this;
    }


    public List<SubService> getSubServices() {
        return subServices;
    }

    public SuperService setSubServices(List<SubService> subServices) {
        this.subServices = subServices;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SuperService setId(Long id) {
        this.id = id;
        return this;
    }
}
