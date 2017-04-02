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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdullah Shekhar
 */
@Entity
@Table(name = "deasease")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deasease.findAll", query = "SELECT d FROM Deasease d"),
    @NamedQuery(name = "Deasease.findByDesId", query = "SELECT d FROM Deasease d WHERE d.desId = :desId"),
    @NamedQuery(name = "Deasease.findByDesName", query = "SELECT d FROM Deasease d WHERE d.desName = :desName"),
    @NamedQuery(name = "Deasease.findBySymptom", query = "SELECT d FROM Deasease d WHERE d.symptom = :symptom")})
public class Deasease implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "des_id")
    private Integer desId;
    @Column(name = "des_name")
    private String desName;
    @Column(name = "symptom")
    private String symptom;

    public Deasease() {
    }

    public Deasease(Integer desId) {
        this.desId = desId;
    }

    public Integer getDesId() {
        return desId;
    }

    public void setDesId(Integer desId) {
        this.desId = desId;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName = desName;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desId != null ? desId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deasease)) {
            return false;
        }
        Deasease other = (Deasease) object;
        if ((this.desId == null && other.desId != null) || (this.desId != null && !this.desId.equals(other.desId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prescriptionmanagement.bean.Deasease[ desId=" + desId + " ]";
    }
    
}
