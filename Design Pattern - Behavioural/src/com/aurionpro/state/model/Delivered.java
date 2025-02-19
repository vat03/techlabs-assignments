package com.aurionpro.state.model;

public class Delivered implements IPacketState{

	@Override
	public void next(Packet packet) {
		System.out.println("Packet in its last state | No next state.");
	}

	@Override
	public void current(Packet packet) {
		System.out.println("Packet in Delivered state.");
	}

	@Override
	public void previous(Packet packet) {
		packet.setState(new Shipped());
	}

}