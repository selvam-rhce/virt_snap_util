package com.virthelper;

import org.libvirt.Connect;
import org.libvirt.LibvirtException;

public class FlyVirt {

	public static void main(String[] args) throws LibvirtException {

		// to create connection
		ConnectionManager newconn = new QemuConnection("qemu+ssh", "<username>@<ip>/system");
		Connect conn = newconn.makeConnection();

		
		// node info
			String hstname = conn.getHostName();
			System.out.println("Hostname : "+ hstname);
			
		// to get list of snapshots
		SnapHandler snapobj = new SnapHandler(conn, "jarvis");
		for ( String snap : snapobj.GetSnapList() ) {
			System.out.println(snap);
		}
		
		
		// to create snapshots
//		String xml = "<domainsnapshot> <name>snapfromjava-new</name><description> This is the snapshot created from java util</description></domainsnapshot>";
//		try {
//			snapobj.CreateSnap(xml);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		newconn.closeConnection(conn);
	}

}
