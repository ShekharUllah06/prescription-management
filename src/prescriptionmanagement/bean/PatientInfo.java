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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "patient_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientInfo.findAll", query = "SELECT p FROM PatientInfo p"),
    @NamedQuery(name = "PatientInfo.findByPatId", query = "SELECT p FROM PatientInfo p WHERE p.patId = :patId"),
    @NamedQuery(name = "PatientInfo.findByPatName", query = "SELECT p FROM PatientInfo p WHERE p.patName = :patName"),
    @NamedQuery(name = "PatientInfo.findByPatGender", query = "SELECT p FROM PatientInfo p WHERE p.patGender = :patGender"),
    @NamedQuery(name = "PatientInfo.findByPatGurdianName", query = "SELECT p FROM PatientInfo p WHERE p.patGurdianName = :patGurdianName"),
    @NamedQuery(name = "PatientInfo.findByDateOfBirth", query = "SELECT p FROM PatientInfo p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "PatientInfo.findByPatMobile", query = "SELECT p FROM PatientInfo p WHERE p.patMobile = :patMobile"),
    @NamedQuery(name = "PatientInfo.findByPatAddress", query = "SELECT p FROM PatientInfo p WHERE p.patAddress = :patAddress")})
public class PatientInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pat_id")
    private String patId;
    @Column(name = "pat_name")
    private String patName;
    @Column(name = "pat_gender")
    private String patGender;
    @Column(name = "pat_gurdian_name")
    private String patGurdianName;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "pat_mobile")
    private String patMobile;
    @Column(name = "pat_address")
    private String patAddress;
    @JoinColumn(name = "pat_realation", referencedColumnName = "relation")
    @ManyToOne
    private Relation patRealation;
    @OneToMany(mappedBy = "patId")
    private Collection<Prescription> prescriptionCollection;

    public PatientInfo() {
    }

    public PatientInfo(String patId) {
        this.patId = patId;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatGender() {
        return patGender;
    }

    public void setPatGender(String patGender) {
        this.patGender = patGender;
    }

    public String getPatGurdianName() {
        return patGurdianName;
    }

    public void setPatGurdianName(String patGurdianName) {
        this.patGurdianName = patGurdianName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatMobile() {
        return patMobile;
    }

    public void setPatMobile(String patMobile) {
        this.patMobile = patMobile;
    }

    public String getPatAddress() {
        return patAddress;
    }

    public void setPatAddress(String patAddress) {
        this.patAddress = patAddress;
    }

    public Relation getPatRealation() {
        return patRealation;
    }

    public void setPatRealation(Relation patRealation) {
        this.patRealation = patRealation;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patId != null ? patId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientInfo)) {
            return false;
        }
        PatientInfo other = (PatientInfo) object;
        if ((this.patId == null && other.patId != null) || (this.patId != null && !this.patId.equals(other.patId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prescriptionmanagement.bean.PatientInfo[ patId=" + patId + " ]";
    }
    
}
