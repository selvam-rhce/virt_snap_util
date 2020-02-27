package com.virthelper;

import org.libvirt.Connect;
import org.libvirt.LibvirtException;

public class QemuConnection implements ConnectionManager {
	
	private String proto;
	private String URI;
	Connect newcon;
	

	public QemuConnection(String proto, String uRI) {
		super();
		this.proto = proto;
		URI = uRI;
	}

	public String getProto() {
		return proto;
	}

	public void setProto(String proto) {
		this.proto = proto;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}


	@Override
	public Connect makeConnection() {
		String fqdn = proto+"://"+URI;
		try {
			newcon = new Connect(fqdn);
		} catch (LibvirtException e) {
			System.out.println("Exception while making connection");
			e.printStackTrace();
		}
			return newcon;
	}

	@Override
	public void closeConnection(Connect connectionname) {
//		newcon = connectionname;
		try {
			connectionname.close();
		} catch (LibvirtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
