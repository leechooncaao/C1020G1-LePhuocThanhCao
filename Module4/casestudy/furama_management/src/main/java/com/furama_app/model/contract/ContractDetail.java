package com.furama_app.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", nullable = false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attach_service_id", nullable = false)
    private AttachService attachService;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public ContractDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
