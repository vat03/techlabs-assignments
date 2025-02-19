package com.aurionpro.state.model;

public class Ordered implements IPacketState{
	
	
	@Override
	public void next(Packet packet) {
		packet.setState(new Shipped());
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Packet in ordered state.");
	}

	@Override
	public void previous(Packet packet) {
		System.out.println("Packet in its first state | No previous state.");
	}

}
