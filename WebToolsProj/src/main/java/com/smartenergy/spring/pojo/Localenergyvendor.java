package com.smartenergy.spring.pojo;
// Generated Apr 23, 2016 4:00:35 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Localenergyvendor generated by hbm2java
 */
@Entity
@Table(name = "localenergyvendor", catalog = "smartenergy5", uniqueConstraints = @UniqueConstraint(columnNames = "LocalEnergyVendorName"))
public class Localenergyvendor implements java.io.Serializable {

	private Integer localEnergyVendorId;
	private Useraccount useraccount;
	private String localEnergyVendorName;
	private String localEnergyVendorDescription;
	private Set<Localenergyservices> localenergyserviceses = new HashSet<Localenergyservices>(0);

	public Localenergyvendor() {
	}

	public Localenergyvendor(String localEnergyVendorName) {
		this.localEnergyVendorName = localEnergyVendorName;
	}

	public Localenergyvendor(Useraccount useraccount, String localEnergyVendorName, String localEnergyVendorDescription,
			Set<Localenergyservices> localenergyserviceses) {
		this.useraccount = useraccount;
		this.localEnergyVendorName = localEnergyVendorName;
		this.localEnergyVendorDescription = localEnergyVendorDescription;
		this.localenergyserviceses = localenergyserviceses;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	@Column(name = "LocalEnergyVendorId", unique = true, nullable = false)
	public Integer getLocalEnergyVendorId() {
		return this.localEnergyVendorId;
	}

	public void setLocalEnergyVendorId(Integer localEnergyVendorId) {
		this.localEnergyVendorId = localEnergyVendorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	public Useraccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

	@Column(name = "LocalEnergyVendorName", unique = true, nullable = false, length = 40)
	public String getLocalEnergyVendorName() {
		return this.localEnergyVendorName;
	}

	public void setLocalEnergyVendorName(String localEnergyVendorName) {
		this.localEnergyVendorName = localEnergyVendorName;
	}

	@Column(name = "LocalEnergyVendorDescription", length = 200)
	public String getLocalEnergyVendorDescription() {
		return this.localEnergyVendorDescription;
	}

	public void setLocalEnergyVendorDescription(String localEnergyVendorDescription) {
		this.localEnergyVendorDescription = localEnergyVendorDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localenergyvendor")
	public Set<Localenergyservices> getLocalenergyserviceses() {
		return this.localenergyserviceses;
	}

	public void setLocalenergyserviceses(Set<Localenergyservices> localenergyserviceses) {
		this.localenergyserviceses = localenergyserviceses;
	}

}
