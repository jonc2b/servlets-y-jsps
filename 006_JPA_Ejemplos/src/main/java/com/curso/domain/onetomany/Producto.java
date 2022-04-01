package com.curso.domain.onetomany;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "HR", name = "PRODUCTOS")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT p FROM Productos p")})
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // campo autonumerico de mysql
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "HR.CUSTOMER_SEQ", allocationSize = 1 , name = "CUST_SEQ" )
    private Integer id;
    @Basic(optional = false)
 
   
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    
    
    
    
    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
}
