package com.aurionpro.state.model;

public class Shipped implements IPacketState{

	@Override
	public void next(Packet packet) {
		packet.setState(new Delivered());
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Packet in shipped state.");
	}

	@Override
	public void previous(Packet packet) {
		packet.setState(new Ordered());
	}

}
