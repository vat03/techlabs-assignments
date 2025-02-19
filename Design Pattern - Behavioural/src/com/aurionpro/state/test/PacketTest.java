package com.aurionpro.state.test;

import com.aurionpro.state.model.Packet;

public class PacketTest {

	public static void main(String[] args) {
		Packet packet = new Packet();
		
		packet.currentState();
		System.out.println();
		packet.goToNextState();
		packet.currentState();
		System.out.println();
		packet.goToNextState();
		packet.currentState();
		System.out.println();
		packet.goToNextState();
		packet.currentState();
		System.out.println();
		packet.goToPreviousState();
		packet.currentState();
		System.out.println();
		packet.goToPreviousState();
		packet.currentState();
		System.out.println();
		packet.goToPreviousState();
		packet.currentState();
		System.out.println();
	}

}
