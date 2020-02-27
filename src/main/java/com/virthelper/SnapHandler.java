package com.virthelper;

import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.DomainSnapshot;
import org.libvirt.LibvirtException;

public class SnapHandler {
	
	private Connect hyperconn;
	private String DomainName;
	String[] snaplist;
	
	public Connect getHyperconn() {
		return hyperconn;
	}
	public void setHyperconn(Connect hyperconn) {
		this.hyperconn = hyperconn;
	}
	public String getDomainName() {
		return DomainName;
	}
	public void setDomainName(String domainName) {
		DomainName = domainName;
	}
	public SnapHandler(Connect hyperconn, String domainName) {
		super();
		this.hyperconn = hyperconn;
		DomainName = domainName;
	}
	private Domain getDomain(String instancename) throws LibvirtException {
	
		return this.hyperconn.domainLookupByName(instancename);
		
	}
	
	public String[] GetSnapList() throws LibvirtException{

		Domain domainobj = getDomain(DomainName);	
		snaplist = domainobj.snapshotListNames();
		return snaplist;

	}
	public void CreateSnap(String XmlDescription) throws Exception {
		Domain domainobj = getDomain(DomainName);
		DomainSnapshot snapobj = domainobj.snapshotCreateXML(XmlDescription,0);
		if ( snapobj.free() == 0 ) {
			System.out.println("Snapshot taken successfully");
		}
		else {
			System.out.println("Error during Snap creation");
			throw new Exception("Error during Snap creation");
		}
		
		
	}

}
