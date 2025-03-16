package com.school.data.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "ledger_id", nullable = false)
    private Ledger ledger;

    @Column(name = "opening_balance", nullable = false)
    private BigDecimal openingBalance;
    
    

    // Constructors
    public Account() {}

    public Account(String name, LocalDate createdDate, Ledger ledger, BigDecimal openingBalance) {
        this.name = name;
        this.createdDate = createdDate;
        this.ledger = ledger;
        this.openingBalance = openingBalance;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    public Ledger getLedger() { return ledger; }
    public void setLedger(Ledger ledger) { this.ledger = ledger; }

    public BigDecimal getOpeningBalance() { return openingBalance; }
    public void setOpeningBalance(BigDecimal openingBalance) { this.openingBalance = openingBalance; }
}
