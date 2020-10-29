package no.hvl.dat108;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "oblig4")

public class Deltager {
	
	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public int getMobilnummer() {
		return mobilnummer;
	}

	public String getKjonn() {
		return kjonn;
	}

	private String fornavn;
	private String etternavn;
	@Id
	private int mobilnummer;
	@Embedded
	private Passord passord;
	private String kjonn;
	
	
	public Deltager(String fornavn, String etternavn, int mobilnummer, String kjonn, Passord passord ) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobilnummer = mobilnummer;
		this.passord = passord;
		this.kjonn = kjonn.toUpperCase();
		
	}
	
	public Deltager() {}
	
	public Passord getPassord() {
		return passord;
	}
	
	public String toString() {
		return fornavn + " " + etternavn + " " + mobilnummer + " " + kjonn;
	}
}
