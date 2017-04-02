/*
 * Copyright (C) 2017 Abdullah Shekhar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package prescriptionmanagement.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdullah Shekhar
 */
@Entity
@Table(name = "prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findByPresId", query = "SELECT p FROM Prescription p WHERE p.presId = :presId"),
    @NamedQuery(name = "Prescription.findByVisitDate", query = "SELECT p FROM Prescription p WHERE p.visitDate = :visitDate"),
    @NamedQuery(name = "Prescription.findByNextVisitDate", query = "SELECT p FROM Prescription p WHERE p.nextVisitDate = :nextVisitDate"),
    @NamedQuery(name = "Prescription.findByVisitFee", query = "SELECT p FROM Prescription p WHERE p.visitFee = :visitFee")})
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pres_id")
    private Integer presId;
    @Column(name = "visit_date")
    @Temporal(TemporalType.DATE)
    private Date visitDate;
    @Column(name = "next_visit_date")
    @Temporal(TemporalType.DATE)
    private Date nextVisitDate;
    @Column(name = "visit_fee")
    private Integer visitFee;
    @JoinTable(name = "prescription_deasease", joinColumns = {
        @JoinColumn(name = "des_id", referencedColumnName = "pres_id")}, inverseJoinColumns = {
        @JoinColumn(name = "pres_id", referencedColumnName = "pres_id")})
    @ManyToMany
    private Collection<Prescription> prescriptionCollection;
    @ManyToMany(mappedBy = "prescriptionCollection")
    private Collection<Prescription> prescriptionCollection1;
    @JoinColumn(name = "pat_id", referencedColumnName = "pat_id")
    @ManyToOne
    private PatientInfo patId;

    public Prescription() {
    }

    public Prescription(Integer presId) {
        this.presId = presId;
    }

    public Integer getPresId() {
        return presId;
    }

    public void setPresId(Integer presId) {
        this.presId = presId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public Integer getVisitFee() {
        return visitFee;
    }

    public void setVisitFee(Integer visitFee) {
        this.visitFee = visitFee;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection1() {
        return prescriptionCollection1;
    }

    public void setPrescriptionCollection1(Collection<Prescription> prescriptionCollection1) {
        this.prescriptionCollection1 = prescriptionCollection1;
    }

    public PatientInfo getPatId() {
        return patId;
    }

    public void setPatId(PatientInfo patId) {
        this.patId = patId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presId != null ? presId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.presId == null && other.presId != null) || (this.presId != null && !this.presId.equals(other.presId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prescriptionmanagement.bean.Prescription[ presId=" + presId + " ]";
    }
    
}
