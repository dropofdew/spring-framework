package com.pole2win.spi.components;

public class SpiInterfaceImpl1 implements SpiInterface {
	private String name = "SpiInterfaceImpl1";

	@Override
	public String get() {
		return name;
	}
}
