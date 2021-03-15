package com.cts.iptms.exception;

public class PackageDetailNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PackageDetailNotFoundException(String packageName) {
		super("there is no package with-"+packageName);
		// TODO Auto-generated constructor stub
	}

	
}
