package com.virthelper;

import org.libvirt.Connect;

public interface ConnectionManager {
	
//	public void SetURI(String URI);
//	public void Setproto(String proto);
	public Connect makeConnection();
	public void closeConnection(Connect connectionname);
	
}
