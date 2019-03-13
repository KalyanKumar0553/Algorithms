package com.src.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class Friend {

	private String mail;

	List<Friend> friends = new ArrayList<Friend>();

	public Friend(String s) {
		this.mail = s;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void addFriend(Friend friend) {
		this.friends.add(friend);
		friend.getFriends().add(this);
	}

	@Override
	public String toString() {
		return this.mail;
	}

	public boolean isConnected(Friend frnd) {
		return isConnected(null, this, frnd);
	}

	public boolean isConnected(Friend parent, Friend curr, Friend frnd) {
		if (frnd == null) {
			return false;
		} else if (this.getFriends().contains(frnd)) {
			return true;
		} else {
			for(int i = 0;i < this.getFriends().size();i++) {
				Friend getCurrFriend =  this.getFriends().get(i);
				if (getCurrFriend != parent) {
					return getCurrFriend.isConnected(curr, getCurrFriend, frnd);
				} else  {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Friend A = new Friend("A");
		Friend B = new Friend("B");
		Friend C = new Friend("C");
		Friend D = new Friend("D");
		Friend E = new Friend("E");
		Friend F = new Friend("F");
		A.addFriend(B);
		A.addFriend(D);
		B.addFriend(C);
		D.addFriend(E);
		System.out.println(">>" + C.isConnected(F));
	}
}
