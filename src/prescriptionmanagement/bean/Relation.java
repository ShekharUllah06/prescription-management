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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abdullah Shekhar
 */
@Entity
@Table(name = "relation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relation.findAll", query = "SELECT r FROM Relation r"),
    @NamedQuery(name = "Relation.findByRelation", query = "SELECT r FROM Relation r WHERE r.relation = :relation")})
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "relation")
    private String relation;
    @OneToMany(mappedBy = "patRealation")
    private Collection<PatientInfo> patientInfoCollection;

    public Relation() {
    }

    public Relation(String relation) {
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @XmlTransient
    public Collection<PatientInfo> getPatientInfoCollection() {
        return patientInfoCollection;
    }

    public void setPatientInfoCollection(Collection<PatientInfo> patientInfoCollection) {
        this.patientInfoCollection = patientInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relation != null ? relation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relation)) {
            return false;
        }
        Relation other = (Relation) object;
        if ((this.relation == null && other.relation != null) || (this.relation != null && !this.relation.equals(other.relation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prescriptionmanagement.bean.Relation[ relation=" + relation + " ]";
    }
    
}
