package me.dio.bag.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.dio.bag.enumeration.PaymentMethod;
import javax.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor // construtor com todos atributos
@Builder // design pattern para criar objetos de forma mais simples
@Data // getters e setters
@Entity // para que a classe seja convertida em uma tabela no BD
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar alguns erros
@NoArgsConstructor // construtor vazio
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Client client;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
    private double totalValue;
    @Enumerated
    private PaymentMethod PaymentMethod;
    private boolean closed;

}