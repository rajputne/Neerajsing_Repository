package com.smartenergy.spring.pojo.hib1;
// Generated Apr 17, 2016 9:30:39 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Globalenergyvendor generated by hbm2java
 */
@Entity
@Table(name = "globalenergyvendor", catalog = "smartenergy2")
public class Globalenergyvendor implements java.io.Serializable {

	private Integer globalVendorId;
	private Useraccount useraccount;
	private String globalEnergyVendorName;
	private String globalEnergyVendorDescription;
	private Set<Globalservices> globalserviceses = new HashSet<Globalservices>(0);

	public Globalenergyvendor() {
	}

	public Globalenergyvendor(String globalEnergyVendorName) {
		this.globalEnergyVendorName = globalEnergyVendorName;
	}

	public Globalenergyvendor(Useraccount useraccount, String globalEnergyVendorName,
			String globalEnergyVendorDescription, Set<Globalservices> globalserviceses) {
		this.useraccount = useraccount;
		this.globalEnergyVendorName = globalEnergyVendorName;
		this.globalEnergyVendorDescription = globalEnergyVendorDescription;
		this.globalserviceses = globalserviceses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "GlobalVendorId", unique = true, nullable = false)
	public Integer getGlobalVendorId() {
		return this.globalVendorId;
	}

	public void setGlobalVendorId(Integer globalVendorId) {
		this.globalVendorId = globalVendorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	public Useraccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

	@Column(name = "GlobalEnergyVendorName", nullable = false, length = 40)
	public String getGlobalEnergyVendorName() {
		return this.globalEnergyVendorName;
	}

	public void setGlobalEnergyVendorName(String globalEnergyVendorName) {
		this.globalEnergyVendorName = globalEnergyVendorName;
	}

	@Column(name = "GlobalEnergyVendorDescription", length = 100)
	public String getGlobalEnergyVendorDescription() {
		return this.globalEnergyVendorDescription;
	}

	public void setGlobalEnergyVendorDescription(String globalEnergyVendorDescription) {
		this.globalEnergyVendorDescription = globalEnergyVendorDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "globalenergyvendor")
	public Set<Globalservices> getGlobalserviceses() {
		return this.globalserviceses;
	}

	public void setGlobalserviceses(Set<Globalservices> globalserviceses) {
		this.globalserviceses = globalserviceses;
	}

}
